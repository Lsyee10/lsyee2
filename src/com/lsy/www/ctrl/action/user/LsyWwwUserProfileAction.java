/**
 * Project : lsy
 * Copyright (c) Hang Zhou Daily Press Group.
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.user;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.user.KpkpWwwUserProfileForm;
import com.lsy.www.entity.view.user.KpkpWwwUserProfileView;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description:用户资料动作控制
 *
 * @author Wu guang jing
 * @version 1.0 2015年12月15日
 */
@Controller("lsyWwwUserProfileAction")
@Scope("prototype")
public class LsyWwwUserProfileAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwUserProfileForm> {
    private static final long serialVersionUID = 1L;

    KpkpWwwUserProfileForm model = new KpkpWwwUserProfileForm();

    public KpkpWwwUserProfileForm getModel() {
        return model;
    }

    @Resource(name = "lsyWwwUserAccountBiz")
    private LsyWwwUserAccountBiz lsyWwwUserAccountBiz;

    private KpkpWwwUserProfileView userProfileView;

    public KpkpWwwUserProfileView getUserProfileView() {
        return userProfileView;
    }

    /**
     * 获取用户概要
     *
     * @return
     * @throws ActionException
     */
    public String summary() throws ActionException {
        try {
            // 如果会话存在
            if (null == this.getUserSession()) {
                // 获取用户资料
                this.userProfileView = this.lsyWwwUserAccountBiz.profile(this.model.getUserId());
            } else if (null == this.model.getUserId()) {
                // 获取用户资料
                this.userProfileView = this.lsyWwwUserAccountBiz.profile(this.getUserSession().getUserId());
            } else {
                // 获取用户资料
                this.userProfileView = this.lsyWwwUserAccountBiz.profile(this.getUserSession().getUserId(),
                        this.model.getUserId());
            }

            // 如果资料存在
            if (null != this.userProfileView) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        } catch (BizException be) {
            log.error("profile error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("profile error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 执行编辑
     *
     * @return
     * @throws ActionException
     */
    public String dealModify() throws ActionException {
        try {
            // 更新用户资料
            if (this.lsyWwwUserAccountBiz.modifyProfile(this.getUserSession().getUserId(), this.model.getNickname(),
                    this.model.getIntro(), this.model.getCity())) {
                return SUCCESS;
            } else {
                this.addFieldError("nickname", this.getText("lsyWwwUserProfileAction.dealEdit.nickname.exist"));
                return INPUT;
            }
        } catch (BizException be) {
            log.error("dealEdit error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("dealEdit error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

}
