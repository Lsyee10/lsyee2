package com.lsy.www.biz.user;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kit.exception.BizException;
import com.kit.exception.DaoException;
import com.lsy.www.biz.LsyWwwBaseBizImpl;
import com.lsy.www.dao.user.KpkpWwwUserStatsDayDao;
import com.lsy.www.dao.user.KpkpWwwUserStatsSumDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsDayCond;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsSumCond;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsDay;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsSum;

/**
 * Description:用户业务统计接口实现
 *
 * @version 1.0 2016年4月27日
 * @author LSY
 */
@Service("lsyWwwUserStatsBiz")
public class LsyWwwUserStatsBizImpl extends LsyWwwBaseBizImpl implements LsyWwwUserStatsBiz {

	@Resource(name = "kpkpWwwUserStatsSumDao")
	private KpkpWwwUserStatsSumDao kpkpWwwUserStatsSumDao;

	@Resource(name = "kpkpWwwUserStatsDayDao")
	private KpkpWwwUserStatsDayDao kpkpWwwUserStatsDayDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotos()
	 */
	public Integer getPhotos() throws BizException {
		KpkpWwwUserStatsSumCond cond = null;
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsSumCond();
			cond.setStatsParam("sum(photos) as photos");
			statsSum = this.kpkpWwwUserStatsSumDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getPhotos();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotos error", de);
			throw new BizException("getPhotos failure");
		} catch (Exception e) {
			log.error("getPhotos error", e);
			throw new BizException("getPhotos failure");
		} finally {
			cond = null;
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotos(java.lang.Integer)
	 */
	public Integer getPhotos(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getPhotos();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotos error", de);
			throw new BizException("getPhotos failure");
		} catch (Exception e) {
			log.error("getPhotos error", e);
			throw new BizException("getPhotos failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotos(java.sql.Date)
	 */
	public Integer getPhotos(Date date) throws BizException {
		KpkpWwwUserStatsDayCond cond = null;
		KpkpWwwUserStatsDay statsDay = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsDayCond();
			cond.setDate(date);
			cond.setStatsParam("sum(photos) as photos");
			statsDay = this.kpkpWwwUserStatsDayDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsDay) {
				return statsDay.getPhotos();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotos error", de);
			throw new BizException("getPhotos failure");
		} catch (Exception e) {
			log.error("getPhotos error", e);
			throw new BizException("getPhotos failure");
		} finally {
			cond = null;
			statsDay = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoChoices()
	 */
	public Integer getPhotoChoices() throws BizException {
		KpkpWwwUserStatsSumCond cond = null;
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsSumCond();
			cond.setStatsParam("sum(choices) as choices");
			statsSum = this.kpkpWwwUserStatsSumDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getChoices();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoChoices error", de);
			throw new BizException("getPhotoChoices failure");
		} catch (Exception e) {
			log.error("getPhotoChoices error", e);
			throw new BizException("getPhotoChoices failure");
		} finally {
			cond = null;
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoChoice(java.sql.Date)
	 */
	public Integer getPhotoChoices(Date date) throws BizException {
		KpkpWwwUserStatsDayCond cond = null;
		KpkpWwwUserStatsDay statsDay = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsDayCond();
			cond.setDate(date);
			cond.setStatsParam("sum(choices) as choices");
			statsDay = this.kpkpWwwUserStatsDayDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsDay) {
				return statsDay.getChoices();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoChoices error", de);
			throw new BizException("getPhotoChoices failure");
		} catch (Exception e) {
			log.error("getPhotoChoices error", e);
			throw new BizException("getPhotoChoices failure");
		} finally {
			cond = null;
			statsDay = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoChoices(java.lang.Integer
	 * )
	 */
	public Integer getPhotoChoices(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getChoices();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoChoices error", de);
			throw new BizException("getPhotoChoices failure");
		} catch (Exception e) {
			log.error("getPhotoChoices error", e);
			throw new BizException("getPhotoChoices failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoStars()
	 */
	public Integer getPhotoStars() throws BizException {
		KpkpWwwUserStatsSumCond cond = null;
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsSumCond();
			cond.setStatsParam("sum(stars) as stars");
			statsSum = this.kpkpWwwUserStatsSumDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getStars();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoStars error", de);
			throw new BizException("getPhotoStars failure");
		} catch (Exception e) {
			log.error("getPhotoStars error", e);
			throw new BizException("getPhotoStars failure");
		} finally {
			cond = null;
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoStars(java.lang.Integer
	 * )
	 */
	public Integer getPhotoStars(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getStars();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoStars error", de);
			throw new BizException("getPhotoStars failure");
		} catch (Exception e) {
			log.error("getPhotoStars error", e);
			throw new BizException("getPhotoStars failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoAwards()
	 */
	public Integer getPhotoAwards() throws BizException {
		KpkpWwwUserStatsSumCond cond = null;
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsSumCond();
			cond.setStatsParam("sum(awards) as awards");
			statsSum = this.kpkpWwwUserStatsSumDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getAwards();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoAwards error", de);
			throw new BizException("getPhotoAwards failure");
		} catch (Exception e) {
			log.error("getPhotoAwards error", e);
			throw new BizException("getPhotoAwards failure");
		} finally {
			cond = null;
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPhotoAwards(java.lang.Integer
	 * )
	 */
	public Integer getPhotoAwards(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getAwards();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPhotoAwards error", de);
			throw new BizException("getPhotoAwards failure");
		} catch (Exception e) {
			log.error("getPhotoAwards error", e);
			throw new BizException("getPhotoAwards failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getTopics()
	 */
	public Integer getTopics() throws BizException {
		KpkpWwwUserStatsSumCond cond = null;
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取照片总数
			cond = new KpkpWwwUserStatsSumCond();
			cond.setStatsParam("sum(topics) as topics");
			statsSum = this.kpkpWwwUserStatsSumDao.statsByCond(cond);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getTopics();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getTopics error", de);
			throw new BizException("getTopics failure");
		} catch (Exception e) {
			log.error("getTopics error", e);
			throw new BizException("getTopics failure");
		} finally {
			cond = null;
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getTopics(java.lang.Integer)
	 */
	public Integer getTopics(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getTopics();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getTopics error", de);
			throw new BizException("getTopics failure");
		} catch (Exception e) {
			log.error("getTopics error", e);
			throw new BizException("getTopics failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownLogins(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownLogins(Integer userId, Date date, Integer logins) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateLogins(userId, logins);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateLogins(userId, logins, date);
		} catch (DaoException de) {
			log.error("updownLogins error", de);
			throw new BizException("updownLogins failure");
		} catch (Exception e) {
			log.error("updownLogins error", e);
			throw new BizException("updownLogins failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownTasks(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownTasks(Integer userId, Date date, Integer tasks) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateTasks(userId, tasks);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateTasks(userId, tasks, date);
		} catch (DaoException de) {
			log.error("updownTasks error", de);
			throw new BizException("updownTasks failure");
		} catch (Exception e) {
			log.error("updownTasks error", e);
			throw new BizException("updownTasks failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownStations(java.lang.Integer
	 * , java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownStations(Integer userId, Date date, Integer stations) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateStations(userId, stations);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateStations(userId, stations, date);
		} catch (DaoException de) {
			log.error("updownStations error", de);
			throw new BizException("updownStations failure");
		} catch (Exception e) {
			log.error("updownStations error", e);
			throw new BizException("updownStations failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownApplies(java.lang.Integer
	 * , java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownApplies(Integer userId, Date date, Integer applies) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateApplies(userId, applies);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateApplies(userId, applies, date);
		} catch (DaoException de) {
			log.error("updownApplies error", de);
			throw new BizException("updownApplies failure");
		} catch (Exception e) {
			log.error("updownApplies error", e);
			throw new BizException("updownApplies failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownPraises(java.lang.Integer
	 * , java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownPraises(Integer userId, Date date, Integer praises) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updatePraises(userId, praises);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updatePraises(userId, praises, date);
		} catch (DaoException de) {
			log.error("updownPraises error", de);
			throw new BizException("updownPraises failure");
		} catch (Exception e) {
			log.error("updownPraises error", e);
			throw new BizException("updownPraises failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownComments(java.lang.Integer
	 * , java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownComments(Integer userId, Date date, Integer comments) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateComments(userId, comments);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateComments(userId, comments, date);
		} catch (DaoException de) {
			log.error("updownComments error", de);
			throw new BizException("updownComments failure");
		} catch (Exception e) {
			log.error("updownComments error", e);
			throw new BizException("updownComments failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownViews(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownViews(Integer userId, Date date, Integer views) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateViews(userId, views);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateViews(userId, views, date);
		} catch (DaoException de) {
			log.error("updownViews error", de);
			throw new BizException("updownViews failure");
		} catch (Exception e) {
			log.error("updownViews error", e);
			throw new BizException("updownViews failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownChoices(java.lang.Integer
	 * , java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownChoices(Integer userId, Date date, Integer choices) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateChoices(userId, choices);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateChoices(userId, choices, date);
		} catch (DaoException de) {
			log.error("updownChoices error", de);
			throw new BizException("updownChoices failure");
		} catch (Exception e) {
			log.error("updownChoices error", e);
			throw new BizException("updownChoices failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownAwards(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownAwards(Integer userId, Date date, Integer awards) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateAwards(userId, awards);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateAwards(userId, awards, date);
		} catch (DaoException de) {
			log.error("updownAwards error", de);
			throw new BizException("updownAwards failure");
		} catch (Exception e) {
			log.error("updownAwards error", e);
			throw new BizException("updownAwards failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownTags(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownTags(Integer userId, Date date, Integer tags) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateTags(userId, tags);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateTags(userId, tags, date);
		} catch (DaoException de) {
			log.error("updownTags error", de);
			throw new BizException("updownTags failure");
		} catch (Exception e) {
			log.error("updownTags error", e);
			throw new BizException("updownTags failure");
		}
	}

	@Override
	public void updownFans(Integer userId, Date date, Integer fans) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateFans(userId, fans);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateFans(userId, fans, date);
		} catch (DaoException de) {
			log.error("updownFans error", de);
			throw new BizException("updownFans failure");
		} catch (Exception e) {
			log.error("updownFans error", e);
			throw new BizException("updownFans failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownFocus(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownFocus(Integer userId, Date date, Integer focus) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateFocus(userId, focus);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateFocus(userId, focus, date);
		} catch (DaoException de) {
			log.error("updownTasks error", de);
			throw new BizException("updownTasks failure");
		} catch (Exception e) {
			log.error("updownTasks error", e);
			throw new BizException("updownTasks failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownTopics(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownTopics(Integer userId, Date date, Integer topics) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateTopics(userId, topics);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateTopics(userId, topics, date);
		} catch (DaoException de) {
			log.error("updownTopics error", de);
			throw new BizException("updownTopics failure");
		} catch (Exception e) {
			log.error("updownTopics error", e);
			throw new BizException("updownTopics failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownPhotos(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownPhotos(Integer userId, Date date, Integer photos) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updatePhotos(userId, photos);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updatePhotos(userId, photos, date);
		} catch (DaoException de) {
			log.error("updownPhotos error", de);
			throw new BizException("updownPhotos failure");
		} catch (Exception e) {
			log.error("updownPhotos error", e);
			throw new BizException("updownPhotos failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownPoints(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownPoints(Integer userId, Date date, Integer points) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updatePoints(userId, points);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updatePoints(userId, points, date);
		} catch (DaoException de) {
			log.error("updownPoints error", de);
			throw new BizException("updownPoints failure");
		} catch (Exception e) {
			log.error("updownPoints error", e);
			throw new BizException("updownPoints failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownTrades(java.lang.Integer,
	 * java.sql.Date, java.lang.Integer)
	 */
	@Override
	public void updownTrades(Integer userId, Date date, Integer trades) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateTrades(userId, trades);

			// 更新日统计数据
			this.kpkpWwwUserStatsDayDao.updateTrades(userId, trades, date);
		} catch (DaoException de) {
			log.error("updownTrades error", de);
			throw new BizException("updownTrades failure");
		} catch (Exception e) {
			log.error("updownTrades error", e);
			throw new BizException("updownTrades failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownNotices(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void updownNotices(Integer userId, Integer notices) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateNotices(userId, notices);
		} catch (DaoException de) {
			log.error("updownNotices error", de);
			throw new BizException("updownNotices failure");
		} catch (Exception e) {
			log.error("updownNotices error", e);
			throw new BizException("updownNotices failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownEvents(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updownEvents(Integer userId, Integer events) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateEvents(userId, events);
		} catch (DaoException de) {
			log.error("updownEvents error", de);
			throw new BizException("updownEvents failure");
		} catch (Exception e) {
			log.error("updownEvents error", e);
			throw new BizException("updownEvents failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownNewses(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updownNewses(Integer userId, Integer newses) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateNewses(userId, newses);
		} catch (DaoException de) {
			log.error("updownNewses error", de);
			throw new BizException("updownNewses failure");
		} catch (Exception e) {
			log.error("updownNewses error", e);
			throw new BizException("updownNewses failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownGroups(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updownGroups(Integer userId, Integer groups) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateGroups(userId, groups);
		} catch (DaoException de) {
			log.error("updownGroups error", de);
			throw new BizException("updownGroups failure");
		} catch (Exception e) {
			log.error("updownGroups error", e);
			throw new BizException("updownGroups failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownMsgs(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updownMsgs(Integer userId, Integer msgs) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateMsgs(userId, msgs);
		} catch (DaoException de) {
			log.error("updownMsgs error", de);
			throw new BizException("updownMsgs failure");
		} catch (Exception e) {
			log.error("updownMsgs error", e);
			throw new BizException("updownMsgs failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.app.biz.user.KpkpWwwUserStatsBiz#updownStars(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void updownStars(Integer userId, Integer stars) throws BizException {
		try {
			// 更新汇总数据
			this.kpkpWwwUserStatsSumDao.updateStars(userId, stars);
		} catch (DaoException de) {
			log.error("updownStars error", de);
			throw new BizException("updownStars failure");
		} catch (Exception e) {
			log.error("updownStars error", e);
			throw new BizException("updownStars failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getTasks(java.lang.Integer)
	 */
	@Override
	public Integer getTasks(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getTasks();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getTasks error", de);
			throw new BizException("getTasks failure");
		} catch (Exception e) {
			log.error("getTasks error", e);
			throw new BizException("getTasks failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getNotices(java.lang.Integer)
	 */
	@Override
	public Integer getNotices(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getNotices();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getNotices error", de);
			throw new BizException("getNotices failure");
		} catch (Exception e) {
			log.error("getNotices error", e);
			throw new BizException("getNotices failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getEvents(java.lang.Integer)
	 */
	@Override
	public Integer getEvents(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getEvents();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getEvents error", de);
			throw new BizException("getEvents failure");
		} catch (Exception e) {
			log.error("getEvents error", e);
			throw new BizException("getEvents failure");
		} finally {
			statsSum = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserStatsBiz#getPrivates(java.lang.Integer)
	 */
	@Override
	public Integer getPrivates(Integer userId) throws BizException {
		KpkpWwwUserStatsSum statsSum = null;
		try {
			// 获取用户统计
			statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

			// 如果统计存在
			if (null != statsSum) {
				return statsSum.getPrivates();
			} else {
				return 0;
			}
		} catch (DaoException de) {
			log.error("getPrivates error", de);
			throw new BizException("getPrivates failure");
		} catch (Exception e) {
			log.error("getPrivates error", e);
			throw new BizException("getPrivates failure");
		} finally {
			statsSum = null;
		}
	}
}
