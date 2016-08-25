/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.activity;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:活动报名表单
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwActivityApplyForm extends KpkpWwwBaseForm {

	private Integer applyId;
	private Integer userId;
	private Integer activityId;
	private String orderNum;
	private String orderScan;
	private String nickname;
	private String realname;
	private String cellphone;
	private String email;
	private String remark;
	private Integer stateFlag;

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

	public String getOrderScan() {
		return orderScan;
	}

	public void setOrderScan(String orderScan) {
		this.orderScan = orderScan;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}

}
