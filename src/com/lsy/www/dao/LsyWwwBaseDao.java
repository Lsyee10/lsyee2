/**
 * 
 */
package com.lsy.www.dao;

import java.util.List;

import com.kit.exception.DaoException;

/**
 * Description:数据访问层基础接口
 * 
 * @author LSY
 * 
 */
public interface LsyWwwBaseDao<M, C> {

	/**
	 * 插入数据
	 * 
	 * @param m
	 * @throws DaoException
	 */
	public void insert(M m) throws DaoException;

	/**
	 * 查询数据
	 * 
	 * @param key
	 * @return
	 * @throws DaoException
	 */
	public M query(Object key) throws DaoException;

	/**
	 * 根据条件查询数据
	 * 
	 * @param c
	 * @return
	 * @throws DaoException
	 */
	public List<M> queryByCond(C c) throws DaoException;

	/**
	 * 删除数据
	 * 
	 * @param key
	 * @return
	 * @throws DaoException
	 */
	public int delete(Object key) throws DaoException;

	/**
	 * 根据条件删除数据
	 * 
	 * @param c
	 * @return
	 * @throws DaoException
	 */
	public int deleteByCond(C c) throws DaoException;

	/**
	 * 更新数据
	 * 
	 * @param key
	 * @return
	 * @throws DaoException
	 */
	public int update(M m) throws DaoException;

	/**
	 * 根据条件更新数据
	 * 
	 * @param c
	 * @return
	 * @throws DaoException
	 */
	public int updateByCond(C c) throws DaoException;

	/**
	 * 根据条件获取记录数
	 * 
	 * @param c
	 * @return
	 * @throws DaoException
	 */
	public Integer countByCond(C c) throws DaoException;

	/**
	 * 根据条件统计
	 * 
	 * @param c
	 * @return
	 * @throws DaoException
	 */
	public M statsByCond(C c) throws DaoException;

}
