/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.chat;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:群聊项目条件
 * 
 * @version 1.0 2015年11月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupItemCond extends KpkpWwwBaseCond {

	private Integer groupId;
	private String name;
	private Integer lastSenderId;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLastSenderId() {
		return lastSenderId;
	}

	public void setLastSenderId(Integer lastSenderId) {
		this.lastSenderId = lastSenderId;
	}

}
