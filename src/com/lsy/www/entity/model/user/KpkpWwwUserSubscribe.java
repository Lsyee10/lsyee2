/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户标签订阅
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserSubscribe implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer subId;
	private Integer userId;
	private Integer tagId;
	private Timestamp subTime;

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Timestamp getSubTime() {
		return subTime;
	}

	public void setSubTime(Timestamp subTime) {
		this.subTime = subTime;
	}
}