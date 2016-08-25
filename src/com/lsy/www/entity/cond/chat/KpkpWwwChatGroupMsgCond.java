/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.chat;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:群聊消息条件
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupMsgCond extends KpkpWwwBaseCond {

	private Integer msgId;
	private Integer groupId;
	private Integer senderId;
	private Integer recycleFlag;

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

}
