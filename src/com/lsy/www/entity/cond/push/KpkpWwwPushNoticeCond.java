/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.push;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:系统公告条件
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwPushNoticeCond extends KpkpWwwBaseCond {

	private Integer noticeId;
	private Integer pubFlag;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

}