/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.sys;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kit.exception.ActionException;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;

/**
 * Description: 结果控制动作
 *
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
@Controller("lsyWwwSysReturnAction")
@Scope("prototype")
public class LsyWwwSysReturnAction extends LsyWwwBaseAction {
	private static final long serialVersionUID = 1L;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 结果
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String result() throws ActionException {
		return SUCCESS;
	}
}
