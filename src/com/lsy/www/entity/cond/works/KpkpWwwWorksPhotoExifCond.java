/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.works;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:作品照片EXIF信息条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoExifCond extends KpkpWwwBaseCond {

	private Integer photoId;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

}