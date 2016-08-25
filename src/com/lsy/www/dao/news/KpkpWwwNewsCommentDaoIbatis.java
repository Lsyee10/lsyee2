/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.news.KpkpWwwNewsCommentCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsComment;

/**
 * Description:资讯评论数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwNewsCommentDao")
public class KpkpWwwNewsCommentDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwNewsComment, KpkpWwwNewsCommentCond>
		implements KpkpWwwNewsCommentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.news.KpkpWwwNewsCommentDao#updateRecycle(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer commentId, Integer recycleFlag) throws DaoException {
		KpkpWwwNewsComment comment = null;
		try {
			comment = new KpkpWwwNewsComment();
			comment.setCommentId(commentId);
			comment.setRecycleFlag(recycleFlag);
			this.update(comment);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			comment = null;
		}
	}
}
