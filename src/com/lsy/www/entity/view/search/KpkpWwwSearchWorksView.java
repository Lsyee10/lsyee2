/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.search;

/**
 * Description:搜索标签视图
 * 
 * @version 1.0 2015年12月4日
 * @author Wu guang jing
 */
public class KpkpWwwSearchWorksView {

	private Integer tagId;
	private String tagName;
	private Integer photos;
	private Integer users;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getUsers() {
		return users;
	}

	public void setUsers(Integer users) {
		this.users = users;
	}

}
