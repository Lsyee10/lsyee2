/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:活动评委条件
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwActivityJuryCond extends KpkpWwwBaseCond {

	private Integer juryId;
	private Integer activityId;
	private Integer userId;
	private Integer roleFlag;
	private Integer stateFlag;

	public Integer getJuryId() {
		return juryId;
	}

	public void setJuryId(Integer juryId) {
		this.juryId = juryId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}

}