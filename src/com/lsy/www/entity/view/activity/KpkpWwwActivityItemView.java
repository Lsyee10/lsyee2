/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description:活动项目详细视图
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwActivityItemView {

	private Integer activityId;
	private String name;
	private String source;
	private String summary;
	private String intro;
	private String prize;
	private String cover1;
	private String cover2;
	private String tag;
	private String area;
	private Integer photos;
	private Integer joins;
	private Integer limits;
	private Integer leftDays;
	private BigDecimal leftPercent;
	private String leftDayDes;
	private BigDecimal origMoney;
	private BigDecimal curMoney;
	private Integer bizFlag;
	private Integer stateFlag;
	private Integer freeFlag;
	private Integer limitFlag;
	private Integer applyFlag;
	private String pubTimeDes;
	private String startDateDes;
	private String endDateDes;
	private KpkpWwwActivityJuryView leader;
	private List<KpkpWwwActivityIntroView> introViews;

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

	public String getCover1() {
		return cover1;
	}

	public void setCover1(String cover1) {
		this.cover1 = cover1;
	}

	public String getCover2() {
		return cover2;
	}

	public void setCover2(String cover2) {
		this.cover2 = cover2;
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

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
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

	public String getLeftDayDes() {
		return leftDayDes;
	}

	public void setLeftDayDes(String leftDayDes) {
		this.leftDayDes = leftDayDes;
	}

	public String getPubTimeDes() {
		return pubTimeDes;
	}

	public void setPubTimeDes(String pubTimeDes) {
		this.pubTimeDes = pubTimeDes;
	}

	public String getStartDateDes() {
		return startDateDes;
	}

	public void setStartDateDes(String startDateDes) {
		this.startDateDes = startDateDes;
	}

	public String getEndDateDes() {
		return endDateDes;
	}

	public void setEndDateDes(String endDateDes) {
		this.endDateDes = endDateDes;
	}

	public Integer getApplyFlag() {
		return applyFlag;
	}

	public void setApplyFlag(Integer applyFlag) {
		this.applyFlag = applyFlag;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getLeftDays() {
		return leftDays;
	}

	public void setLeftDays(Integer leftDays) {
		this.leftDays = leftDays;
	}

	public KpkpWwwActivityJuryView getLeader() {
		return leader;
	}

	public void setLeader(KpkpWwwActivityJuryView leader) {
		this.leader = leader;
	}

	public List<KpkpWwwActivityIntroView> getIntroViews() {
		return introViews;
	}

	public void setIntroViews(List<KpkpWwwActivityIntroView> introViews) {
		this.introViews = introViews;
	}

	public BigDecimal getLeftPercent() {
		return leftPercent;
	}

	public void setLeftPercent(BigDecimal leftPercent) {
		this.leftPercent = leftPercent;
	}

}
