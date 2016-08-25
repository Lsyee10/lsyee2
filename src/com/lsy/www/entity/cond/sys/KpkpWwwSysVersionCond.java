/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.sys;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:系统版本查询条件
 * 
 * @version 1.0 2015年11月13日
 * @author Wu guang jing
 */
public class KpkpWwwSysVersionCond extends KpkpWwwBaseCond {

	private Integer versionId;
	private Integer appFlag;
	private Integer pubFlag;
	private Integer recycleFlag;

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public Integer getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(Integer appFlag) {
		this.appFlag = appFlag;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}
