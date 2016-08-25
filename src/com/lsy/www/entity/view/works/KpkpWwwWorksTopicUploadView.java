/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

import java.util.List;

/**
 * Description:作品主题视图
 * 
 * @version 1.0 2015年12月4日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTopicUploadView {

	private Integer topicId;
	private Integer userId;
	private Integer taskId;
	private Integer stationId;
	private String title;
	private String intro;
	private String city;
	private List<KpkpWwwWorksPhotoUploadView> photoList;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<KpkpWwwWorksPhotoUploadView> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<KpkpWwwWorksPhotoUploadView> photoList) {
		this.photoList = photoList;
	}

}