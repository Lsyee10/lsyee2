/**
 * 
 */
package com.lsy.www.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kit.exception.DaoException;
import com.kit.logger.SystemLog;

/**
 * Description:数据访问基础接口实现
 * 
 * @author LSY
 * 
 */
public class LsyWwwBaseDaoIbatis<M, C> extends SqlMapClientDaoSupport implements LsyWwwBaseDao<M, C> {

	// 日志
	protected final SystemLog log = (SystemLog) LogFactory.getLog(getClass());

	protected Integer totalTables;// 表总数
	protected String sqlMapNamespace;// 空间名

	public void setTotalTables(Integer totalTables) {
		this.totalTables = totalTables;
	}

	public void setSqlMapNamespace(String sqlMapNamespace) {
		this.sqlMapNamespace = sqlMapNamespace;
	}

	@Resource(name = "sqlMapClient")
	public final void setSqlMapClient0(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#insert(java.lang.Object)
	 */
	@Override
	public void insert(M m) throws DaoException {
		try {
			this.getSqlMapClientTemplate().insert(this.sqlMapNamespace + ".insert", m);
		} catch (RuntimeException e) {
			log.error("insert error", e);
			throw new DaoException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#query(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public M query(Object key) throws DaoException {
		try {
			return (M) this.getSqlMapClientTemplate().queryForObject(this.sqlMapNamespace + ".query", key);
		} catch (RuntimeException e) {
			log.error("query error", e);
			throw new DaoException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#queryByCond(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<M> queryByCond(C c) throws DaoException {
		try {
			return (List<M>) this.getSqlMapClientTemplate().queryForList(this.sqlMapNamespace + ".queryByCond", c);
		} catch (RuntimeException e) {
			log.error("queryByCond error", e);
			throw new DaoException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#delete(java.lang.Object)
	 */
	@Override
	public int delete(Object key) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return this.getSqlMapClientTemplate().delete(this.sqlMapNamespace + ".delete", key);
		} catch (RuntimeException e) {
			log.error("delete error", e);
			throw new DaoException("delete failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#deleteByCond(java.lang.Object)
	 */
	@Override
	public int deleteByCond(C c) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return this.getSqlMapClientTemplate().delete(this.sqlMapNamespace + ".deleteByCond", c);
		} catch (RuntimeException e) {
			log.error("deleteByCond error", e);
			throw new DaoException("deleteByCond failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#update(java.lang.Object)
	 */
	@Override
	public int update(M m) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".update", m);
		} catch (RuntimeException e) {
			log.error("update error", e);
			throw new DaoException("update failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#updateByCond(java.lang.Object)
	 */
	@Override
	public int updateByCond(C c) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", c);
		} catch (RuntimeException e) {
			log.error("updateByCond error", e);
			throw new DaoException("updateByCond failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#countByCond(java.lang.Object)
	 */
	@Override
	public Integer countByCond(C c) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return (Integer) this.getSqlMapClientTemplate().queryForObject(this.sqlMapNamespace + ".countByCond", c);
		} catch (RuntimeException e) {
			log.error("countByCond error", e);
			throw new DaoException("countByCond failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.LsyWwwBaseDao#statsByCond(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public M statsByCond(C c) throws DaoException {
		// TODO Auto-generated method stub
		try {
			return (M) this.getSqlMapClientTemplate().queryForObject(this.sqlMapNamespace + ".statsByCond", c);
		} catch (RuntimeException e) {
			log.error("statsByCond error", e);
			throw new DaoException("statsByCond failure");
		}
	}
}
