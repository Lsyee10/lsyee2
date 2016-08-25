/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;


/**
 * Description:活动报名条件
 * 
 * @version 1.0 2015���11���25���
 * @author Wu guang jing
 * 
 */
public class KpkpWwwActivityApplyCond extends KpkpWwwBaseCond {

	private Integer applyId;
	private Integer userId;
	private Integer activityId;
	private String orderNum;
	private Integer selectFlag;
	private Integer confirmFlag;
	private Integer tradeFlag;
	private Integer provideFlag;
	private String nickname;
	private String realname;
	private String cellphone;
	private String email;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

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

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(Integer selectFlag) {
		this.selectFlag = selectFlag;
	}

	public Integer getConfirmFlag() {
		return confirmFlag;
	}

	public void setConfirmFlag(Integer confirmFlag) {
		this.confirmFlag = confirmFlag;
	}

	public Integer getTradeFlag() {
		return tradeFlag;
	}

	public void setTradeFlag(Integer tradeFlag) {
		this.tradeFlag = tradeFlag;
	}

	public Integer getProvideFlag() {
		return provideFlag;
	}

	public void setProvideFlag(Integer provideFlag) {
		this.provideFlag = provideFlag;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}