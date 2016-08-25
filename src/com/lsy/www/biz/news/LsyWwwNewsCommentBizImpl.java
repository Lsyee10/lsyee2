/**
 * 
 */
package com.lsy.www.biz.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kit.exception.BizException;
import com.kit.exception.DaoException;
import com.kit.word.DateTimeHelper;
import com.kit.word.JodaTimeHelper;
import com.kit.word.SecureHelper;
import com.kit.word.StringHelper;
import com.lsy.util.SpringBeanUtils;
import com.lsy.util.SpringContextUtil;
import com.lsy.util.SystemConstant;
import com.lsy.util.SystemContext;
import com.lsy.www.biz.LsyWwwBaseBizImpl;
import com.lsy.www.biz.user.LsyWwwUserStatsBiz;
import com.lsy.www.dao.news.KpkpWwwNewsCommentDao;
import com.lsy.www.dao.news.KpkpWwwNewsItemDao;
import com.lsy.www.dao.user.KpkpWwwUserAccountDao;
import com.lsy.www.entity.cond.news.KpkpWwwNewsCommentCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsComment;
import com.lsy.www.entity.model.news.KpkpWwwNewsItem;
import com.lsy.www.entity.model.user.KpkpWwwUserAccount;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsCommentView;

/**
 * Description:文章评论接口实现
 *
 * @version 1.0 2016年4月27日
 * @author LSY
 */
@Service("lsyWwwNewsCommentBiz")
public class LsyWwwNewsCommentBizImpl extends LsyWwwBaseBizImpl implements LsyWwwNewsCommentBiz {

	@Resource(name = "kpkpWwwNewsCommentDao")
	private KpkpWwwNewsCommentDao kpkpWwwNewsCommentDao;

	@Resource(name = "kpkpWwwNewsItemDao")
	private KpkpWwwNewsItemDao kpkpWwwNewsItemDao;

	@Resource(name = "kpkpWwwUserAccountDao")
	private KpkpWwwUserAccountDao kpkpWwwUserAccountDao;

