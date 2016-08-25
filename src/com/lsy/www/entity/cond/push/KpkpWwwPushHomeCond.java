/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.push;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:推送首页关注条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwPushHomeCond extends KpkpWwwBaseCond {

	private Integer id;
	private Integer bizFlag;
	private Integer pubFlag;
	private String pubTimeSt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public String getPubTimeSt() {
		return pubTimeSt;
	}

	public void setPubTimeSt(String pubTimeSt) {
		this.pubTimeSt = pubTimeSt;
	}

}