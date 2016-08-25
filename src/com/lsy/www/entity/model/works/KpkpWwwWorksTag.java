/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.works;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:作品标签
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTag implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tagId;
	private String name;
	private Integer photos;
	private Integer userId;
	private Integer users;
	private String cover1;
	private String cover2;
	private Integer topFlag;
	private Integer recycleFlag;
	private Timestamp topTime;
	private Timestamp addTime;
	
	//订阅与使用
	private Timestamp subTime;
	private Timestamp useTime;

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

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Timestamp getTopTime() {
		return topTime;
	}

	public void setTopTime(Timestamp topTime) {
		this.topTime = topTime;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getSubTime() {
		return subTime;
	}

	public void setSubTime(Timestamp subTime) {
		this.subTime = subTime;
	}

	public Timestamp getUseTime() {
		return useTime;
	}

	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}

}