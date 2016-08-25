/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.chat;

/**
 * Description:获取私聊会话视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateSessView {

	private Integer sessId;
	private Integer userId;
	private Integer friendId;
	private String friendNickname;
	private String friendAvatar;
	private Integer unreads;
	private String lastMsg;
	private String lastTimeDes;
	private String firstTimeDes;

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

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getFriendNickname() {
		return friendNickname;
	}

	public void setFriendNickname(String friendNickname) {
		this.friendNickname = friendNickname;
	}

	public String getFriendAvatar() {
		return friendAvatar;
	}

	public void setFriendAvatar(String friendAvatar) {
		this.friendAvatar = friendAvatar;
	}

	public Integer getUnreads() {
		return unreads;
	}

	public void setUnreads(Integer unreads) {
		this.unreads = unreads;
	}

	public String getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}

	public String getLastTimeDes() {
		return lastTimeDes;
	}

	public void setLastTimeDes(String lastTimeDes) {
		this.lastTimeDes = lastTimeDes;
	}

	public String getFirstTimeDes() {
		return firstTimeDes;
	}

	public void setFirstTimeDes(String firstTimeDes) {
		this.firstTimeDes = firstTimeDes;
	}

}
