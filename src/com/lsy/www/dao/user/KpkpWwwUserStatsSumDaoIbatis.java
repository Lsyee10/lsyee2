/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsSumCond;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsSum;

/**
 * Description:用户业务统计汇总接口实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserStatsSumDao")
public class KpkpWwwUserStatsSumDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserStatsSum, KpkpWwwUserStatsSumCond>
		implements KpkpWwwUserStatsSumDao {
	
	public KpkpWwwUserStatsSumDaoIbatis(){
		super.setSqlMapNamespace("KpkpWwwUserStatsSumMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updatePraises(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public void updatePraises(Integer userId, Integer praises) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				praises = curSum.getPraises() + (praises);
				updSum.setPraises(praises > 0 ? praises : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setPraises(praises > 0 ? praises : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updatePraises error", e);
			throw new DaoException("updatePraises failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateLogins(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updateLogins(Integer userId, Integer logins) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				logins = curSum.getLogins() + (logins);
				updSum.setLogins(logins > 0 ? logins : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setLogins(logins > 0 ? logins : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateLogins error", e);
			throw new DaoException("updateLogins failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateTasks(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateTasks(Integer userId, Integer tasks) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				tasks = curSum.getTasks() + (tasks);
				updSum.setTasks(tasks > 0 ? tasks : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setTasks(tasks > 0 ? tasks : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateTasks error", e);
			throw new DaoException("updateTasks failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateStations(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateStations(Integer userId, Integer stations) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				stations = curSum.getStations() + (stations);
				updSum.setStations(stations > 0 ? stations : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setStations(stations > 0 ? stations : 0);
				this.insert(updSum);
			}

		} catch (Exception e) {
			log.error("updateStations error", e);
			throw new DaoException("updateStations failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateApplies(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public void updateApplies(Integer userId, Integer applies) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				applies = curSum.getApplies() + (applies);
				updSum.setApplies(applies > 0 ? applies : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setApplies(applies > 0 ? applies : 0);
				this.insert(updSum);
			}

		} catch (Exception e) {
			log.error("updateApplies error", e);
			throw new DaoException("updateApplies failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateComments(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updateComments(Integer userId, Integer comments) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				comments = curSum.getComments() + (comments);
				updSum.setComments(comments > 0 ? comments : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setComments(comments > 0 ? comments : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateComments error", e);
			throw new DaoException("updateComments failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateViews(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateViews(Integer userId, Integer views) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				views = curSum.getViews() + (views);
				updSum.setViews(views > 0 ? views : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setViews(views > 0 ? views : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateViews error", e);
			throw new DaoException("updateViews failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateChoices(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public void updateChoices(Integer userId, Integer choices) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				choices = curSum.getChoices() + (choices);
				updSum.setChoices(choices > 0 ? choices : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setChoices(choices > 0 ? choices : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateChoices error", e);
			throw new DaoException("updateChoices failure");
		} finally {
			curSum = null;
			updSum = null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateAwards(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updateAwards(Integer userId, Integer awards) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				awards = curSum.getAwards() + (awards);
				updSum.setAwards(awards > 0 ? awards : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setAwards(awards > 0 ? awards : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateAwards error", e);
			throw new DaoException("updateAwards failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateTags(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateTags(Integer userId, Integer tags) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				tags = curSum.getTags() + (tags);
				updSum.setTags(tags > 0 ? tags : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setTags(tags > 0 ? tags : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateTags error", e);
			throw new DaoException("updateTags failure");
		} finally {
			curSum = null;
			updSum = null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateFans(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateFans(Integer userId, Integer fans) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				fans = curSum.getFans() + (fans);
				updSum.setFans(fans > 0 ? fans : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setFans(fans > 0 ? fans : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateFans error", e);
			throw new DaoException("updateFans failure");
		} finally {
			curSum = null;
			updSum = null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateFocus(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateFocus(Integer userId, Integer focus) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				focus = curSum.getFocus() + (focus);
				updSum.setFocus(focus > 0 ? focus : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setFocus(focus > 0 ? focus : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateFocus error", e);
			throw new DaoException("updateFocus failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateTopics(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updateTopics(Integer userId, Integer topics) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				topics = curSum.getTopics() + (topics);
				updSum.setTopics(topics > 0 ? topics : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setTopics(topics > 0 ? topics : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateTopics error", e);
			throw new DaoException("updateTopics failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updatePhotos(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updatePhotos(Integer userId, Integer photos) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				photos = curSum.getPhotos() + (photos);
				updSum.setPhotos(photos > 0 ? photos : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setPhotos(photos > 0 ? photos : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updatePhotos error", e);
			throw new DaoException("updatePhotos failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updatePoints(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updatePoints(Integer userId, Integer points) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				points = curSum.getPoints() + (points);
				updSum.setPoints(points > 0 ? points : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setPoints(points > 0 ? points : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updatePoints error", e);
			throw new DaoException("updatePoints failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateTrades(java.lang.
	 * Integer , java.lang.Integer)
	 */
	@Override
	public void updateTrades(Integer userId, Integer trades) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				trades = curSum.getTrades() + (trades);
				updSum.setTrades(trades > 0 ? trades : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setTrades(trades > 0 ? trades : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateTrades error", e);
			throw new DaoException("updateTrades failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateNotices(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public void updateNotices(Integer userId, Integer notices) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				notices = curSum.getNotices() + (notices);
				updSum.setNotices(notices > 0 ? notices : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setNotices(notices > 0 ? notices : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateNotices error", e);
			throw new DaoException("updateNotices failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateEvents(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateEvents(Integer userId, Integer events) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				events = curSum.getEvents() + (events);
				updSum.setEvents(events > 0 ? events : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setEvents(events > 0 ? events : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateEvents error", e);
			throw new DaoException("updateEvents failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#resetNotices(java.lang.Integer
	 * )
	 */
	@Override
	public void resetNotices(Integer userId) throws DaoException {
		KpkpWwwUserStatsSum sum = null;
		try {
			sum = new KpkpWwwUserStatsSum();
			sum.setUserId(userId);
			sum.setNotices(0);
			this.update(sum);
		} catch (Exception e) {
			log.error("resetNotices error", e);
			throw new DaoException("resetNotices failure");
		} finally {
			sum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#resetEvents(java.lang.Integer
	 * )
	 */
	@Override
	public void resetEvents(Integer userId) throws DaoException {
		KpkpWwwUserStatsSum sum = null;
		try {
			sum = new KpkpWwwUserStatsSum();
			sum.setUserId(userId);
			sum.setEvents(0);
			this.update(sum);
		} catch (Exception e) {
			log.error("resetEvents error", e);
			throw new DaoException("resetEvents failure");
		} finally {
			sum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.user.KpkpWwwUserStatsSumDao#resetPrivates(java.lang.
	 * Integer)
	 */
	@Override
	public void resetPrivates(Integer userId) throws DaoException {
		KpkpWwwUserStatsSum sum = null;
		try {
			sum = new KpkpWwwUserStatsSum();
			sum.setUserId(userId);
			sum.setPrivates(0);
			this.update(sum);
		} catch (Exception e) {
			log.error("resetPrivates error", e);
			throw new DaoException("resetPrivates failure");
		} finally {
			sum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateNewses(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateNewses(Integer userId, Integer newses) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				newses = curSum.getNewses() + (newses);
				updSum.setNewses(newses > 0 ? newses : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setNewses(newses > 0 ? newses : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateNewses error", e);
			throw new DaoException("updateNewses failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateGroups(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateGroups(Integer userId, Integer groups) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				groups = curSum.getGroups() + (groups);
				updSum.setGroups(groups > 0 ? groups : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setGroups(groups > 0 ? groups : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateGroups error", e);
			throw new DaoException("updateGroups failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#resetGroups(java.lang.Integer
	 * )
	 */
	@Override
	public void resetGroups(Integer userId) throws DaoException {
		KpkpWwwUserStatsSum sum = null;
		try {
			sum = new KpkpWwwUserStatsSum();
			sum.setUserId(userId);
			sum.setGroups(0);
			this.update(sum);
		} catch (Exception e) {
			log.error("resetGroups error", e);
			throw new DaoException("resetGroups failure");
		} finally {
			sum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateMsgs(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updateMsgs(Integer userId, Integer msgs) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				msgs = curSum.getMsgs() + (msgs);
				updSum.setMsgs(msgs > 0 ? msgs : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setMsgs(msgs > 0 ? msgs : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateMsgs error", e);
			throw new DaoException("updateMsgs failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#resetMsgs(java.lang.Integer)
	 */
	@Override
	public void resetMsgs(Integer userId) throws DaoException {
		KpkpWwwUserStatsSum sum = null;
		try {
			sum = new KpkpWwwUserStatsSum();
			sum.setUserId(userId);
			sum.setMsgs(0);
			this.update(sum);
		} catch (Exception e) {
			log.error("resetMsgs error", e);
			throw new DaoException("resetMsgs failure");
		} finally {
			sum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserStatsSumDao#updateStars(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public void updateStars(Integer userId, Integer stars) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				stars = curSum.getStars() + (stars);
				updSum.setStars(stars > 0 ? stars : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setStars(stars > 0 ? stars : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updateStars error", e);
			throw new DaoException("updateStars failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.user.KpkpWwwUserStatsSumDao#updatePrivates(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public void updatePrivates(Integer userId, Integer privates) throws DaoException {
		KpkpWwwUserStatsSum curSum = null;
		KpkpWwwUserStatsSum updSum = null;
		try {
			// 获取用户汇总统计记录
			curSum = this.query(userId);

			// 如果汇总记录存在
			if (null != curSum) {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				privates = curSum.getPrivates() + (privates);
				updSum.setPrivates(privates > 0 ? privates : 0);
				this.update(updSum);
			} else {
				updSum = new KpkpWwwUserStatsSum();
				updSum.setUserId(userId);
				updSum.setPrivates(privates > 0 ? privates : 0);
				this.insert(updSum);
			}
		} catch (Exception e) {
			log.error("updatePrivates error", e);
			throw new DaoException("updatePrivates failure");
		} finally {
			curSum = null;
			updSum = null;
		}
	}
}
