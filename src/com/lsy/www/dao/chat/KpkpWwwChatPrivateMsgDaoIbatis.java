/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.chat.KpkpWwwChatPrivateMsgCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatPrivateMsg;

/**
 * Description:私聊消息数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateMsgDaoIbatis extends
		LsyWwwBaseDaoIbatis<KpkpWwwChatPrivateMsg, KpkpWwwChatPrivateMsgCond> implements KpkpWwwChatPrivateMsgDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatPrivateMsgDao#updateRecycle(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException {
		KpkpWwwChatPrivateMsg msg = null;
		try {
			msg = new KpkpWwwChatPrivateMsg();
			msg.setSessId(sessId);
			msg.setRecycleFlag(recycleFlag);
			this.update(msg);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			msg = null;
		}
	}

}
