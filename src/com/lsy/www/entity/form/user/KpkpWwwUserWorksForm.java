/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:用户作品表单
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwUserWorksForm extends KpkpWwwBaseForm {

	private Integer photoId;
	private Integer topicId;
	private Integer shooterId;
	private String mode; // 网格模式或列表模式

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getShooterId() {
		return shooterId;
	}

	public void setShooterId(Integer shooterId) {
		this.shooterId = shooterId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
