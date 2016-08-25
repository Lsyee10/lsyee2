/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserAuthSmsCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAuthSms;

/**
 * Description:用户短信校验数据访问实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserAuthSmsDao")
public class KpkpWwwUserAuthSmsDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserAuthSms, KpkpWwwUserAuthSmsCond>
		implements KpkpWwwUserAuthSmsDao {

	public KpkpWwwUserAuthSmsDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserAuthSmsMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAuthSmsDao#updateCheckTimes(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updateCheckTimes(Integer smsId, Integer checkTimes) throws DaoException {
		KpkpWwwUserAuthSms sms = null;
		try {
			sms = new KpkpWwwUserAuthSms();
			sms.setSmsId(smsId);
			sms.setCheckTimes(checkTimes);
			this.update(sms);
		} catch (Exception e) {
			log.error("updateCheckTimes error", e);
			throw new DaoException("updateCheckTimes failure");
		} finally {
			sms = null;
		}
	}
}
