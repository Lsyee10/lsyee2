/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.chat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:群聊会话
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupSess implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sessId;
	private Integer userId;
	private Integer groupId;
	private Integer unreads;
	private Timestamp exitTime;
	private Timestamp joinTime;
	private Integer recycleFlag;

	// 群聊组资料
	private String groupName;
	private Integer groupUsers;
	private String groupLastMsg;
	private Timestamp groupLastTime;
	private Integer groupLastSenderId;

	// 用户资料
	private String userAvatar;
	private String userNickname;

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

	public Integer getUnreads() {
		return unreads;
	}

	public void setUnreads(Integer unreads) {
		this.unreads = unreads;
	}

	public Timestamp getExitTime() {
		return exitTime;
	}

	public void setExitTime(Timestamp exitTime) {
		this.exitTime = exitTime;
	}

	public Timestamp getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(Integer groupUsers) {
		this.groupUsers = groupUsers;
	}

	public String getGroupLastMsg() {
		return groupLastMsg;
	}

	public void setGroupLastMsg(String groupLastMsg) {
		this.groupLastMsg = groupLastMsg;
	}

	public Timestamp getGroupLastTime() {
		return groupLastTime;
	}

	public void setGroupLastTime(Timestamp groupLastTime) {
		this.groupLastTime = groupLastTime;
	}

	public Integer getGroupLastSenderId() {
		return groupLastSenderId;
	}

	public void setGroupLastSenderId(Integer groupLastSenderId) {
		this.groupLastSenderId = groupLastSenderId;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

}
