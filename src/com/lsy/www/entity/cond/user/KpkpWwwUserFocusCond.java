/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户关注查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserFocusCond extends KpkpWwwBaseCond {

	private Integer focusId;
	private Integer userId;
	private Integer shooterId;

	public void setFocusId(Integer focusId) {
		this.focusId = focusId;
	}

	public Integer getFocusId() {
		return focusId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShooterId() {
		return shooterId;
	}

	public void setShooterId(Integer shooterId) {
		this.shooterId = shooterId;
	}

}