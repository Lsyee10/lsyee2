/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.works;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Description:作品照片
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhoto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer photoId;
	private Integer userId;
	private Integer topicId;
	private Integer taskId;
	private Integer stationId;
	private String intro;
	private Integer sn;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private Integer views;
	private Integer praises;
	private Integer comments;
	private String country;
	private String province;
	private String city;
	private Double latitude;
	private Double longitude;
	private String location;
	private String effect;
	private Integer choiceFlag;
	private Timestamp choiceTime;
	private Integer awardFlag;
	private Timestamp awardTime;
	private String awardPrize;
	private Integer starFlag;
	private Date starDate;
	private String starIntro;
	private Timestamp starTime;
	private Integer topFlag;
	private Timestamp topTime;
	private Integer coverFlag;
	private Integer recycleFlag;
	private Timestamp addTime;

	// 用户账号信息
	private String avatar;
	private String nickname;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getPraises() {
		return praises;
	}

	public void setPraises(Integer praises) {
		this.praises = praises;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getChoiceFlag() {
		return choiceFlag;
	}

	public void setChoiceFlag(Integer choiceFlag) {
		this.choiceFlag = choiceFlag;
	}

	public Timestamp getChoiceTime() {
		return choiceTime;
	}

	public void setChoiceTime(Timestamp choiceTime) {
		this.choiceTime = choiceTime;
	}

	public Integer getAwardFlag() {
		return awardFlag;
	}

	public void setAwardFlag(Integer awardFlag) {
		this.awardFlag = awardFlag;
	}

	public Timestamp getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(Timestamp awardTime) {
		this.awardTime = awardTime;
	}

	public String getAwardPrize() {
		return awardPrize;
	}

	public void setAwardPrize(String awardPrize) {
		this.awardPrize = awardPrize;
	}

	public Integer getStarFlag() {
		return starFlag;
	}

	public void setStarFlag(Integer starFlag) {
		this.starFlag = starFlag;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public String getStarIntro() {
		return starIntro;
	}

	public void setStarIntro(String starIntro) {
		this.starIntro = starIntro;
	}

	public Timestamp getStarTime() {
		return starTime;
	}

	public void setStarTime(Timestamp starTime) {
		this.starTime = starTime;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public Timestamp getTopTime() {
		return topTime;
	}

	public void setTopTime(Timestamp topTime) {
		this.topTime = topTime;
	}

	public Integer getCoverFlag() {
		return coverFlag;
	}

	public void setCoverFlag(Integer coverFlag) {
		this.coverFlag = coverFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
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

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}