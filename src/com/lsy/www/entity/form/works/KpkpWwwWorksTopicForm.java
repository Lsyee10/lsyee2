/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.works;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:作品主题表单
 * 
 * @version 1.0 2015年12月4日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTopicForm extends KpkpWwwBaseForm {

	private Integer topicId;
	private Integer userId;
	private String nickname;
	private Integer taskId;
	private Integer stationId;
	private String title;
	private String intro;
	private String province;
	private String city;
	private String country;
	private Double latitude;
	private Double longitude;
	private String location;
	private String photoJson;
	private String mode;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public String getPhotoJson() {
		return photoJson;
	}

	public void setPhotoJson(String photoJson) {
		this.photoJson = photoJson;
	}

	public String getMode() {
		if(null==mode){
			return "grid";
		}
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
