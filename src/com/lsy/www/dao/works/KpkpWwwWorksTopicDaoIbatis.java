/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.works.KpkpWwwWorksTopicCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksTopic;

/**
 * Description:作品主题数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwWorksTopicDao")
public class KpkpWwwWorksTopicDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksTopic, KpkpWwwWorksTopicCond> implements
		KpkpWwwWorksTopicDao {

	public KpkpWwwWorksTopicDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwWorksTopicMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTopicDao#updatePraises(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updatePraises(Integer topicId, Integer praises) throws DaoException {
		KpkpWwwWorksTopicCond topicCond = null;
		try {
			topicCond = new KpkpWwwWorksTopicCond();
			topicCond.setTopicId(topicId);
			topicCond.setUpdateParam("praises = praises +(" + praises + ")");
			this.updateByCond(topicCond);
		} catch (Exception e) {
			log.error("updatePraises error", e);
			throw new DaoException("updatePraises failure");
		} finally {
			topicCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.works.KpkpWwwWorksTopicDao#updateComments(java.lang.
	 * Integer, java.lang.Integer)
	 */
	public void updateComments(Integer topicId, Integer comments) throws DaoException {
		KpkpWwwWorksTopicCond topicCond = null;
		try {
			topicCond = new KpkpWwwWorksTopicCond();
			topicCond.setTopicId(topicId);
			topicCond.setUpdateParam("comments = comments +(" + comments + ")");
			this.updateByCond(topicCond);
		} catch (Exception e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			topicCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.works.KpkpWwwWorksTopicDao#updateRecycle(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updateRecycle(Integer topicId, Integer recycleFlag) throws DaoException {
		KpkpWwwWorksTopicCond topicCond = null;
		try {
			topicCond = new KpkpWwwWorksTopicCond();
			topicCond.setTopicId(topicId);
			topicCond.setUpdateParam("recycleFlag = " + recycleFlag);
			this.updateByCond(topicCond);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			topicCond = null;
		}
	}

}
