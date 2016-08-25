/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.news.KpkpWwwNewsItemCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsItem;

/**
 * Description:资讯项目数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */

@Repository(value = "kpkpWwwNewsItemDao")
public class KpkpWwwNewsItemDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwNewsItem, KpkpWwwNewsItemCond> implements
		KpkpWwwNewsItemDao {
	
	KpkpWwwNewsItemDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwNewsItemMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.news.KpkpWwwNewsItemDao#updateViews(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public void updateViews(Integer newsId, Integer views) throws DaoException {
		KpkpWwwNewsItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwNewsItemCond();
			itemCond.setNewsId(newsId);
			itemCond.setUpdateParam("views = views +(" + views + ")");
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", itemCond);
		} catch (RuntimeException e) {
			log.error("updateViews error", e);
			throw new DaoException("updateViews failure");
		} finally {
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.news.KpkpWwwNewsItemDao#updateComments(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateComments(Integer newsId, Integer comments) throws DaoException {
		KpkpWwwNewsItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwNewsItemCond();
			itemCond.setNewsId(newsId);
			itemCond.setUpdateParam("comments = comments +(" + comments + ")");
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", itemCond);
		} catch (RuntimeException e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.news.KpkpWwwNewsItemDao#updateRecycle(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer newsId, Integer recycleFlag) throws DaoException {
		KpkpWwwNewsItem item = null;
		try {
			item = new KpkpWwwNewsItem();
			item.setNewsId(newsId);
			item.setRecycleFlag(recycleFlag);
			this.update(item);
		} catch (Exception e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			item = null;
		}
	}
}
