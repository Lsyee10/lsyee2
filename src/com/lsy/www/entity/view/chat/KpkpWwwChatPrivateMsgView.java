/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.chat;

/**
 * Description:私聊消息视图
 * 
 * @version 1.0 2015年11月30日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateMsgView {

	private Integer msgId;
	private Integer sessId;
	private Integer senderId;
	private String content;
	private String sendTimeDes;

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

	public String getSendTimeDes() {
		return sendTimeDes;
	}

	public void setSendTimeDes(String sendTimeDes) {
		this.sendTimeDes = sendTimeDes;
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
