/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户业务统计汇总条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserStatsSumCond extends KpkpWwwBaseCond {

	private Integer userId;
	private Integer profileFlag;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProfileFlag() {
		return profileFlag;
	}

	public void setProfileFlag(Integer profileFlag) {
		this.profileFlag = profileFlag;
	}

}