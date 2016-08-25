/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.chat;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.chat.KpkpWwwChatGroupSessCond;
import com.lsy.www.entity.model.chat.KpkpWwwChatGroupSess;

/**
 * Description:群聊会话数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwChatGroupSessDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwChatGroupSess, KpkpWwwChatGroupSessCond>
		implements KpkpWwwChatGroupSessDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatGroupSessDao#updateUnreads(java.lang.
	 * Integer)
	 */
	@Override
	public void updateUnreads(Integer sessId, Integer unreads) throws DaoException {
		KpkpWwwChatGroupSess sess = null;
		try {
			sess = new KpkpWwwChatGroupSess();
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
	 * com.lsy.app.dao.chat.KpkpWwwChatGroupSessDao#updownUnreads(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updownUnreads(Integer groupId, Integer unreads) throws DaoException {
		KpkpWwwChatGroupSessCond sessCond = null;
		try {
			sessCond = new KpkpWwwChatGroupSessCond();
			sessCond.setGroupId(groupId);
			sessCond.setUpdateParam("unreads = unreads + (" + unreads + ")");
			this.updateByCond(sessCond);
		} catch (Exception e) {
			log.error("updownUnreads error", e);
			throw new DaoException("updownUnreads failure");
		} finally {
			sessCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.chat.KpkpWwwChatGroupSessDao#updateRecycle(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer sessId, Integer recycleFlag) throws DaoException {
		KpkpWwwChatGroupSess sess = null;
		try {
			sess = new KpkpWwwChatGroupSess();
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
	 * com.lsy.app.dao.chat.KpkpWwwChatGroupSessDao#queryByJoin(com.lsy.app
	 * .entity.cond.chat.KpkpWwwChatGroupSessCond)
	 */
	@SuppressWarnings("unchecked")
	public List<KpkpWwwChatGroupSess> queryByJoin(KpkpWwwChatGroupSessCond sessCond) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return (List<KpkpWwwChatGroupSess>) this.getSqlMapClientTemplate().queryForList(
					this.sqlMapNamespace + ".queryByJoin", sessCond);
		} catch (RuntimeException e) {
			log.error("queryByJoin error", e);
			throw new DaoException("queryByJoin failure");
		}
	}

}
