/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.chat;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:群聊会话条件
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupSessCond extends KpkpWwwBaseCond {

	private Integer sessId;
	private Integer userId;
	private Integer groupId;
	private Integer recycleFlag;

	public Integer getSessId() {
		return sessId;
	}

	public void setSessId(Integer sessId) {
		this.sessId = sessId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}
