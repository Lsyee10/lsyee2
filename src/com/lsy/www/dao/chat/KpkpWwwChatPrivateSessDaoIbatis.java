/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.chat.KpkpWwwChatPrivateSessCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatPrivateSess;

/**
 * Description:私聊会话数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwChatPrivateSessDaoIbatis extends
		LsyWwwBaseDaoIbatis<KpkpWwwChatPrivateSess, KpkpWwwChatPrivateSessCond> implements KpkpWwwChatPrivateSessDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatPrivateSessDao#updateUnreads(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updateUnreads(Integer sessId, Integer unreads) throws DaoException {
		KpkpWwwChatPrivateSess sess = null;
		try {
			sess = new KpkpWwwChatPrivateSess();
			sess.setSessId(sessId);
			sess.setUnreads(unreads);
			this.update(sess);
		} catch (Exception e) {
			log.error("updateUnreads error", e);
			throw new DaoException("updateUnreads failure");
		} finally {
			sess = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatPrivateSessDao#updateUsers(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException {
		KpkpWwwChatPrivateSess sess = null;
		try {
			sess = new KpkpWwwChatPrivateSess();
			sess.setSessId(sessId);
			sess.setRecycleFlag(recycleFlag);
			this.update(sess);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			sess = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.chat.KpkpWwwChatPrivateSessDao#clearSess(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void clearSess(Integer userId, Integer recycleFlag) throws DaoException {
		KpkpWwwChatPrivateSessCond sessCond = null;
		try {
			sessCond = new KpkpWwwChatPrivateSessCond();
			sessCond.setUserId(userId);
			sessCond.setUpdateParam("recycleFlag = " + recycleFlag);
			this.updateByCond(sessCond);
		} catch (Exception e) {
			log.error("clearSess error", e);
			throw new DaoException("clearSess failure");
		} finally {
			sessCond = null;
		}
	}
}
