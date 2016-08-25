/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.activity;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:活动投票表单
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteForm extends KpkpWwwBaseForm {

	private Integer userId;
	private Integer activityId;
	private Integer turnId;
	private Integer photoId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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

}
