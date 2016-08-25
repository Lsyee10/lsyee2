/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserSetCond;
import com.lsy.www.entity.model.user.KpkpWwwUserSet;

/**
 * Description:用户设置数据访问接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserSetDao extends LsyWwwBaseDao<KpkpWwwUserSet, KpkpWwwUserSetCond> {

	/**
	 * 更新苹果配置信息
	 * 
	 * @param userId
	 * @param ios
	 * @throws DaoException
	 */
	public void updateIos(Integer userId, String ios) throws DaoException;

	/**
	 * 更新安卓配置信息
	 * 
	 * @param userId
	 * @param Android
	 * @throws DaoException
	 */
	public void updateAndroid(Integer userId, String Android) throws DaoException;
	
	/**
	 * 更新网站配置信息
	 * 
	 * @param userId
	 * @param web
	 * @throws DaoException
	 */
	public void updateWeb(Integer userId, String web) throws DaoException;

}
