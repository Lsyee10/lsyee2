/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserAuthMailCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAuthMail;

/**
 * Description:用户邮件认证数据访问实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserAuthMailDao")
public class KpkpWwwUserAuthMailDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserAuthMail, KpkpWwwUserAuthMailCond>
		implements KpkpWwwUserAuthMailDao {

	public KpkpWwwUserAuthMailDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserAuthMailMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAuthMailDao#updateCheckTimes(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updateCheckTimes(Integer mailId, Integer checkTimes) throws DaoException {
		KpkpWwwUserAuthMail mail = null;
		try {
			// 根据昵称获取用户账号
			mail = new KpkpWwwUserAuthMail();
			mail.setMailId(mailId);
			mail.setCheckTimes(checkTimes);
			this.update(mail);
		} catch (Exception e) {
			log.error("updateCheckTimes error", e);
			throw new DaoException("updateCheckTimes failure");
		} finally {
			mail = null;
		}
	}
}
