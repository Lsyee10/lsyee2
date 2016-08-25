/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.chat.KpkpWwwChatGroupItemCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatGroupItem;

/**
 * Description:群聊项目数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupItemDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwChatGroupItem, KpkpWwwChatGroupItemCond>
		implements KpkpWwwChatGroupItemDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatGroupItemDao#updownUsers(java.lang.Integer
	 * )
	 */
	@Override
	public void updownUsers(Integer groupId, Integer users) throws DaoException {
		KpkpWwwChatGroupItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwChatGroupItemCond();
			itemCond.setGroupId(groupId);
			itemCond.setUpdateParam("users = users +(" + users + ")");
			this.updateByCond(itemCond);
		} catch (Exception e) {
			log.error("updateUsers error", e);
			throw new DaoException("updateUsers failure");
		} finally {
			itemCond = null;
		}
	}
}
