/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.push;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Description:系统公告
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwPushNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer noticeId;
	private String content;
	private Timestamp addTime;
	private Date pubDate;
	private Timestamp pubTime;
	private Integer pubFlag;
	private Integer adminId;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Timestamp getPubTime() {
		return pubTime;
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}