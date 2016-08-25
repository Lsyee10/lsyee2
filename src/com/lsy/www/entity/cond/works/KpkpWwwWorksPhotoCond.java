/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品照片查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoCond extends KpkpWwwBaseCond {

	private Integer photoId;
	private Integer photoIdGt;
	private Integer photoIdLte;
	private Integer userId;
	private Integer topicId;
	private Integer taskId;
	private Integer stationId;
	private String country;
	private String province;
	private String city;
	private String location;
	private Double leftTopPointLat;
	private Double leftTopPointLng;
	private Double rightBotPointLat;
	private Double rightBotPointLng;
	private Integer topFlag;
	private Integer starFlag;
	private Integer coverFlag;
	private Integer awardFlag;
	private Integer choiceFlag;
	private Integer recycleFlag;
	private String choiceTimeSt;
	private String choiceTimeEd;

	// 标签ID
	private Integer tagId;

	// 用户ID点赞过的照片
	private Integer praiseUserId;

	// 用户ID关注过摄影师的照片
	private Integer focusUserId;

	// 精选、获取等编辑操作的时间间隔
	private String editAddTimeSt;

	// 获取用户资料标示，用于连接查询
	private Integer profileFlag;

	// 小于等于每日之星日期
	private String starDateEd;

	// 评选轮数、票数
	private Integer voteTurnId;
	private Integer votePolls;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getPhotoIdGt() {
		return photoIdGt;
	}

	public void setPhotoIdGt(Integer photoIdGt) {
		this.photoIdGt = photoIdGt;
	}

	public Integer getPhotoIdLte() {
		return photoIdLte;
	}

	public void setPhotoIdLte(Integer photoIdLte) {
		this.photoIdLte = photoIdLte;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLeftTopPointLat() {
		return leftTopPointLat;
	}

	public void setLeftTopPointLat(Double leftTopPointLat) {
		this.leftTopPointLat = leftTopPointLat;
	}

	public Double getLeftTopPointLng() {
		return leftTopPointLng;
	}

	public void setLeftTopPointLng(Double leftTopPointLng) {
		this.leftTopPointLng = leftTopPointLng;
	}

	public Double getRightBotPointLat() {
		return rightBotPointLat;
	}

	public void setRightBotPointLat(Double rightBotPointLat) {
		this.rightBotPointLat = rightBotPointLat;
	}

	public Double getRightBotPointLng() {
		return rightBotPointLng;
	}

	public void setRightBotPointLng(Double rightBotPointLng) {
		this.rightBotPointLng = rightBotPointLng;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public Integer getChoiceFlag() {
		return choiceFlag;
	}

	public void setChoiceFlag(Integer choiceFlag) {
		this.choiceFlag = choiceFlag;
	}

	public Integer getStarFlag() {
		return starFlag;
	}

	public void setStarFlag(Integer starFlag) {
		this.starFlag = starFlag;
	}

	public Integer getCoverFlag() {
		return coverFlag;
	}

	public void setCoverFlag(Integer coverFlag) {
		this.coverFlag = coverFlag;
	}

	public Integer getAwardFlag() {
		return awardFlag;
	}

	public void setAwardFlag(Integer awardFlag) {
		this.awardFlag = awardFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getPraiseUserId() {
		return praiseUserId;
	}

	public void setPraiseUserId(Integer praiseUserId) {
		this.praiseUserId = praiseUserId;
	}

	public Integer getFocusUserId() {
		return focusUserId;
	}

	public void setFocusUserId(Integer focusUserId) {
		this.focusUserId = focusUserId;
	}

	public Integer getProfileFlag() {
		return profileFlag;
	}

	public void setProfileFlag(Integer profileFlag) {
		this.profileFlag = profileFlag;
	}

	public String getEditAddTimeSt() {
		return editAddTimeSt;
	}

	public void setEditAddTimeSt(String editAddTimeSt) {
		this.editAddTimeSt = editAddTimeSt;
	}

	public String getStarDateEd() {
		return starDateEd;
	}

	public void setStarDateEd(String starDateEd) {
		this.starDateEd = starDateEd;
	}

	public Integer getVoteTurnId() {
		return voteTurnId;
	}

	public void setVoteTurnId(Integer voteTurnId) {
		this.voteTurnId = voteTurnId;
	}

	public Integer getVotePolls() {
		return votePolls;
	}

	public void setVotePolls(Integer votePolls) {
		this.votePolls = votePolls;
	}

	public String getChoiceTimeSt() {
		return choiceTimeSt;
	}

	public void setChoiceTimeSt(String choiceTimeSt) {
		this.choiceTimeSt = choiceTimeSt;
	}

	public String getChoiceTimeEd() {
		return choiceTimeEd;
	}

	public void setChoiceTimeEd(String choiceTimeEd) {
		this.choiceTimeEd = choiceTimeEd;
	}

}