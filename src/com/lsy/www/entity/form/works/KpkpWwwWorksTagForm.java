/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.works;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:作品标签表单
 * 
 * @version 1.0 2015年12月21日
 * @author Wu guang jing
 */
public class KpkpWwwWorksTagForm extends KpkpWwwBaseForm {

	private Integer tagId;
	private String tagName;

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

}
