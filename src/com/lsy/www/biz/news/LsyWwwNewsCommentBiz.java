/**
 * 
 */
package com.lsy.www.biz.news;

import com.kit.exception.BizException;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsCommentView;

/**
 * Description:文章评论业务接口
 *
 * @version 1.0 2016年4月27日
 * @author LSY
 */
public interface LsyWwwNewsCommentBiz {

	/**
	 * 添加评论
	 * 
	 * @param userId
	 * @param reId
	 * @param newsId
	 * @param content
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwNewsCommentView create(Integer userId, Integer reId, Integer newsId, String content)
			throws BizException;

	/**
	 * 删除评论
	 * 
	 * @param commentId
	 * @return
	 * @throws BizException
	 */
	public boolean delete(Integer commentId) throws BizException;

	/**
	 * 文章评论详情
	 * 
	 * @param newsId
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwNewsCommentView> getPagin(Integer newsId, Integer curPage, Integer pageRows)
			throws BizException;

}
