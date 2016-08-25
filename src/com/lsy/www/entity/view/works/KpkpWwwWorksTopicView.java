/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

import java.util.List;
import java.util.Map;

/**
 * Description:作品主题视图
 * 
 * @version 1.0 2015年12月4日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTopicView {

	private Integer topicId;
	private Integer userId;
	private String nickname;
	private String avatar;
	private Integer taskId;
	private Integer stationId;
	private String taskName;
	private String stationName;
	private String title;
	private String intro;
	private Integer views;
	private Integer praises;
	private Integer photos;
	private Integer comments;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String province;
	private String city;
	private String country;
	private Double latitude;
	private Double longitude;
	private String location;
	private String addTimeDes;
	private Integer addDayDes;
	private Integer addMonthDes;
	private Map<Integer, String> options;
	private List<KpkpWwwWorksPhotoView> photoList;

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
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

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public List<KpkpWwwWorksPhotoView> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<KpkpWwwWorksPhotoView> photoList) {
		this.photoList = photoList;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAddDayDes() {
		return addDayDes;
	}

	public void setAddDayDes(Integer addDayDes) {
		this.addDayDes = addDayDes;
	}

	public Integer getAddMonthDes() {
		return addMonthDes;
	}

	public void setAddMonthDes(Integer addMonthDes) {
		this.addMonthDes = addMonthDes;
	}

	public Map<Integer, String> getOptions() {
		return options;
	}

	public void setOptions(Map<Integer, String> options) {
		this.options = options;
	}
}