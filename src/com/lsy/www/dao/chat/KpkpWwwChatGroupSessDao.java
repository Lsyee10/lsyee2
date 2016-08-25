/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.chat.KpkpWwwChatGroupSessCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatGroupSess;

/**
 * Description:群聊会话数据访问接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwChatGroupSessDao extends LsyWwwBaseDao<KpkpWwwChatGroupSess, KpkpWwwChatGroupSessCond> {

	/**
	 * 更新未读消息数
	 * 
	 * @param groupId
	 * @param groups
	 * @throws DaoException
	 */
	public void updateUnreads(Integer sessId, Integer unreads) throws DaoException;
	
	/**
	 * 增减未读数
	 * 
	 * @param groupId
	 * @param unreads
	 * @throws DaoException
	 */
	public void updownUnreads(Integer groupId, Integer unreads)throws DaoException;

	/**
	 * 更新回收标示
	 * 
	 * @param sessId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException;
	
	/**
	 * 链接查询
	 * 
	 * @param sessCond
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwChatGroupSess> queryByJoin(KpkpWwwChatGroupSessCond sessCond) throws DaoException;
}
