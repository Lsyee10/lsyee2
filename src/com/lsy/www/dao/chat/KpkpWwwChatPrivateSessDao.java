/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.chat.KpkpWwwChatPrivateSessCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatPrivateSess;

/**
 * Description:私聊会话数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwChatPrivateSessDao extends LsyWwwBaseDao<KpkpWwwChatPrivateSess, KpkpWwwChatPrivateSessCond> {

	/**
	 * 更新未读数
	 * 
	 * @param sessId
	 * @param unreads
	 * @throws DaoException
	 */
	public void updateUnreads(Integer sessId, Integer unreads) throws DaoException;
	
	/**
	 * 更新会话回收标示
	 * 
	 * @param sessId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException;
	
	/**
	 * 更新用户所有会话回收标示
	 * 
	 * @param userId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void clearSess(Integer userId, Integer recycleFlag) throws DaoException;
}
