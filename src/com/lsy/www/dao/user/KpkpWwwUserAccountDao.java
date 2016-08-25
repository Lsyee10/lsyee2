/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserAccountCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAccount;

/**
 * Description:用户账号数据访问接口
 * 
 * @version 1.0 2014年4月1日
 * @author Wu guang jing
 */
public interface KpkpWwwUserAccountDao extends LsyWwwBaseDao<KpkpWwwUserAccount, KpkpWwwUserAccountCond> {

	/**
	 * 根据令牌获取账号
	 * 
	 * @param token
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserAccount queryByToken(String token) throws DaoException;

	/**
	 * 根据邮箱查询账号
	 * 
	 * @param email
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserAccount queryByEmail(String email) throws DaoException;

	/**
	 * 根据手机查询账号
	 * 
	 * @param cellphone
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserAccount queryByCellphone(String cellphone) throws DaoException;

	/**
	 * 获取用户资料
	 * 
	 * @param nickname
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserAccount queryByNickname(String nickname) throws DaoException;

	/**
	 * 获取推荐摄影师
	 * 
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwUserAccount> queryByTop(Integer topFlag, Integer size) throws DaoException;
}
