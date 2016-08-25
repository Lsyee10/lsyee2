/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import java.sql.Date;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户业务日统计条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwUserStatsDayCond extends KpkpWwwBaseCond {

	private Integer id;
	private Integer userId;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}