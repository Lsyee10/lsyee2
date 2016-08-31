/**
 * Project : Lsy
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.user;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.lsy.util.SystemContext;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.user.KpkpWwwUserPasswordForm;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description:用户密码动作控制
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
@Controller("lsyWwwUserPasswordAction")
@Scope("prototype")
public class LsyWwwUserPasswordAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwUserPasswordForm> {
	protected static final long serialVersionUID;

	static {
		serialVersionUID = 1L;
	}

	KpkpWwwUserPasswordForm model = new KpkpWwwUserPasswordForm();

	public KpkpWwwUserPasswordForm getModel() {
		return model;
	}

	@Resource(name = "lsyWwwUserAccountBiz")
	private LsyWwwUserAccountBiz LsyWwwUserAccountBiz;

	@Override
	public String getActionDealMsg() {
		return super.getActionDealMsg();
	}

	/**
	 * 准备编辑，用户准备找回密码和修改密码
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String prepEdit() throws ActionException {
		return SUCCESS;
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
			// 发送验证码
			rst = this.LsyWwwUserAccountBiz.sendAuthCode(0, this.model.getAccept(),
					SystemContext.USER_AUTH_USE.FIND_PASSWORD.getValue());
			this.actionDealMsg = this.getText(rst);
			return SUCCESS;
		} catch (BizException be) {
			log.error("prepBind error", be);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("prepBind error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		} finally {
			rst = null;
		}
	}

	/**
	 * 执行找回密码
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String dealFind() throws ActionException {
		String checkRst = null;
		try {
			// 获取验证结果
			checkRst = this.LsyWwwUserAccountBiz.checkAuthCode(this.model.getAccept(), this.model.getAuthCode(),
					SystemContext.USER_AUTH_USE.FIND_PASSWORD.getValue());

			// 如果验证通过
			if (LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_SUCCESS.equals(checkRst)) {

				// 如果密码找回成功
				if (this.LsyWwwUserAccountBiz.findPassword(this.model.getAccept(), this.model.getNewPassword())) {
					return SUCCESS;
				} else {
					this.addActionError("LsyWwwUserPasswordAction.dealFind.account.none");
					return ERROR;
				}
			} else {
				this.addFieldError("authCode", this.getText(checkRst));
				return INPUT;
			}
		} catch (BizException be) {
			log.error("dealFind error", be);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("dealFind error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		} finally {
			checkRst = null;
		}
	}

	/**
	 * 执行修改密码
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String dealModify() throws ActionException {
		try {
			// 如果密码修改成功
			if (this.LsyWwwUserAccountBiz.modifyPassword(this.getUserSession().getUserId(),
					this.model.getNewPassword(), this.model.getOldPassword())) {
				return SUCCESS;
			} else {
				this.addFieldError("oldPassword", this.getText("LsyWwwUserPasswordAction.dealModify.password.error"));
				return INPUT;
			}
		} catch (BizException be) {
			log.error("dealModify error", be);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("dealModify error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		}
	}
}
