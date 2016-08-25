/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品标签查询条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTagCond extends KpkpWwwBaseCond {

	private Integer tagId;
	private String name;
	private String nameLk;
	private Integer userId;
	private Integer topFlag;
	private Integer recycleFlag;
	
	// 照片ID
	private Integer photoId;
	
	//订阅用户ID
	private Integer subUserId;
	
	//使用用户ID
	private Integer useUserId;

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

	public String getNameLk() {
		return nameLk;
	}

	public void setNameLk(String nameLk) {
		this.nameLk = nameLk;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getSubUserId() {
		return subUserId;
	}

	public void setSubUserId(Integer subUserId) {
		this.subUserId = subUserId;
	}

	public Integer getUseUserId() {
		return useUserId;
	}

	public void setUseUserId(Integer useUserId) {
		this.useUserId = useUserId;
	}
}