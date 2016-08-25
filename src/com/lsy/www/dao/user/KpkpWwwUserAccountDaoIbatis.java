/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.util.SystemContext;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserAccountCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAccount;

/**
 * Description:用户账号数据访问实现
 * 
 * @version 1.0 2014年4月1日
 * @author Wu guang jings
 */
@Repository("kpkpWwwUserAccountDao")
public class KpkpWwwUserAccountDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserAccount, KpkpWwwUserAccountCond>
		implements KpkpWwwUserAccountDao {

	public KpkpWwwUserAccountDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserAccountMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAccountDao#queryByToken(java.lang.String
	 * )
	 */
	public KpkpWwwUserAccount queryByToken(String token) throws DaoException {
		KpkpWwwUserAccountCond accountCond = null;
		List<KpkpWwwUserAccount> accounts = null;
		try {
			// 根据昵称获取用户账号
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);
			accountCond.setAppTokenId(token);
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accounts = this.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				return accounts.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByToken error", e);
			throw new DaoException("queryByToken failure");
		} finally {
			accounts = null;
			accountCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAccountDao#queryByEmail(java.lang.String
	 * )
	 */
	public KpkpWwwUserAccount queryByEmail(String email) throws DaoException {
		KpkpWwwUserAccountCond accountCond = null;
		List<KpkpWwwUserAccount> accounts = null;
		try {
			// 根据昵称获取用户账号
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);
			accountCond.setEmail(email);
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accounts = this.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				return accounts.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByEmail error", e);
			throw new DaoException("queryByEmail failure");
		} finally {
			accounts = null;
			accountCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAccountDao#queryByCellphone(java.lang
	 * .String)
	 */
	public KpkpWwwUserAccount queryByCellphone(String cellphone) throws DaoException {
		KpkpWwwUserAccountCond accountCond = null;
		List<KpkpWwwUserAccount> accounts = null;
		try {
			// 根据昵称获取用户账号
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);
			accountCond.setCellphone(cellphone);
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accounts = this.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				return accounts.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByCellphone error", e);
			throw new DaoException("queryByCellphone failure");
		} finally {
			accounts = null;
			accountCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserAccountDao#queryByNickname(java.lang
	 * .String)
	 */
	public KpkpWwwUserAccount queryByNickname(String nickname) throws DaoException {
		KpkpWwwUserAccountCond accountCond = null;
		List<KpkpWwwUserAccount> accounts = null;
		try {
			// 根据昵称获取用户账号
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);
			accountCond.setNickname(nickname);
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accounts = this.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				return accounts.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByNickname error", e);
			throw new DaoException("queryByNickname failure");
		} finally {
			accounts = null;
			accountCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserAccountDao#queryByTop(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwUserAccount> queryByTop(Integer topFlag, Integer size) throws DaoException {
		KpkpWwwUserAccountCond accountCond = null;
		try {
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setTopFlag(topFlag);
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(size);
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accountCond.setOrderParam("kpkp_user_account.topTime desc");
			return this.queryByCond(accountCond);
		} catch (Exception e) {
			log.error("queryByTop error", e);
			throw new DaoException("queryByTop failure");
		} finally {
			accountCond = null;
		}
	}
}
