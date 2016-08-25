/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

import java.math.BigDecimal;

/**
 * Description:活动报名视图
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwActivityApplyView {

	private Integer applyId;
	private Integer userId;
	private Integer activityId;
	private String activityName;
	private String intro;
	private String orderNum;
	private String orderScan;
	private Integer selectFlag;
	private Integer confirmFlag;
	private Integer tradeFlag;
	private Integer provideFlag;
	private BigDecimal tradeMoney;
	private String avatar;
	private String nickname;
	private String realname;
	private String cellphone;
	private String email;
	private String remark;
	private String addTimeDes;
	private Integer topics;
	private Integer focus;
	private Integer fans;
	private Integer focusFlag;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getTopics() {
		return topics;
	}

	public void setTopics(Integer topics) {
		this.topics = topics;
	}

	public Integer getFocus() {
		return focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}

}
