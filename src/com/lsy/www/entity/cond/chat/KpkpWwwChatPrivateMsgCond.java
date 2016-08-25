/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.chat;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:私聊消息条件
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateMsgCond extends KpkpWwwBaseCond {

	private Integer msgId;
	private Integer sessId;
	private Integer senderId;
	private Integer recycleFlag;

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getSessId() {
		return sessId;
	}

	public void setSessId(Integer sessId) {
		this.sessId = sessId;
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
