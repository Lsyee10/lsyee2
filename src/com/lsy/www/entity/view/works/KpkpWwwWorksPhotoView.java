/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

import java.util.Map;

/**
 * Description:作品照片视图
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoView {

	private Integer photoId;
	private Integer userId;
	private Integer topicId;
	private Integer taskId;
	private Integer stationId;
	private String taskName;
	private String stationName;
	private String nickname;
	private String avatar;
	private String intro;
	private Integer views;
	private Integer praises;
	private Integer comments;
	private String img2;
	private String img3;
	private String img4;
	private String country;
	private String city;
	private String province;
	private String location;
	private Double latitude;
	private Double longitude;
	private Integer praiseFlag;
	private Integer focusFlag;
	private Integer starFlag;
	private String starDateDes;
	private String addTimeDes;
	private String addDayDes;
	private String addMonthDes;
	private String starIntro;
	private Integer choiceFlag;
	private Integer awardFlag;
	private String awardPrize;
	private String effect;
	private Integer votePolls;
	private Integer voteFlag;
	private Map<Integer, String> options;
	private KpkpWwwWorksPhotoExifView exif;

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

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntro() {
//		return StringHelper.ifNull(intro) ? "&nbsp;" : intro;
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Integer getPraiseFlag() {
		return praiseFlag;
	}

	public void setPraiseFlag(Integer praiseFlag) {
		this.praiseFlag = praiseFlag;
	}

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}

	public Integer getStarFlag() {
		return starFlag;
	}

	public void setStarFlag(Integer starFlag) {
		this.starFlag = starFlag;
	}

	public String getStarDateDes() {
		return starDateDes;
	}

	public void setStarDateDes(String starDateDes) {
		this.starDateDes = starDateDes;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public String getStarIntro() {
		return starIntro;
	}

	public void setStarIntro(String starIntro) {
		this.starIntro = starIntro;
	}

	public Integer getChoiceFlag() {
		return choiceFlag;
	}

	public void setChoiceFlag(Integer choiceFlag) {
		this.choiceFlag = choiceFlag;
	}

	public Integer getAwardFlag() {
		return awardFlag;
	}

	public void setAwardFlag(Integer awardFlag) {
		this.awardFlag = awardFlag;
	}

	public String getAwardPrize() {
		return awardPrize;
	}

	public void setAwardPrize(String awardPrize) {
		this.awardPrize = awardPrize;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Integer getVotePolls() {
		return votePolls;
	}

	public void setVotePolls(Integer votePolls) {
		this.votePolls = votePolls;
	}

	public Integer getVoteFlag() {
		return voteFlag;
	}

	public void setVoteFlag(Integer voteFlag) {
		this.voteFlag = voteFlag;
	}

	public String getAddDayDes() {
		return addDayDes;
	}

	public void setAddDayDes(String addDayDes) {
		this.addDayDes = addDayDes;
	}

	public String getAddMonthDes() {
		return addMonthDes;
	}

	public void setAddMonthDes(String addMonthDes) {
		this.addMonthDes = addMonthDes;
	}

	public Map<Integer, String> getOptions() {
		return options;
	}

	public void setOptions(Map<Integer, String> options) {
		this.options = options;
	}

	public KpkpWwwWorksPhotoExifView getExif() {
		return exif;
	}

	public void setExif(KpkpWwwWorksPhotoExifView exif) {
		this.exif = exif;
	}

}
