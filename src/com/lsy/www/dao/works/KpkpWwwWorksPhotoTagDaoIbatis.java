/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPhotoTagCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhotoTag;

/**
 * Description:作品照片标签数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwWorksPhotoTagDao")
public class KpkpWwwWorksPhotoTagDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksPhotoTag, KpkpWwwWorksPhotoTagCond>
		implements KpkpWwwWorksPhotoTagDao {

	public KpkpWwwWorksPhotoTagDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwWorksPhotoTagMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.works.KpkpWwwWorksPhotoTagDao#delete(java.lang.Integer)
	 */
	public void delete(Integer photoId) throws DaoException {
		KpkpWwwWorksPhotoTagCond cond = null;
		try {
			cond = new KpkpWwwWorksPhotoTagCond();
			cond.setPhotoId(photoId);
			this.deleteByCond(cond);
		} catch (Exception e) {
			log.error("delete error", e);
			throw new DaoException("delete failure");
		} finally {
			cond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.works.KpkpWwwWorksPhotoTagDao#query(java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhotoTag> query(Integer photoId) throws DaoException {
		KpkpWwwWorksPhotoTagCond cond = null;
		try {
			cond = new KpkpWwwWorksPhotoTagCond();
			cond.setPhotoId(photoId);
			return this.queryByCond(cond);
		} catch (Exception e) {
			log.error("query error", e);
			throw new DaoException("query failure");
		} finally {
			cond = null;
		}
	}
}
