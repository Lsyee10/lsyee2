/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.chat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:群聊项目
 * 
 * @version 1.0 2015年8月31日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer groupId;
	private String name;
	private Integer users;
	private String lastMsg;
	private Integer lastSenderId;
	private Timestamp lastTime;
	private Timestamp addTime;

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

	public Integer getUsers() {
		return users;
	}

	public void setUsers(Integer users) {
		this.users = users;
	}

	public String getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}

	public Integer getLastSenderId() {
		return lastSenderId;
	}

	public void setLastSenderId(Integer lastSenderId) {
		this.lastSenderId = lastSenderId;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
