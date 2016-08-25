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
 * Description:运维链接
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwPushLink implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer linkId;
	private Integer sn;
	private String title1;
	private String title2;
	private String url1;
	private String url2;
	private String img1;
	private String img2;
	private Integer pubFlag;
	private Integer pageFlag;
	private Integer posFlag;
	private Integer recycleFlag;
	private Date startDate;
	private Date endDate;
	private Timestamp addTime;
	private Timestamp pubTime;
	private Integer adminId;

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
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

}