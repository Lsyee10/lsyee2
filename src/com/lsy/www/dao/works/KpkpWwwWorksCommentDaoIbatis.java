/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.util.SystemContext;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.works.KpkpWwwWorksCommentCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksComment;

/**
 * Description:相册评论数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwWorksCommentDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksComment, KpkpWwwWorksCommentCond>
		implements KpkpWwwWorksCommentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksCommentDao#queryByPhoto(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public List<KpkpWwwWorksComment> queryByPhoto(Integer photoId, Integer size) throws DaoException {
		KpkpWwwWorksCommentCond commentCond = null;
		try {
			commentCond = new KpkpWwwWorksCommentCond();
			commentCond.setPhotoId(photoId);
			commentCond.setFirstResult(0);
			commentCond.setMaxResults(size);
			commentCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(commentCond);
		} catch (Exception e) {
			log.error("queryByPhoto error", e);
			throw new DaoException("queryByPhoto failure");
		} finally {
			commentCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksCommentDao#updateRecycle(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateRecycle(Integer commentId, Integer recycleFlag) throws DaoException {
		KpkpWwwWorksComment comment = null;
		try {
			comment = new KpkpWwwWorksComment();
			comment.setCommentId(commentId);
			comment.setRecycleFlag(SystemContext.YN.YES.getValue());
			this.update(comment);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			comment = null;
		}
	}
}
