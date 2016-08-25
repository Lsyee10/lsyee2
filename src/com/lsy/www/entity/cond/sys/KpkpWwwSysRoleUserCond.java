/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.sys;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:运维角色用户查询条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwSysRoleUserCond extends KpkpWwwBaseCond {

	private Integer id;
	private Integer roleId;
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}