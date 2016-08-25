/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.sys;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Description:系统版本
 * 
 * @version 1.0 2015年11月13日
 * @author Wu guang jing
 */
public class KpkpWwwSysVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer versionId;
	private Integer code;
	private Integer appFlag;
	private String name;
	private String apk;
	private String url;
	private String intro;
	private Integer pubFlag;
	private Date pubDate;
	private Timestamp addTime;
	private Integer recycleFlag;

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(Integer appFlag) {
		this.appFlag = appFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApk() {
		return apk;
	}

	public void setApk(String apk) {
		this.apk = apk;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
