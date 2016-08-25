/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户迁移条件
 * 
 * @version 1.0 2015年11月17日
 * @author Wu guang jing
 */
public class KpkpWwwUserMigrateCond extends KpkpWwwBaseCond {
	
	private Integer userId;
	private Integer kpwuid;
	private Integer tranFlag;

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

}
