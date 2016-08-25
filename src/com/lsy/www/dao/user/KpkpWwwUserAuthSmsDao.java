/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserAuthSmsCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAuthSms;

/**
 * Description:用户短信校验接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserAuthSmsDao extends LsyWwwBaseDao<KpkpWwwUserAuthSms, KpkpWwwUserAuthSmsCond> {

	/**
	 * 更新验证次数
	 * 
	 * @param smsId
	 * @param checkTimes
	 * @throws DaoException
	 */
	public void updateCheckTimes(Integer smsId, Integer checkTimes) throws DaoException;
}
