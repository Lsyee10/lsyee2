/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.activity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Description:活动项目
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer activityId;
	private String name;
	private String source;
	private String summary;
	private String prize;
	private String cover1;
	private String cover2;
	private Integer points;
	private Integer photos;
	private Integer joins;
	private Integer limits;
	private Date startDate;
	private Date endDate;
	private BigDecimal origMoney;
	private BigDecimal curMoney;
	private String tag;
	private String area;
	private Integer bizFlag;
	private Integer topFlag;
	private Integer pubFlag;
	private Integer freeFlag;
	private Integer limitFlag;
	private Integer voteFlag;
	private Integer appFlag;
	private Integer replyFlag;
	private Integer recycleFlag;
	private Timestamp topTime;
	private Timestamp pubTime;
	private Timestamp addTime;
	private Integer adminId;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getCover1() {
		return cover1;
	}

	public void setCover1(String cover1) {
		this.cover1 = cover1;
	}

	public void setCover2(String cover2) {
		this.cover2 = cover2;
	}

	public String getCover2() {
		return cover2;
	}

	public void setCouver2(String cover2) {
		this.cover2 = cover2;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
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

	public Integer getLimits() {
		return limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getOrigMoney() {
		return origMoney;
	}

	public void setOrigMoney(BigDecimal origMoney) {
		this.origMoney = origMoney;
	}

	public BigDecimal getCurMoney() {
		return curMoney;
	}

	public void setCurMoney(BigDecimal curMoney) {
		this.curMoney = curMoney;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
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

	public Integer getVoteFlag() {
		return voteFlag;
	}

	public void setVoteFlag(Integer voteFlag) {
		this.voteFlag = voteFlag;
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

	public Timestamp getTopTime() {
		return topTime;
	}

	public void setTopTime(Timestamp topTime) {
		this.topTime = topTime;
	}

	public Timestamp getPubTime() {
		return pubTime;
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(Integer appFlag) {
		this.appFlag = appFlag;
	}

}
