/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.activity;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:任务表单
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityTaskForm extends KpkpWwwBaseForm {

	private Integer activityId;
	private Integer stateFlag;

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
