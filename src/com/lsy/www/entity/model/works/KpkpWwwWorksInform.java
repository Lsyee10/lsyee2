/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.works;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:作品举报
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksInform implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer informId;
	private Integer userId;
	private Integer topicId;
	private Integer photoId;
	private Integer authorId;
	private String reason;
	private Integer dealFlag;
	private Integer recycleFlag;
	private Timestamp addTime;
	private Timestamp dealTime;

	public Integer getInformId() {
		return informId;
	}

	public void setInformId(Integer informId) {
		this.informId = informId;
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

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getDealTime() {
		return dealTime;
	}

	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}