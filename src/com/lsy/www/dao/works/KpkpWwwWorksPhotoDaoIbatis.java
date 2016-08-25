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
import com.lsy.www.entity.cond.works.KpkpWwwWorksPhotoCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhoto;

/**
 * Description:照片数据访问实现
 * 
 * @version 1.0 2015年9月18日
 * @author Wu guang jing
 */
@Repository("kpkpWwwWorksPhotoDao")
public class KpkpWwwWorksPhotoDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksPhoto, KpkpWwwWorksPhotoCond> implements
		KpkpWwwWorksPhotoDao {

	public KpkpWwwWorksPhotoDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwWorksPhotoMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByNewest(java.lang.Integer
	 * )
	 */
	public List<KpkpWwwWorksPhoto> queryByNewest(Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByNewest error", e);
			throw new DaoException("queryByNewest failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByCity(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByCity(String city, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setCity(city);
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByCity error", e);
			throw new DaoException("queryByCity failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByTag(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByTag(Integer tagId, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setTagId(tagId);
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByTag error", e);
			throw new DaoException("queryByTag failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByEdit(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByEdit(String startAddTime, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setEditAddTimeSt(startAddTime);
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setProfileFlag(SystemContext.YN.YES.getValue());
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByEdit error", e);
			throw new DaoException("queryByEdit failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByUser(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByUser(Integer userId, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setUserId(userId);
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByUser error", e);
			throw new DaoException("queryByUser failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByChoice(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByChoice(Integer choiceFlag, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setChoiceFlag(choiceFlag);
			photoCond.setOrderParam("kpkp_works_photo.choiceTime desc");
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByChoice error", e);
			throw new DaoException("queryByChoice failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByStar(java.lang.Integer
	 * , java.lang.String)
	 */
	public List<KpkpWwwWorksPhoto> queryByStar(Integer starFlag, String starDate) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(1);
			photoCond.setStarFlag(starFlag);
			photoCond.setStarDateEd(starDate);
			photoCond.setProfileFlag(SystemContext.YN.YES.getValue());
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			photoCond.setOrderParam("kpkp_works_photo.starDate desc");
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByStar error", e);
			throw new DaoException("queryByStar failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#queryByActivity(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByTask(Integer taskId, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setTaskId(taskId);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByTask error", e);
			throw new DaoException("queryByTask failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.works.KpkpWwwWorksPhotoDao#queryByStation(java.lang.
	 * Integer, java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByStation(Integer stationId, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setStationId(stationId);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByStation error", e);
			throw new DaoException("queryByStation failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#getNearbyPics(double,
	 * double, double, double, java.lang.Integer)
	 */
	public List<KpkpWwwWorksPhoto> queryByNearby(double leftTopPointLat, double leftTopPointLng,
			double rightBotPointLat, double rightBotPointLng, Integer size) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setLeftTopPointLat(leftTopPointLat);
			photoCond.setLeftTopPointLng(leftTopPointLng);
			photoCond.setRightBotPointLat(rightBotPointLat);
			photoCond.setRightBotPointLng(rightBotPointLng);
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			return this.queryByCond(photoCond);
		} catch (Exception e) {
			log.error("queryByNearby error", e);
			throw new DaoException("queryByNearby failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#updatePraises(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updatePraises(Integer photoId, Integer praises) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setPhotoId(photoId);
			photoCond.setUpdateParam("praises = praises +(" + praises + ")");
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", photoCond);
		} catch (Exception e) {
			log.error("updatePraises error", e);
			throw new DaoException("updatePraises failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#updateComments(java.lang.
	 * Integer , java.lang.Integer)
	 */
	public void updateComments(Integer photoId, Integer comments) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setPhotoId(photoId);
			photoCond.setUpdateParam("comments = comments +(" + comments + ")");
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", photoCond);
		} catch (Exception e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPhotoDao#updateRecycle(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updateRecycle(Integer topicId, Integer recycleFlag) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setTopicId(topicId);
			photoCond.setUpdateParam("recycleFlag = " + recycleFlag);
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", photoCond);
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.works.KpkpWwwWorksPhotoDao#updateTask(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public void updateTask(Integer topicId, Integer taskId) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setTopicId(topicId);
			photoCond.setUpdateParam("taskId = " + taskId);
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", photoCond);
		} catch (Exception e) {
			log.error("updateTask error", e);
			throw new DaoException("updateTask failure");
		} finally {
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.works.KpkpWwwWorksPhotoDao#updateStation(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updateStation(Integer topicId, Integer stationId) throws DaoException {
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setTopicId(topicId);
			photoCond.setUpdateParam("stationId = " + stationId);
			this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateByCond", photoCond);
		} catch (Exception e) {
			log.error("updateStation error", e);
			throw new DaoException("updateStation failure");
		} finally {
			photoCond = null;
		}
	}

}
