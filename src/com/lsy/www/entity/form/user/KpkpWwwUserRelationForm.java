/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:用户关系表单
 * 
 * @version 1.0 2015年12月21日
 * @author Wu guang jing
 */
public class KpkpWwwUserRelationForm extends KpkpWwwBaseForm {

	private Integer focusId;
	private Integer userId;

	public Integer getFocusId() {
		return focusId;
	}

	public void setFocusId(Integer focusId) {
		this.focusId = focusId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
