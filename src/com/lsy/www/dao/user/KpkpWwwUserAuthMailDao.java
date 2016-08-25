/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserAuthMailCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAuthMail;

/**
 * Description:用户邮件认证数据访问接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserAuthMailDao extends LsyWwwBaseDao<KpkpWwwUserAuthMail, KpkpWwwUserAuthMailCond> {
	
	/**
	 * 更新验证次数
	 * 
	 * @param mailId
	 * @param checkTimes
	 * @throws DaoException
	 */
	public void updateCheckTimes(Integer mailId, Integer checkTimes) throws DaoException;
}
