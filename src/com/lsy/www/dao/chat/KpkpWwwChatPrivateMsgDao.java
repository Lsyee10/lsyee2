/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.chat.KpkpWwwChatPrivateMsgCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatPrivateMsg;

/**
 * Description:私聊消息数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwChatPrivateMsgDao extends LsyWwwBaseDao<KpkpWwwChatPrivateMsg, KpkpWwwChatPrivateMsgCond> {

	/**
	 * 更新回收标志
	 * 
	 * @param tag
	 * @param users
	 * @throws DaoException
	 */
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException;
}
