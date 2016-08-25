/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.chat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:私聊会话
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateSess implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sessId;
	private Integer userId;
	private Integer friendId;
	private Integer unreads;
	private String lastMsg;
	private Timestamp lastTime;
	private Timestamp firstTime;
	private Integer recycleFlag;

	// 好友昵称与头像
	private String friendNickname;
	private String friendAvatar;

	public Integer getSessId() {
		return sessId;
	}

	public void setSessId(Integer sessId) {
		this.sessId = sessId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
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

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public Timestamp getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(Timestamp firstTime) {
		this.firstTime = firstTime;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

}
