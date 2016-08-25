/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.search;


/**
 * Description:搜索活动视图
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwSearchActivityView {

	private Integer activityId;
	private String name;
	private Integer photos;
	private Integer joins;
	private Integer bizFlag;
	private String cover1;

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

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getJoins() {
		return joins;
	}

	public void setJoins(Integer joins) {
		this.joins = joins;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public String getCover1() {
		return cover1;
	}

	public void setCover1(String cover1) {
		this.cover1 = cover1;
	}
}
