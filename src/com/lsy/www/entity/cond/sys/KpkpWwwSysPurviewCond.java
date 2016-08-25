/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.sys;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:运维权限条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwSysPurviewCond extends KpkpWwwBaseCond {

	private Integer purviewId;
	private String code;
	private String parent;
	private Integer level;
	private String handle;
	private Integer recycleFlag;
	private Integer addminId;

	public Integer getPurviewId() {
		return purviewId;
	}

	public void setPurviewId(Integer purviewId) {
		this.purviewId = purviewId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getAddminId() {
		return addminId;
	}

	public void setAddminId(Integer addminId) {
		this.addminId = addminId;
	}

}