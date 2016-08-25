/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.activity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:活动评委
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityJury implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer juryId;
	private Integer activityId;
	private Integer userId;
	private Integer roleFlag;
	private Integer stateFlag;
	private Timestamp addTime;

	// 用户资料相关
	private String nickname;
	private String avatar;

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

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
