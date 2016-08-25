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
import com.kit.word.JodaTimeHelper;
import com.kit.word.StringHelper;
import com.lsy.util.SpringBeanUtils;
import com.lsy.util.SystemConstant;
import com.lsy.util.SystemContext;
import com.lsy.www.biz.LsyWwwBaseBizImpl;
import com.lsy.www.dao.news.KpkpWwwNewsArticleDao;
import com.lsy.www.dao.news.KpkpWwwNewsColumnDao;
import com.lsy.www.dao.news.KpkpWwwNewsItemDao;
import com.lsy.www.entity.cond.news.KpkpWwwNewsColumnCond;
import com.lsy.www.entity.cond.news.KpkpWwwNewsItemCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsArticle;
import com.lsy.www.entity.model.news.KpkpWwwNewsColumn;
import com.lsy.www.entity.model.news.KpkpWwwNewsItem;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsArticleView;
import com.lsy.www.entity.view.news.KpkpWwwNewsColumnView;

/**
 * Description:资讯文章业务实现
 * 
 * @author LSY
 * 
 */
@Service("lsyWwwNewsArticleBiz")
public class LsyWwwNewsArticleBizImpl extends LsyWwwBaseBizImpl implements LsyWwwNewsArticleBiz {

	@Resource(name = "kpkpWwwNewsItemDao")
	private KpkpWwwNewsItemDao kpkpWwwNewsItemDao;
	@Resource(name = "kpkpWwwNewsColumnDao")
	private KpkpWwwNewsColumnDao kpkpWwwNewsColumnDao;
	@Resource(name = "kpkpWwwNewsArticleDao")
	private KpkpWwwNewsArticleDao kpkpWwwNewsArticleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getColumnView(java.lang.Integer
	 * )
	 */
	@Override
	public KpkpWwwNewsColumnView getColumnView(Integer columnId) throws BizException {
		KpkpWwwNewsColumn column = null;
		KpkpWwwNewsColumnView columnView = null;
		try {
			// 获取栏目信息
			column = this.kpkpWwwNewsColumnDao.query(columnId);

			// 如果栏目存在
			if (column != null) {
				columnView = new KpkpWwwNewsColumnView();
				SpringBeanUtils.copyProperties(column, columnView);
			} else {
				columnView = new KpkpWwwNewsColumnView();
				columnView.setName("暂无该栏目");
			}

			return columnView;
		} catch (DaoException de) {
			log.error("getColumnView error", de);
			throw new BizException("getColumnView failure");
		} catch (Exception e) {
			log.error("getColumnView error", e);
			throw new BizException("getColumnView failure");
		} finally {
			column = null;
			columnView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getColumnList(java.lang.Integer
	 * )
	 */
	@Override
	public List<KpkpWwwNewsColumnView> getColumnList(Integer size) throws BizException {
		KpkpWwwNewsColumnView columnView = null;
		KpkpWwwNewsColumnCond columnCond = null;
		List<KpkpWwwNewsColumn> columnList = null;
		List<KpkpWwwNewsColumnView> viewList = null;
		try {
			// 构建栏目查询条件
			columnCond = new KpkpWwwNewsColumnCond();
			columnCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			columnCond.setFirstResult(0);
			columnCond.setMaxResults(size);
			columnCond.setOrderParam("sn");
			columnList = this.kpkpWwwNewsColumnDao.queryByCond(columnCond);

			// 如果列表存在
			if (columnList != null && !columnList.isEmpty()) {
				viewList = new ArrayList<KpkpWwwNewsColumnView>(0);

				// 添加“全部文章”
				columnView = new KpkpWwwNewsColumnView();
				columnView.setName("全部文章");
				columnView.setArticles(this.kpkpWwwNewsColumnDao.getCounts());
				viewList.add(columnView);

				// 迭代处理
				for (KpkpWwwNewsColumn col : columnList) {
					columnView = new KpkpWwwNewsColumnView();
					SpringBeanUtils.copyProperties(col, columnView);
					viewList.add(columnView);
				}
			}

			return viewList;
		} catch (DaoException de) {
			log.error("getColumnList error", de);
			throw new BizException("getColumnList failure");
		} catch (Exception e) {
			log.error("getColumnList error", e);
			throw new BizException("getColumnList failure");
		} finally {
			columnCond = null;
			columnView = null;
			columnList = null;
			viewList = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getTopList(java.lang.Integer)
	 */
	@Override
	public List<KpkpWwwNewsArticleView> getTopList(Integer size) throws BizException {
		KpkpWwwNewsArticleView itemView = null;
		KpkpWwwNewsItemCond itemCond = null;
		List<KpkpWwwNewsItem> itemList = null;
		List<KpkpWwwNewsArticleView> viewList = null;
		try {
			// 构建栏目查询条件
			itemCond = new KpkpWwwNewsItemCond();
			itemCond.setExcludeColumnId(SystemConstant.DEFAULT_NEWS_HIDDEN_COLUMN_ID);
			itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			itemCond.setTopFlag(SystemContext.YN.YES.getValue());
			itemCond.setPubFlag(SystemContext.YN.YES.getValue());
			itemCond.setFirstResult(0);
			itemCond.setMaxResults(size);
			itemCond.setOrderParam("kpkp_news_item.toptime desc");
			itemList = this.kpkpWwwNewsItemDao.queryByCond(itemCond);

			// 如果列表存在
			if (itemList != null && !itemList.isEmpty()) {
				viewList = new ArrayList<KpkpWwwNewsArticleView>(0);

				// 迭代处理
				for (KpkpWwwNewsItem item : itemList) {
					itemView = new KpkpWwwNewsArticleView();
					SpringBeanUtils.copyProperties(item, itemView);
					itemView.setCover1(SystemConstant.HOST_FDFS + item.getCover1());
					viewList.add(itemView);
				}
			}

			return viewList;
		} catch (DaoException de) {
			log.error("getTopList error", de);
			throw new BizException("getTopList failure");
		} catch (Exception e) {
			log.error("getTopList error", e);
			throw new BizException("getTopList failure");
		} finally {
			itemCond = null;
			itemView = null;
			itemList = null;
			viewList = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getRelateList(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public List<KpkpWwwNewsArticleView> getRelateList(Integer newsId, Integer size) throws BizException {
		KpkpWwwNewsItem article = null;
		KpkpWwwNewsArticleView itemView = null;
		KpkpWwwNewsItemCond itemCond = null;
		List<KpkpWwwNewsItem> itemList = null;
		List<KpkpWwwNewsArticleView> viewList = null;
		try {
			// 获取资讯项目
			article = this.kpkpWwwNewsItemDao.query(newsId);

			// 如果资讯且标签存在
			if (null != article && !StringHelper.ifNull(article.getTag())) {

				// 构建查询条件
				itemCond = new KpkpWwwNewsItemCond();
				itemCond.setExcludeNewsId(newsId);
				itemCond.setExcludeColumnId(SystemConstant.DEFAULT_NEWS_HIDDEN_COLUMN_ID);
				itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				itemCond.setTagRelate(article.getTag().replace(";", "|"));
				itemCond.setPubFlag(SystemContext.YN.YES.getValue());
				itemCond.setFirstResult(0);
				itemCond.setMaxResults(size);
				itemCond.setOrderParam("kpkp_news_item.toptime desc");
				itemList = this.kpkpWwwNewsItemDao.queryByCond(itemCond);

				// 如果列表存在
				if (itemList != null && !itemList.isEmpty()) {
					viewList = new ArrayList<KpkpWwwNewsArticleView>(0);

					// 迭代处理
					for (KpkpWwwNewsItem item : itemList) {
						itemView = new KpkpWwwNewsArticleView();
						SpringBeanUtils.copyProperties(item, itemView);
						itemView.setCover2(SystemConstant.HOST_FDFS + item.getCover2());
						viewList.add(itemView);
					}
					return viewList;
				}
			}

			return null;
		} catch (DaoException de) {
			log.error("getTopList error", de);
			throw new BizException("getTopList failure");
		} catch (Exception e) {
			log.error("getTopList error", e);
			throw new BizException("getTopList failure");
		} finally {
			itemCond = null;
			itemView = null;
			itemList = null;
			viewList = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getDetail(java.lang.Integer)
	 */
	@Override
	public KpkpWwwNewsArticleView getDetail(Integer newsId) throws BizException {
		KpkpWwwNewsItem item = null;
		KpkpWwwNewsColumn column = null;
		KpkpWwwNewsArticle article = null;
		KpkpWwwNewsArticleView articleView = null;
		try {
			// 获取资讯项目
			item = this.kpkpWwwNewsItemDao.query(newsId);

			// 如果项目存在
			if (null != item && item.getRecycleFlag().equals(SystemContext.YN.NO.getValue())) {
				articleView = new KpkpWwwNewsArticleView();
				SpringBeanUtils.copyProperties(item, articleView);
				articleView.setPubDateDes(JodaTimeHelper.getDate(item.getPubDate()));

				// 获取资讯栏目
				column = this.kpkpWwwNewsColumnDao.query(item.getColumnId());

				// 如果栏目存在
				if (null != column) {
					articleView.setColumnName(column.getName());
				}

				// 获取文章
				article = this.kpkpWwwNewsArticleDao.query(newsId);

				// 如果文章存在
				if (null != article) {
					articleView.setContent(article.getContent());
				}

				// 如果标签存在
				if (!StringHelper.ifNull(item.getTag())) {

					// 迭代处理
					for (String str : item.getTag().split(";")) {
						if (!str.equals("")) {
							articleView.setTag(articleView.getTag()
									.replace(str, SystemConstant.TMP_NEWS_TAG_HREF.replace("TAG", str))
									.replaceAll(";", ""));
						}
					}
				}

				// 更新点击量
				this.kpkpWwwNewsItemDao.updateViews(newsId, 1);
			}

			return articleView;
		} catch (DaoException de) {
			log.error("getDetail error", de);
			throw new BizException("getDetail failure");
		} catch (Exception e) {
			log.error("getDetail error", e);
			throw new BizException("getDetail failure");
		} finally {
			item = null;
			article = null;
			column = null;
			articleView = null;
		}
	}

	/**
	 * 获取文章分页
	 * 
	 * @param itemCond
	 * @return
	 * @throws BizException
	 */
	private LsyWwwPaginView<KpkpWwwNewsArticleView> getPagin(KpkpWwwNewsItemCond itemCond) throws BizException {
		List<KpkpWwwNewsItem> items = null;
		KpkpWwwNewsArticleView articleView = null;
		List<KpkpWwwNewsArticleView> articleViews = null;
		LsyWwwPaginView<KpkpWwwNewsArticleView> paginViews = null;
		try {
			// 如果文章存在
			if (null != itemCond.getTotalRows() && itemCond.getTotalRows() > 0) {
				// 构建资讯视图及列表
				articleViews = new ArrayList<KpkpWwwNewsArticleView>(0);
				paginViews = new LsyWwwPaginView<KpkpWwwNewsArticleView>(itemCond.getCurPage(), itemCond.getPageRows(),
						itemCond.getTotalRows());

				// 获取文章项目列表
				itemCond.setMaxResults(paginViews.getMaxResults());
				itemCond.setFirstResult(paginViews.getFirstResult());
				itemCond.setExcludeColumnId(SystemConstant.DEFAULT_NEWS_HIDDEN_COLUMN_ID);
				itemCond.setPubFlag(SystemContext.YN.YES.getValue());
				itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				itemCond.setOrderParam("pubDate desc, addTime desc, topFlag desc, topTime desc");
				items = this.kpkpWwwNewsItemDao.queryByCond(itemCond);

				// 如果资讯存在
				if (null != items && !items.isEmpty()) {

					// 迭代处理
					for (KpkpWwwNewsItem item : items) {
						articleView = new KpkpWwwNewsArticleView();
						SpringBeanUtils.copyProperties(item, articleView);
						articleView.setCover2(SystemConstant.HOST_FDFS + item.getCover2());
						articleView.setPubDateDes(JodaTimeHelper.getDate(item.getPubDate()));
						articleViews.add(articleView);
					}
				}

				// 入页
				paginViews.setCurPageList(articleViews);
			}

			return paginViews;
		} catch (DaoException de) {
			log.error("getPagin error", de);
			throw new BizException("getPagin failure");
		} catch (Exception e) {
			log.error("getPagin error", e);
			throw new BizException("getPagin failure");
		} finally {
			items = null;
			itemCond = null;
			articleView = null;
			articleViews = null;
			paginViews = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getAllPagin(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getAllPagin(Integer curPage, Integer pageRows) throws BizException {
		Integer articles = null;
		KpkpWwwNewsItemCond itemCond = null;
		try {
			// 获取文章总数
			articles = this.kpkpWwwNewsColumnDao.getCounts();

			// 获取所有文章分页
			itemCond = new KpkpWwwNewsItemCond();
			itemCond.setCurPage(curPage);
			itemCond.setPageRows(pageRows);
			itemCond.setTotalRows(articles);
			itemCond.setColumnFlag(SystemContext.YN.YES.getValue());
			return this.getPagin(itemCond);

		} catch (DaoException de) {
			log.error("getPagin error", de);
			throw new BizException("getPagin failure");
		} catch (Exception e) {
			log.error("getPagin error", e);
			throw new BizException("getPagin failure");
		} finally {
			articles = null;
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getTagPagin(java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getTagPagin(String tagName, Integer curPage, Integer pageRows)
			throws BizException {
		Integer articles = null;
		KpkpWwwNewsItemCond itemCond = null;
		try {
			// 获取文章总数
			itemCond = new KpkpWwwNewsItemCond();
			itemCond.setTagName(tagName);
			itemCond.setPubFlag(SystemContext.YN.YES.getValue());
			itemCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			articles = this.kpkpWwwNewsItemDao.countByCond(itemCond);

			// 如果文章存在
			if (articles > 0) {
				itemCond.setCurPage(curPage);
				itemCond.setPageRows(pageRows);
				itemCond.setTotalRows(articles);
				itemCond.setColumnFlag(SystemContext.YN.YES.getValue());
				return this.getPagin(itemCond);
			} else {
				return null;
			}
		} catch (DaoException de) {
			log.error("getTagPagin error", de);
			throw new BizException("getTagPagin failure");
		} catch (Exception e) {
			log.error("getTagPagin error", e);
			throw new BizException("getTagPagin failure");
		} finally {
			articles = null;
			itemCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.news.LsyWwwNewsArticleBiz#getColumnPagin(java.lang.Integer
	 * , java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getColumnPagin(Integer columnId, Integer curPage, Integer pageRows)
			throws BizException {
		KpkpWwwNewsColumn column = null;
		KpkpWwwNewsItemCond itemCond = null;
		try {
			// 获取资讯栏目
			column = this.kpkpWwwNewsColumnDao.query(columnId);

			// 如果栏目存在
			if (column != null) {
				itemCond = new KpkpWwwNewsItemCond();
				itemCond.setColumnId(columnId);
				itemCond.setColumnFlag(SystemContext.YN.YES.getValue());
				itemCond.setCurPage(curPage);
				itemCond.setPageRows(pageRows);
				itemCond.setTotalRows(column.getArticles());
				return this.getPagin(itemCond);
			} else {
				return null;
			}
		} catch (DaoException de) {
			log.error("getColumnPagin error", de);
			throw new BizException("getColumnPagin failure");
		} catch (Exception e) {
			log.error("getColumnPagin error", e);
			throw new BizException("getColumnPagin failure");
		} finally {
			column = null;
			itemCond = null;
		}
	}

}
