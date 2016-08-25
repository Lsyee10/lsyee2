/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户账号迁移
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserMigrate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private Integer kpwuid;
	private Integer tranFlag;
	private Timestamp tranTime;
	private Timestamp addTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getKpwuid() {
		return kpwuid;
	}

	public void setKpwuid(Integer kpwuid) {
		this.kpwuid = kpwuid;
	}

	public Integer getTranFlag() {
		return tranFlag;
	}

	public void setTranFlag(Integer tranFlag) {
		this.tranFlag = tranFlag;
	}

	public Timestamp getTranTime() {
		return tranTime;
	}

	public void setTranTime(Timestamp tranTime) {
		this.tranTime = tranTime;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
}
