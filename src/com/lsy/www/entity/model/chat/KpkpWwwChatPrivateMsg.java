/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.chat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:私聊消息
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer msgId;
	private Integer sessId;
	private Integer senderId;
	private String content;
	private Timestamp sendTime;
	private Integer recycleFlag;

	// 用户资料
	private String senderAvatar;
	private String senderNickname;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public String getSenderAvatar() {
		return senderAvatar;
	}

	public void setSenderAvatar(String senderAvatar) {
		this.senderAvatar = senderAvatar;
	}

	public String getSenderNickname() {
		return senderNickname;
	}

	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}

}
