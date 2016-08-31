/**
 * Project : lsy
 * Copyright (c) Hang Zhou Daily Press Group.
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.user;

import java.util.Map;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.lsy.util.SystemConstant;
import com.lsy.util.SystemContext;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.user.KpkpWwwUserRegisterForm;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description:用户注册控制
 *
 * @author Wu guang jing
 * @version 1.0 2015年12月14日
 */
@Controller("lsyWwwUserRegisterAction")
@Scope("prototype")
public class LsyWwwUserRegisterAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwUserRegisterForm> {
    private static final long serialVersionUID = 1L;

    private KpkpWwwUserRegisterForm model = new KpkpWwwUserRegisterForm();

    public KpkpWwwUserRegisterForm getModel() {
        return model;
    }

    @Resource(name = "lsyWwwUserAccountBiz")
    private LsyWwwUserAccountBiz lsyWwwUserAccountBiz;

    @Override
    public String getActionDealMsg() {
        return super.getActionDealMsg();
    }

    /**
     * 注册准备
     *
     * @return
     * @throws ActionException
     */
    public String prep() throws ActionException {
        return SUCCESS;
    }

    /**
     * 校验用户名包含昵称、手机、邮箱
     *
     * @return
     * @throws ActionException
     */
    public String validUsername() throws ActionException {
        try {
            // 如果用户已存在
            if (this.lsyWwwUserAccountBiz.validUsername(this.model.getUsername())) {
                this.setActionDealMsg(this.getText("lsyWwwUserRegisterAction.validUsername.used"));
            }
            return SUCCESS;
        } catch (BizException be) {
            log.error("validUsername error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("validUsername error", e);
            throw new ActionException(this.getText("action.biz.error"));
        }
    }

    /**
     * 发送验证码
     *
     * @return
     * @throws ActionException
     */
    public String sendAuthCode() throws ActionException {
        String rst = null;
        try {
            // 如果是邮箱验证
            if (null != this.model.getAccept() && this.model.getAccept().indexOf("@") != -1) {
                this.actionDealMsg = "暂不支持邮箱注册";
            } else {
                // 发送验证码
                rst = this.lsyWwwUserAccountBiz.sendAuthCode(0, this.model.getAccept(),
                        SystemContext.USER_AUTH_USE.REGISTER.getValue());

                // 设置返回结果
                this.actionDealMsg = this.getText(rst);
            }
            return SUCCESS;
        } catch (BizException be) {
            log.error("sendAuthCode error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("sendAuthCode error", e);
            throw new ActionException(this.getText("action.biz.error"));
        } finally {
            rst = null;
        }
    }

    /**
     * 注册处理
     *
     * @return
     * @throws ActionException
     */
    public String deal() throws ActionException {
        String checkRst = null;
        String registerRst = null;
        Map<String, KpkpWwwUserSessionView> map = null;
        try {
            // 如果是邮箱验证
            if (null != this.model.getAccept() && this.model.getAccept().indexOf("@") != -1) {
                this.addFieldError("accept", "暂不支持邮箱注册");
                return INPUT;
            }

            // 验证验证码
            checkRst = this.lsyWwwUserAccountBiz.checkAuthCode(this.model.getAccept(), this.model.getAuthCode(),
                    SystemContext.USER_AUTH_USE.REGISTER.getValue());

            // 如果验证成功
            if (LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_SUCCESS.equals(checkRst)) {
                // 用户注册
                map = this.lsyWwwUserAccountBiz.register(this.model.getAccept(), this.model.getNickname(),
                        this.model.getPassword());

                // 如果结果存在
                if (null != map && !map.isEmpty()) {
                    // 获取结果状态
                    registerRst = map.keySet().iterator().next();

                    // 如果昵称已被使用
                    if (LsyWwwUserAccountBiz.REGISTER_RST_NICKNAME_EXIST.equals(registerRst)) {
                        this.addFieldError("nickname", this.getText(registerRst));
                        return INPUT;
                    }
                    // 如果被限制注册
                    else if (LsyWwwUserAccountBiz.REGISTER_RST_LIMIT.equals(registerRst)) {
                        this.addFieldError("accept", this.getText(registerRst));
                        return INPUT;
                    } else {
                        // 记录用户会话视图
                        this.getSession().put(SystemConstant.SESSION_USER,
                                map.get(LsyWwwUserAccountBiz.REGISTER_RST_SUCCESS));
                        return SUCCESS;
                    }
                }
                // 如果注册失败
                else {
                    return ERROR;
                }
            }
            // 如果验证失败
            else {
                this.addFieldError("authCode", this.getText(checkRst));
                return INPUT;
            }
        } catch (BizException be) {
            log.error("dealFill error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("dealFill error", e);
            throw new ActionException(this.getText("action.biz.error"));
        } finally {
            map = null;
            checkRst = null;
            registerRst = null;
        }
    }
}
