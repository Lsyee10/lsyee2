/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品主题条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTopicCond extends KpkpWwwBaseCond {

	private Integer topicId;
	private Integer userId;
	private Integer taskId;
	private Integer stationId;
	private Integer recycleFlag;
	private Integer topFlag;

	// 用户ID关注过摄影师的照片
	private Integer focusUserId;

	// 觉得是否与用户账号联合查询
	private Integer profileFlag;

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getFocusUserId() {
		return focusUserId;
	}

	public void setFocusUserId(Integer focusUserId) {
		this.focusUserId = focusUserId;
	}

	public Integer getProfileFlag() {
		return profileFlag;
	}

	public void setProfileFlag(Integer profileFlag) {
		this.profileFlag = profileFlag;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

}