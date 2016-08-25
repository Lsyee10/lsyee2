/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户事件通知查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserEventCond extends KpkpWwwBaseCond {

	private Integer eventId;
	private Integer userId;
	private Integer producerId;
	private Integer bindId;
	private Integer bizFlag;
	private Integer pushFlag;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProducerId() {
		return producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	public Integer getBizFlag() {
		return bizFlag;
	}

	public void setBizFlag(Integer bizFlag) {
		this.bizFlag = bizFlag;
	}

	public Integer getPushFlag() {
		return pushFlag;
	}

	public void setPushFlag(Integer pushFlag) {
		this.pushFlag = pushFlag;
	}

	public Integer getBindId() {
		return bindId;
	}

	public void setBindId(Integer bindId) {
		this.bindId = bindId;
	}

}