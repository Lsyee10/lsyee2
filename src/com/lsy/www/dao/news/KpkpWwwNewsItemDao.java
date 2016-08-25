/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.news.KpkpWwwNewsItemCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsItem;

/**
 * Description:资讯项目数据访问接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */

public interface KpkpWwwNewsItemDao extends LsyWwwBaseDao<KpkpWwwNewsItem, KpkpWwwNewsItemCond> {

	/**
	 * 更新点击数
	 * 
	 * @param newsId
	 * @param views
	 * @throws DaoException
	 */
	public void updateViews(Integer newsId, Integer views) throws DaoException;

	/**
	 * 更新评论数
	 * 
	 * @param newsId
	 * @param comments
	 * @throws DaoException
	 */
	public void updateComments(Integer newsId, Integer comments) throws DaoException;

	/**
	 * 更新回收标示
	 * 
	 * @param newsId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer newsId, Integer recycleFlag) throws DaoException;

}
