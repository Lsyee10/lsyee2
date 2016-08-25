/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.push;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:推送链接条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwPushLinkCond extends KpkpWwwBaseCond {

	private Integer linkId;
	private Integer pubFlag;
	private Integer pageFlag;
	private Integer posFlag;
	private Integer recycleFlag;
	private Integer adminId;

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(Integer pageFlag) {
		this.pageFlag = pageFlag;
	}

	public Integer getPosFlag() {
		return posFlag;
	}

	public void setPosFlag(Integer posFlag) {
		this.posFlag = posFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}