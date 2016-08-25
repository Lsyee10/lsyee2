/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

import com.lsy.util.SystemContext;

/**
 * Description:活动评选轮数视图
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwActivityTurnView {

	private Integer turnId;
	private Integer sn;
	private String name;
	private Integer allows;
	private Integer activityId;
	private Integer stateFlag;
	private Integer polls;// 已投票数
	private String stateName;
	private Integer optionNum;

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

	public Integer getAllows() {
		return allows;
	}

	public void setAllows(Integer allows) {
		this.allows = allows;
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

	public Integer getPolls() {
		return polls;
	}

	public void setPolls(Integer polls) {
		this.polls = polls;
	}

	public String getStateName() {
		if (null != this.getStateFlag()) {
			return SystemContext.ACTIVITY_STATE.parse(this.stateFlag).getLabel();
		}

		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getOptionNum() {
		return optionNum;
	}

	public void setOptionNum(Integer optionNum) {
		this.optionNum = optionNum;
	}

}
