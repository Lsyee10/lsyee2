/**
 * 
 */
package com.lsy.www.biz.news;

import com.kit.exception.BizException;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsArticleView;
import com.lsy.www.entity.view.news.KpkpWwwNewsColumnView;

import java.util.List;

/**
 * Description:文章资讯接口
 *
 * @version 1.0 2016年4月20日
 * @author LSY
 */
public interface LsyWwwNewsArticleBiz {

	/**
	 * 获取栏目视图
	 * 
	 * @param culumnId
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwNewsColumnView getColumnView(Integer columnId) throws BizException;

	/**
	 * 获取栏目名称列表
	 * 
	 * @param size
	 * @return
	 * @throws BizException
	 */
	public List<KpkpWwwNewsColumnView> getColumnList(Integer size) throws BizException;

	/**
	 * 获取推荐文章列表（猜你喜欢 ）
	 * 
	 * @param size
	 * @return
	 * @throws BizException
	 */
	public List<KpkpWwwNewsArticleView> getTopList(Integer size) throws BizException;

	/**
	 * 获取标签相关文章列表
	 * 
	 * @param newsId
	 * @param size
	 * @return
	 * @throws BizException
	 */
	public List<KpkpWwwNewsArticleView> getRelateList(Integer newsId, Integer size) throws BizException;

	/**
	 * 获取文章详情
	 * 
	 * @param newsId
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwNewsArticleView getDetail(Integer newsId) throws BizException;

	/**
	 * 获取全部文章分页列表
	 * 
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getAllPagin(Integer curPage, Integer pageRows) throws BizException;

	/**
	 * 获取标签文章分页
	 * 
	 * @param tagName
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getTagPagin(String tagName, Integer curPage, Integer pageRows)
			throws BizException;

	/**
	 * 获取栏目文章分页
	 * 
	 * @param columnId
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwNewsArticleView> getColumnPagin(Integer columnId, Integer curPage, Integer pageRows)
			throws BizException;

}
