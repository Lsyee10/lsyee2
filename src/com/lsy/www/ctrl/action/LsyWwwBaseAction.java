/**
 * 
 */
package com.lsy.www.ctrl.action;

import java.util.Map;

import org.apache.commons.logging.LogFactory;

import com.kit.logger.SystemLog;
import com.lsy.util.SystemConstant;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Description:基础动作
 *
 * @version 1.0 2016年4月20日
 * @author LSY
 */
public class LsyWwwBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// 日志
	protected SystemLog log = (SystemLog) LogFactory.getLog(getClass());

	// 处理结果
	public Integer actionDealFlag;
	public String actionDealMsg;

	public Integer getActionDealFlag() {
		return actionDealFlag;
	}

	public void setActionDealFlag(Integer actionDealFlag) {
		this.actionDealFlag = actionDealFlag;
	}

	public String getActionDealMsg() {
		return actionDealMsg;
	}

	public void setActionDealMsg(String actionDealMsg) {
		this.actionDealMsg = actionDealMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		return SUCCESS;
	}

	/**
	 * 获取会话对象
	 * 
	 * @return
	 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	/**
	 * 获取用户会话视图
	 * 
	 * @return
	 */
	public KpkpWwwUserSessionView getUserSession() {
		return (KpkpWwwUserSessionView) this.getSession().get(SystemConstant.SESSION_USER);
	}

	/**
	 * 获取请求对象
	 * 
	 * @return
	 */
	public Map<String, Object> getRequest() {
		return ActionContext.getContext().getParameters();
	}

	/**
	 * 获取应用对象
	 * 
	 * @return
	 */
	public Map<String, Object> getApplication() {
		return ActionContext.getContext().getApplication();
	}

}
