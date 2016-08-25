/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:活动评选选项条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteOptionCond extends KpkpWwwBaseCond {

	private Integer optionId;
	private Integer turnId;
	private Integer photoId;
	private Integer activityId;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getTurnId() {
		return turnId;
	}

	public void setTurnId(Integer turnId) {
		this.turnId = turnId;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}