/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.works;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:作品照片编辑
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoEdit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer editId;
	private Integer photoId;
	private Integer authorId;
	private Integer editFlag;
	private Timestamp addTime;
	private Integer adminId;

	public Integer getEditId() {
		return editId;
	}

	public void setEditId(Integer editId) {
		this.editId = editId;
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

	public Integer getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}