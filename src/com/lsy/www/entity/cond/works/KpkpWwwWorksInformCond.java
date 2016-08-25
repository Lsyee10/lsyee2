/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品举报查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksInformCond extends KpkpWwwBaseCond {

	private Integer informId;
	private Integer userId;
	private Integer topicId;
	private Integer photoId;
	private Integer authorId;
	private Integer dealFlag;
	private Integer recycleFlag;

	
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

	public Integer getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}