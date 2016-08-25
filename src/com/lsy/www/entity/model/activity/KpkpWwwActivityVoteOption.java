/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.activity;

import java.io.Serializable;

/**
 * Description:活动评选选项
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteOption implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer optionId;
	private Integer turnId;
	private Integer photoId;
	private Integer activityId;
	private Integer polls;

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

	public Integer getPolls() {
		return polls;
	}

	public void setPolls(Integer polls) {
		this.polls = polls;
	}

}