	private LsyWwwUserStatsBiz getKpkpWwwUserStatsBiz() {
		return (LsyWwwUserStatsBiz) SpringContextUtil.getApplicationContext().getBean("lsyWwwUserStatsBiz");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.news.LsyWwwNewsCommentBiz#create(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public KpkpWwwNewsCommentView create(Integer userId, Integer reId, Integer newsId, String content)
			throws BizException {
		KpkpWwwNewsComment comment = null;
		KpkpWwwNewsCommentView commentView = null;
		KpkpWwwUserAccount user = null;
		List<String> atUsers = null;
		try {
			// 如果内容存在
			if (!StringHelper.ifNull(content)) {
				content = StringHelper.url2Text(content);
			}

			// 如果内容存在
			if (!StringHelper.ifNull(content)) {
				content = StringHelper.html2Text(content);
			}

			// 如果内容存在
			if (!StringHelper.ifNull(content)) {
				content = SecureHelper.filterWord(content);
			}

			// 新建评论
			comment = new KpkpWwwNewsComment();
			comment.setUserId(userId);
			comment.setReId(reId);
			comment.setNewsId(newsId);
			comment.setContent(content);
			comment.setAddTime(DateTimeHelper.getTimestamp());
			comment.setRecycleFlag(SystemContext.YN.NO.getValue());
			this.kpkpWwwNewsCommentDao.insert(comment);

			// 更新评论数
			this.kpkpWwwNewsItemDao.updateComments(newsId, 1);

			// 更新用户评论数
			this.getKpkpWwwUserStatsBiz().updownComments(userId, JodaTimeHelper.getDate(comment.getAddTime()), 1);

			// 评论视图
			commentView = new KpkpWwwNewsCommentView();
			SpringBeanUtils.copyProperties(comment, commentView);
			commentView.setAddTimeDes(JodaTimeHelper.getBeforeNowDay(comment.getAddTime()));

			// 获取介绍中的用户列表
			atUsers = StringHelper.getAtNicknames(comment.getContent());

			// 如果用户存在
			if (null != atUsers && !atUsers.isEmpty()) {
				for (String atUser : atUsers) {
					commentView.setContent(comment.getContent().replace("@" + atUser,
							SystemConstant.TMP_USER_HIS_HREF.replace("NICKNAME", atUser)));
				}
			}

			// 获取用户信息
			user = this.kpkpWwwUserAccountDao.query(userId);

			// 如果用户存在
			if (user != null) {
				// 设置评论者头像、昵称
				commentView.setAvatar(SystemConstant.HOST_FDFS + user.getAvatar());
				commentView.setNickname(user.getNickname());
			}
			return commentView;
		} catch (DaoException de) {
			log.error("create error", de);
			throw new BizException("create failure");
		} catch (Exception e) {
			log.error("create error", e);
			throw new BizException("create failure");
		} finally {
			comment = null;
			commentView = null;
			user = null;
			atUsers = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.news.LsyWwwNewsCommentBiz#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer commentId) throws BizException {
		KpkpWwwNewsComment comment = null;
		try {
			// 获取评论内容
			comment = this.kpkpWwwNewsCommentDao.query(commentId);

			// 如果评论内容存在
			if (null != comment && comment.getRecycleFlag().equals(SystemContext.YN.NO.getValue())) {

				// 回收评论
				this.kpkpWwwNewsCommentDao.updateRecycle(commentId, SystemContext.YN.YES.getValue());

				// 更新资讯评论数
				this.kpkpWwwNewsItemDao.updateComments(comment.getNewsId(), -1);

				// 更新用户评论数
				this.getKpkpWwwUserStatsBiz().updownComments(comment.getUserId(),
						JodaTimeHelper.getDate(comment.getAddTime()), -1);
				return true;
			} else {
				return false;
			}
		} catch (DaoException de) {
			log.error("delete error", de);
			throw new BizException("delete failure");
		} catch (Exception e) {
			log.error("delete error", e);
			throw new BizException("delete failure");
		} finally {
			comment = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsCommentBiz#getPagin(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwNewsCommentView> getPagin(Integer newsId, Integer curPage, Integer pageRows)
			throws BizException {
		Integer count = null;
		List<String> atUsers = null;
		KpkpWwwNewsItem article = null;
		KpkpWwwNewsCommentCond commentCond = null;
		List<KpkpWwwNewsComment> comments = null;
		KpkpWwwNewsCommentView commentView = null;
		List<KpkpWwwNewsCommentView> commentViews = null;
		LsyWwwPaginView<KpkpWwwNewsCommentView> paginView = null;
		try {
			// 获取资讯文章
			article = this.kpkpWwwNewsItemDao.query(newsId);

			// 如果文章存在
			if (article != null) {
				count = article.getComments();
			}

			// 如果存在评论
			if (count > 0) {
				// 构建评论视图列表页面
				paginView = new LsyWwwPaginView<KpkpWwwNewsCommentView>(curPage, pageRows, count);
				commentCond = new KpkpWwwNewsCommentCond();
				commentCond.setNewsId(newsId);
				commentCond.setMaxResults(paginView.getMaxResults());
				commentCond.setFirstResult(paginView.getFirstResult());
				commentCond.setProfileFlag(SystemContext.YN.YES.getValue());
				commentCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				comments = this.kpkpWwwNewsCommentDao.queryByCond(commentCond);

				// 如果评论存在
				if (null != comments && !comments.isEmpty()) {
					commentViews = new ArrayList<KpkpWwwNewsCommentView>(0);

					// 迭代处理
					for (KpkpWwwNewsComment comment : comments) {
						commentView = new KpkpWwwNewsCommentView();
						SpringBeanUtils.copyProperties(comment, commentView);
						commentView.setNickname(comment.getNickname());
						commentView.setAvatar(SystemConstant.HOST_FDFS + comment.getAvatar());
						commentView.setAddTimeDes(JodaTimeHelper.getBeforeNowDay(comment.getAddTime()));

						// 获取介绍中的用户列表
						atUsers = StringHelper.getAtNicknames(comment.getContent());

						// 如果用户存在
						if (null != atUsers && !atUsers.isEmpty()) {
							for (String atUser : atUsers) {
								commentView.setContent(comment.getContent().replace("@" + atUser,
										SystemConstant.TMP_USER_HIS_HREF.replace("NICKNAME", atUser)));
							}
						}
						commentViews.add(commentView);
					}
				}

				// 入页
				paginView.setCurPageList(commentViews);
			}

			return paginView;
		} catch (DaoException de) {
			log.error("getPagin error", de);
			throw new BizException("getPagin failure");
		} catch (Exception e) {
			log.error("getPagin error", e);
			throw new BizException("getPagin failure");
		} finally {
			count = null;
			atUsers = null;
			article = null;
			commentCond = null;
			comments = null;
			commentView = null;
			commentViews = null;
			paginView = null;
		}
	}
}
