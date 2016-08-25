/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:活动投票轮数条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteTurnCond extends KpkpWwwBaseCond {

	private Integer turnId;
	private Integer activityId;
	private Integer stateFlag;

	public Integer getTurnId() {
		return turnId;
	}

	public void setTurnId(Integer turnId) {
		this.turnId = turnId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}
}