/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.push;


/**
 * Description:系统公告视图
 * 
 * @version 1.0 2015年9月1日
 * @author Wu guang jing
 */
public class KpkpWwwPushNoticeView {

	private Integer id;
	private String content;
	private String pubDateDes;
	private String pubTimeDes;
	private String kpkpAvatar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubDateDes() {
		return pubDateDes;
	}

	public void setPubDateDes(String pubDateDes) {
		this.pubDateDes = pubDateDes;
	}

	public String getPubTimeDes() {
		return pubTimeDes;
	}

	public void setPubTimeDes(String pubTimeDes) {
		this.pubTimeDes = pubTimeDes;
	}

	public String getKpkpAvatar() {
		return kpkpAvatar;
	}

	public void setKpkpAvatar(String kpkpAvatar) {
		this.kpkpAvatar = kpkpAvatar;
	}

}
