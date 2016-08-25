/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户事件通知
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer eventId;
	private Integer userId;
	private Integer producerId;
	private Integer bindId;
	private Integer bizFlag;
	private String content;
	private String url;
	private String thumb;
	private Integer pushFlag;
	private Timestamp addTime;
	private Timestamp pushTime;

	// 生成者
	private String producerAvatar;
	private String producerNickname;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPushFlag() {
		return pushFlag;
	}

	public void setPushFlag(Integer pushFlag) {
		this.pushFlag = pushFlag;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getPushTime() {
		return pushTime;
	}

	public void setPushTime(Timestamp pushTime) {
		this.pushTime = pushTime;
	}

	public Integer getBindId() {
		return bindId;
	}

	public void setBindId(Integer bindId) {
		this.bindId = bindId;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getProducerAvatar() {
		return producerAvatar;
	}

	public String getProducerNickname() {
		return producerNickname;
	}

}