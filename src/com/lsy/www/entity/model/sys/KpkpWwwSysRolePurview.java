/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.sys;

import java.io.Serializable;

/**
 * Description:运维角色权限
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwSysRolePurview implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer roleId;
	private Integer purviewId;

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

	public Integer getPurviewId() {
		return purviewId;
	}

	public void setPurviewId(Integer purviewId) {
		this.purviewId = purviewId;
	}

}