/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.util.SystemContext;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.works.KpkpWwwWorksTagCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksTag;

/**
 * Description:作品标签数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwWorksTagDao")
public class KpkpWwwWorksTagDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksTag, KpkpWwwWorksTagCond> implements
		KpkpWwwWorksTagDao {

	public KpkpWwwWorksTagDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwWorksTagMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#queryByTag(java.lang.String)
	 */
	public KpkpWwwWorksTag queryByName(String name) throws DaoException {
		List<KpkpWwwWorksTag> tags = null;
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setFirstResult(0);
			tagCond.setMaxResults(1);
			tagCond.setName(name);
			tagCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			tags = this.queryByCond(tagCond);

			// 如果标签存在
			if (null != tags && !tags.isEmpty()) {
				return tags.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("queryByTop error", e);
			throw new DaoException("queryByTop failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#queryByTop(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksTag> queryByTop(Integer topFlag, Integer size) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setFirstResult(0);
			tagCond.setMaxResults(size);
			tagCond.setTopFlag(SystemContext.YN.YES.getValue());
			tagCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			tagCond.setOrderParam("kpkp_works_tag.topTime desc");
			return this.queryByCond(tagCond);
		} catch (Exception e) {
			log.error("queryByTop error", e);
			throw new DaoException("queryByTop failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#queryByPhoto(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksTag> queryByPhoto(Integer photoId, Integer size) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setFirstResult(0);
			tagCond.setMaxResults(size);
			tagCond.setPhotoId(photoId);
			tagCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(tagCond);
		} catch (Exception e) {
			log.error("queryByPhoto error", e);
			throw new DaoException("queryByPhoto failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#queryBySub(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksTag> queryBySub(Integer subUserId, Integer size) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setFirstResult(0);
			tagCond.setMaxResults(size);
			tagCond.setSubUserId(subUserId);
			tagCond.setOrderParam("kpkp_user_subscribe.subId desc");
			tagCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(tagCond);
		} catch (Exception e) {
			log.error("queryBySub error", e);
			throw new DaoException("queryBySub failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#queryByUse(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksTag> queryByUse(Integer useUserId, Integer size) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setFirstResult(0);
			tagCond.setMaxResults(size);
			tagCond.setUseUserId(useUserId);
			tagCond.setOrderParam("kpkp_works_photo_tag.id desc");
			tagCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(tagCond);
		} catch (Exception e) {
			log.error("queryByUse error", e);
			throw new DaoException("queryByUse failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#updownUsers(java.lang.String,
	 * java.lang.Integer)
	 */
	public void updownUsers(Integer tagId, Integer users) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setTagId(tagId);
			tagCond.setUpdateParam("users = users +(" + users + ")");
			this.updateByCond(tagCond);
		} catch (Exception e) {
			log.error("updateUsers error", e);
			throw new DaoException("updateUsers failure");
		} finally {
			tagCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksTagDao#updownPhotos(java.lang.String,
	 * java.lang.Integer)
	 */
	public void updownPhotos(Integer tagId, Integer photos) throws DaoException {
		KpkpWwwWorksTagCond tagCond = null;
		try {
			tagCond = new KpkpWwwWorksTagCond();
			tagCond.setTagId(tagId);
			tagCond.setUpdateParam("photos = photos +(" + photos + ")");
			this.updateByCond(tagCond);
		} catch (Exception e) {
			log.error("updatePhotos error", e);
			throw new DaoException("updatePhotos failure");
		} finally {
			tagCond = null;
		}
	}
}
