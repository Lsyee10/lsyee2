/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.util.SystemContext;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityItemCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityItem;

/**
 * Description:活动项目数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwActivityItemDao")
public class KpkpWwwActivityItemDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwActivityItem, KpkpWwwActivityItemCond>
		implements KpkpWwwActivityItemDao {

	public KpkpWwwActivityItemDaoIbatis(){
		super.setSqlMapNamespace("KpkpWwwActivityItemMapper");
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.activity.KpkpWwwActivityItemDao#queryByTag(java.lang
	 * .String)
	 */
	public KpkpWwwActivityItem queryByTag(String tag) throws DaoException {
		List<KpkpWwwActivityItem> items = null;
		KpkpWwwActivityItemCond itemCond = null;
		try {
			// 根据标签获取活动项目列表
			itemCond = new KpkpWwwActivityItemCond();
			itemCond.setTag(tag);
			itemCond.setFirstResult(0);
			itemCond.setMaxResults(1);
			itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			items = this.queryByCond(itemCond);

			// 如果活动存在
			if (null != items && !items.isEmpty()) {
				return items.get(0);
			}

			return null;
		} catch (DaoException e) {
			log.error("queryByTag error", e);
			throw new DaoException("queryByTag failure");
		} finally {
			items = null;
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.activity.KpkpWwwActivityItemDao#queryByTop(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public List<KpkpWwwActivityItem> queryByTop(Integer topFlag, Integer size) throws DaoException {
		KpkpWwwActivityItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwActivityItemCond();
			itemCond.setTopFlag(topFlag);
			itemCond.setFirstResult(0);
			itemCond.setMaxResults(size);
			itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			itemCond.setOrderParam("kpkp_activity_item.topTime desc");
			return this.queryByCond(itemCond);
		} catch (DaoException e) {
			log.error("queryByTop error", e);
			throw new DaoException("queryByTop failure");
		} finally {
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.activity.KpkpWwwActivityItemDao#queryByTop(java.lang
	 * .Integer, java.lang.Integer, java.lang.Integer)
	 */
	public List<KpkpWwwActivityItem> queryByTop(Integer topFlag, Integer bizFlag, Integer size) throws DaoException {
		KpkpWwwActivityItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwActivityItemCond();
			itemCond.setTopFlag(topFlag);
			itemCond.setFirstResult(0);
			itemCond.setMaxResults(size);
			itemCond.setBizFlag(bizFlag);
			itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			itemCond.setOrderParam("kpkp_activity_item.topTime desc");
			return this.queryByCond(itemCond);
		} catch (DaoException e) {
			log.error("queryByTop error", e);
			throw new DaoException("queryByTop failure");
		} finally {
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.activity.KpkpWwwActivityItemDao#updatePhotos(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updownPhotos(Integer activityId, Integer photos) throws DaoException {
		KpkpWwwActivityItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwActivityItemCond();
			itemCond.setActivityId(activityId);
			itemCond.setUpdateParam("photos = photos +(" + photos + ")");
			this.updateByCond(itemCond);
		} catch (DaoException e) {
			log.error("updatePhotos error", e);
			throw new DaoException("updatePhotos failure");
		} finally {
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.activity.KpkpWwwActivityItemDao#updateJoins(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updownJoins(Integer activityId, Integer joins) throws DaoException {
		KpkpWwwActivityItemCond itemCond = null;
		try {
			itemCond = new KpkpWwwActivityItemCond();
			itemCond.setActivityId(activityId);
			itemCond.setUpdateParam("joins = joins +(" + joins + ")");
			this.updateByCond(itemCond);
		} catch (Exception e) {
			log.error("updateJoins error", e);
			throw new DaoException("updateJoins failure");
		} finally {
			itemCond = null;
		}
	}
}
