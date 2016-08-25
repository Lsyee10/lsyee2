/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.push;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:应用推送首页关注
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwPushHome implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer pubFlag;
	private Integer bizFlag;
	private Timestamp pubTime;
	private Integer adminId;
	private Integer bindId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public Timestamp getPubTime() {
		return pubTime;
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getBindId() {
		return bindId;
	}

	public void setBindId(Integer bindId) {
		this.bindId = bindId;
	}

}