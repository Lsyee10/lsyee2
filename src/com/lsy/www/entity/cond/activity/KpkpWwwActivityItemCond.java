/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.activity;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:活动项目条件
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityItemCond extends KpkpWwwBaseCond {

	private Integer activityId;
	private String name;
	private String tag;
	private Integer bizFlag;
	private Integer[] includeBizFlags;
	private Integer topFlag;
	private Integer pubFlag;
	private Integer freeFlag;
	private Integer limitFlag;
	private Integer appFlag;
	private Integer replyFlag;
	private Integer recycleFlag;
	private Integer adminId;
	private String area;
	private String middleDate;
	private String startDateSt;
	private String startDateEd;
	private String endDateSt;
	private String endDateEd;

	// 参加活动的用户id
	private Integer provideUserId;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public Integer[] getIncludeBizFlags() {
		return includeBizFlags;
	}

	public void setIncludeBizFlags(Integer[] includeBizFlags) {
		this.includeBizFlags = includeBizFlags;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getFreeFlag() {
		return freeFlag;
	}

	public void setFreeFlag(Integer freeFlag) {
		this.freeFlag = freeFlag;
	}

	public Integer getLimitFlag() {
		return limitFlag;
	}

	public void setLimitFlag(Integer limitFlag) {
		this.limitFlag = limitFlag;
	}

	public Integer getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(Integer appFlag) {
		this.appFlag = appFlag;
	}

	public Integer getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(Integer replyFlag) {
		this.replyFlag = replyFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMiddleDate() {
		return middleDate;
	}

	public void setMiddleDate(String middleDate) {
		this.middleDate = middleDate;
	}

	public String getStartDateSt() {
		return startDateSt;
	}

	public void setStartDateSt(String startDateSt) {
		this.startDateSt = startDateSt;
	}

	public String getStartDateEd() {
		return startDateEd;
	}

	public void setStartDateEd(String startDateEd) {
		this.startDateEd = startDateEd;
	}

	public String getEndDateSt() {
		return endDateSt;
	}

	public void setEndDateSt(String endDateSt) {
		this.endDateSt = endDateSt;
	}

	public String getEndDateEd() {
		return endDateEd;
	}

	public void setEndDateEd(String endDateEd) {
		this.endDateEd = endDateEd;
	}

	public Integer getProvideUserId() {
		return provideUserId;
	}

	public void setProvideUserId(Integer provideUserId) {
		this.provideUserId = provideUserId;
	}

}