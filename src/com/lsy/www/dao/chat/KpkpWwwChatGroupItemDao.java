/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.chat.KpkpWwwChatGroupItemCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatGroupItem;

/**
 * Description:群聊项目数据访问接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwChatGroupItemDao extends LsyWwwBaseDao<KpkpWwwChatGroupItem, KpkpWwwChatGroupItemCond> {

	/**
	 * 增减群组人数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void updownUsers(Integer groupId, Integer users) throws DaoException;
}
