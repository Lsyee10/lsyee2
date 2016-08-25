/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;

/**
 * Description:用户事件通知视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwUserEventView {

	private Integer eventId;
	private Integer userId;
	private Integer producerId;
	private Integer bindId;
	private Integer bizFlag;
	private String content;
	private String url;
	private String thumb;
	private Integer pushFlag;
	private String addTimeDes;

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

	public Integer getBindId() {
		return bindId;
	}

	public void setBindId(Integer bindId) {
		this.bindId = bindId;
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

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public Integer getPushFlag() {
		return pushFlag;
	}

	public void setPushFlag(Integer pushFlag) {
		this.pushFlag = pushFlag;
	}

	public String getProducerAvatar() {
		return producerAvatar;
	}

	public void setProducerAvatar(String producerAvatar) {
		this.producerAvatar = producerAvatar;
	}

	public String getProducerNickname() {
		return producerNickname;
	}

	public void setProducerNickname(String producerNickname) {
		this.producerNickname = producerNickname;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

}
