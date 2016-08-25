/**
 * 
 */
package com.lsy.www.ctrl.action.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.kit.word.StringHelper;
import com.lsy.util.SystemConstant;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.user.KpkpWwwUserLoginForm;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Description:用户登录控制
 *
 * @version 1.0 2016年5月10日
 * @author LSY
 */
@Controller("lsyWwwUserLoginAction")
@Scope("prototype")
public class LsyWwwUserLoginAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwUserLoginForm> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "lsyWwwUserAccountBiz")
	private LsyWwwUserAccountBiz lsyWwwUserAccountBiz;

	private KpkpWwwUserLoginForm model = new KpkpWwwUserLoginForm();

	@Override
	public KpkpWwwUserLoginForm getModel() {
		return this.model;
	}

	/**
	 * 准备登陆
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String prep() throws ActionException {
		return SUCCESS;
	}

	/**
	 * 执行登陆
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String deal() throws ActionException {
		String state = null;
		KpkpWwwUserSessionView sessView = null;
		Map<String, KpkpWwwUserSessionView> map = null;
		try {
			// 如果验证码不存在
			if (null == this.getSession().get(SystemConstant.SESSION_VALID_CODE)) {
				return INPUT;
			}
			// 如果验证码为空
			else if (StringHelper.ifNull(this.model.getAuthCode())) {
				this.addFieldError("authCode", this.getText("kpkpWwwUserLoginAction.deal.authCodeNone"));
				return INPUT;
			}
			// 如果验证码不正确
			else if (!this.getSession().get(SystemConstant.SESSION_VALID_CODE).toString()
					.equals(this.model.getAuthCode())) {
				// 重置验证码
				this.getSession().put(SystemConstant.SESSION_VALID_CODE, null);
				this.addFieldError("authCode", this.getText("kpkpWwwUserLoginAction.deal.authCodeError"));
				return INPUT;
			}
			// 校验通过
			else {
				// 重置验证码
				this.getSession().put(SystemConstant.SESSION_VALID_CODE, null);

				// 获取登陆结果
				map = this.lsyWwwUserAccountBiz.login(this.model.getUsername(), this.model.getPassword());

				// 如果结果存在
				if (null != map && !map.isEmpty()) {
					// 获取结果状态
					state = map.keySet().iterator().next();

					// 如果登陆失败
					if (LsyWwwUserAccountBiz.LOGIN_RST_FAILURE.equals(state)) {
						this.addFieldError("authCode", this.getText(state));
						return INPUT;
					} else {
						// 记录当前用户会话
						sessView = map.get(state);
						this.getSession().put(SystemConstant.SESSION_USER, sessView);

						// 如果有访问跳转请求
						if (!StringHelper.ifNull(this.model.getUrl())) {
							this.model.setUrl(this.model.getUrl().replace("$", "&"));
							return SUCCESS;
						} else {
							return LOGIN;
						}

					}
					// 如果登陆业务错误
				} else {
					return ERROR;
				}
			}

		} catch (BizException be) {
			log.error("deal err", be);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("deal err", e);
			throw new ActionException(this.getText("action.biz.error"));
		} finally {
			state = null;
			sessView = null;
			map = null;
		}
	}

	/**
	 * 退出
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String exit() throws ActionException {
		try {
			// 退出并清除session中的用户
			this.getSession().remove(SystemConstant.SESSION_USER);
			this.getSession().clear();

			return SUCCESS;
		} catch (Exception e) {
			log.error("exit err", e);
			throw new ActionException(this.getText("action.biz.error"));
		}
	}
}
