/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.kit.word.DateTimeHelper;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsDayCond;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsDay;

/**
 * Description:用户业务日统计接口实现
 * 
 * @version 1.0 2015年9月7日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserStatsDayDao")
public class KpkpWwwUserStatsDayDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserStatsDay, KpkpWwwUserStatsDayCond>
		implements KpkpWwwUserStatsDayDao {

	public KpkpWwwUserStatsDayDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserStatsDayMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateLogins(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateLogins(Integer userId, Integer logins, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {
				// 更新登录次数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				logins = statsDays.get(0).getLogins() + (logins);
				statsDay.setLogins(logins > 0 ? logins : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setLogins(logins > 0 ? logins : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateLogins error", e);
			throw new DaoException("updateLogins failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateTasks(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateTasks(Integer userId, Integer tasks, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新任务数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				tasks = statsDays.get(0).getTasks() + (tasks);
				statsDay.setTasks(tasks > 0 ? tasks : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setTasks(tasks > 0 ? tasks : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateTasks error", e);
			throw new DaoException("updateTasks failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateStations(java.lang
	 * .Integer, java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateStations(Integer userId, Integer stations, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新小站数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				stations = statsDays.get(0).getStations() + (stations);
				statsDay.setStations(stations > 0 ? stations : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setStations(stations > 0 ? stations : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateStations error", e);
			throw new DaoException("updateStations failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateWwwlies(java.lang.
	 * Integer, java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateApplies(Integer userId, Integer applies, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新报名数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				applies = statsDays.get(0).getApplies() + (applies);
				statsDay.setApplies(applies > 0 ? applies : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setApplies(applies > 0 ? applies : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateWwwlies error", e);
			throw new DaoException("updateWwwlies failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updatePraises(java.lang.
	 * Integer, java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updatePraises(Integer userId, Integer praises, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新点赞次数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				praises = statsDays.get(0).getPraises() + (praises);
				statsDay.setPraises(praises > 0 ? praises : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setPraises(praises > 0 ? praises : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updatePraises error", e);
			throw new DaoException("updatePraises failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateComments(java.lang
	 * .Integer, java.lang.Integer, java.sql.Date)
	 */
	public void updateComments(Integer userId, Integer comments, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新评论数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				comments = statsDays.get(0).getComments() + (comments);
				statsDay.setComments(comments > 0 ? comments : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setComments(comments > 0 ? comments : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateViews(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateViews(Integer userId, Integer views, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新查看数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				views = statsDays.get(0).getViews() + (views);
				statsDay.setViews(views > 0 ? views : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setViews(views > 0 ? views : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateViews error", e);
			throw new DaoException("updateViews failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateChoices(java.lang.
	 * Integer, java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateChoices(Integer userId, Integer choices, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新精选数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				choices = statsDays.get(0).getChoices() + (choices);
				statsDay.setChoices(choices > 0 ? choices : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setChoices(choices > 0 ? choices : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateChoices error", e);
			throw new DaoException("updateChoices failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateAwards(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateAwards(Integer userId, Integer awards, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新获奖数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				awards = statsDays.get(0).getAwards() + (awards);
				statsDay.setAwards(awards > 0 ? awards : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setAwards(awards > 0 ? awards : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateAwards error", e);
			throw new DaoException("updateAwards failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateTags(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateTags(Integer userId, Integer tags, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setFirstResult(0);
			statsDayCond.setMaxResults(1);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新标签数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				tags = statsDays.get(0).getTags() + (tags);
				statsDay.setTags(tags > 0 ? tags : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setTags(tags > 0 ? tags : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateTags error", e);
			throw new DaoException("updateTags failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateFans(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateFans(Integer userId, Integer fans, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新粉丝数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				fans = statsDays.get(0).getFans() + (fans);
				statsDay.setFans(fans > 0 ? fans : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setFans(fans > 0 ? fans : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateFans error", e);
			throw new DaoException("updateFans failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateFocus(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateFocus(Integer userId, Integer focus, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新关注数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				focus = statsDays.get(0).getFocus() + (focus);
				statsDay.setFocus(focus > 0 ? focus : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setFocus(focus > 0 ? focus : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateFocus error", e);
			throw new DaoException("updateFocus failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateTopics(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateTopics(Integer userId, Integer topics, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新组照数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				topics = statsDays.get(0).getTopics() + (topics);
				statsDay.setTopics(topics > 0 ? topics : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setTopics(topics > 0 ? topics : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateTopics error", e);
			throw new DaoException("updateTopics failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updatePhotos(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updatePhotos(Integer userId, Integer photos, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新照片数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				photos = statsDays.get(0).getPhotos() + (photos);
				statsDay.setPhotos(photos > 0 ? photos : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setPhotos(photos > 0 ? photos : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updatePhotos error", e);
			throw new DaoException("updatePhotos failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updatePoints(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updatePoints(Integer userId, Integer points, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新积分数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				points = statsDays.get(0).getPoints() + (points);
				statsDay.setPoints(points > 0 ? points : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setPoints(points > 0 ? points : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updatePoints error", e);
			throw new DaoException("updatePoints failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsDayDao#updateTrades(java.lang.Integer
	 * , java.lang.Integer, java.sql.Date)
	 */
	@Override
	public void updateTrades(Integer userId, Integer trades, Date date) throws DaoException {
		KpkpWwwUserStatsDay statsDay = null;
		List<KpkpWwwUserStatsDay> statsDays = null;
		KpkpWwwUserStatsDayCond statsDayCond = null;
		try {
			// 获取日统计列表
			statsDayCond = new KpkpWwwUserStatsDayCond();
			statsDayCond.setUserId(userId);
			statsDayCond.setDate(date);
			statsDayCond.setMaxResults(1);
			statsDayCond.setFirstResult(0);
			statsDays = this.queryByCond(statsDayCond);

			// 如果列表存在
			if (null != statsDays && !statsDays.isEmpty()) {

				// 更新交易数
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setId(statsDays.get(0).getId());
				trades = statsDays.get(0).getTrades() + (trades);
				statsDay.setTrades(trades > 0 ? trades : 0);
				this.update(statsDay);
			} else {

				// 新建日统计
				statsDay = new KpkpWwwUserStatsDay();
				statsDay.setUserId(userId);
				statsDay.setDate(DateTimeHelper.getDate());
				statsDay.setTrades(trades > 0 ? trades : 0);
				this.insert(statsDay);
			}
		} catch (Exception e) {
			log.error("updateTrades error", e);
			throw new DaoException("updateTrades failure");
		} finally {
			statsDay = null;
			statsDays = null;
			statsDayCond = null;
		}
	}
}
