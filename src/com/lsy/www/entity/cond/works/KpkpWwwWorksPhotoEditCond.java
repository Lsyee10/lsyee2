/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品照片编辑条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoEditCond extends KpkpWwwBaseCond {

	private Integer editId;
	private Integer photoId;
	private Integer authorId;
	private Integer editFlag;
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

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}