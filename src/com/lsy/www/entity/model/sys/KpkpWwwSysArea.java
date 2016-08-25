/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.sys;

import java.io.Serializable;

/**
 * Description:运维地区数据
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwSysArea implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String parentCode;
	private Integer level;
	private String name;
	private Integer recycleFlag;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}
