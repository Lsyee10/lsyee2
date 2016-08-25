/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.activity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:活动投票轮数
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteTurn implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer turnId;
	private Integer sn;
	private String name;
	private Integer activityId;
	private Integer allows;
	private Integer stateFlag;
	private Timestamp addTime;
	
	public Integer getTurnId() {
		return turnId;
	}

	public void setTurnId(Integer turnId) {
		this.turnId = turnId;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getAllows() {
		return allows;
	}

	public void setAllows(Integer allows) {
		this.allows = allows;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
}
