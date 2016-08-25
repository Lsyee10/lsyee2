/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

import java.util.List;

/**
 * Description:作品标签视图
 * 
 * @version 1.0 2015年12月4日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTagView {

	private Integer tagId;
	private String name;
	private Integer photos;
	private Integer userId;
	private Integer users;
	private String cover1;
	private String cover2;
	private Integer topFlag;
	private Integer subFlag;

	// 标签下属照片
	private List<KpkpWwwWorksPhotoView> newestPhotoList;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUsers() {
		return users;
	}

	public void setUsers(Integer users) {
		this.users = users;
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

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public List<KpkpWwwWorksPhotoView> getNewestPhotoList() {
		return newestPhotoList;
	}

	public void setNewestPhotoList(List<KpkpWwwWorksPhotoView> newestPhotoList) {
		this.newestPhotoList = newestPhotoList;
	}

	public Integer getSubFlag() {
		return subFlag;
	}

	public void setSubFlag(Integer subFlag) {
		this.subFlag = subFlag;
	}

}
