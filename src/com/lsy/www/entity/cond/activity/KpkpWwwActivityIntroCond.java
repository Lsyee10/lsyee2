/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:活动描述条件
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwActivityIntroCond extends KpkpWwwBaseCond {

	private Integer introId;
	private Integer activityId;

	public Integer getIntroId() {
		return introId;
	}

	public void setIntroId(Integer introId) {
		this.introId = introId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
}