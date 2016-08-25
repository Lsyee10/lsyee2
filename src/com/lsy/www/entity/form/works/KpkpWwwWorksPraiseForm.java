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
public class KpkpWwwWorksPraiseForm extends KpkpWwwBaseForm {

	private Integer praiseId;
	private Integer userId;
	private Integer topicId;
	private Integer photoId;
	private Integer authorId;

	public Integer getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(Integer praiseId) {
		this.praiseId = praiseId;
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

}
