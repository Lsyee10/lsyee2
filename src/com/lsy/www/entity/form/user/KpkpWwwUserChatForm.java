/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:用户聊天表单
 *
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwUserChatForm extends KpkpWwwBaseForm {

	private Integer sessId;
	private Integer msgId;
	private Integer friendId;
	private String content;

	public Integer getSessId() {
		return sessId;
	}

	public void setSessId(Integer sessId) {
		this.sessId = sessId;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
