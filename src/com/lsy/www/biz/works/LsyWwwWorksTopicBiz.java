/**
 * 
 */
package com.lsy.www.biz.works;

import com.kit.exception.BizException;
import com.lsy.www.entity.form.works.KpkpWwwWorksTopicForm;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicUploadView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicView;

/**
 * Description:作品业务接口
 *
 * @version 1.0 2016年5月18日
 * @author LSY
 */
public interface LsyWwwWorksTopicBiz {

	/**
	 * 组图详情
	 * 
	 * @param topicId
	 * @throws BizException
	 */
	public KpkpWwwWorksTopicView detail(Integer topicId) throws BizException;

	/**
	 * 获取上传视图，用于图片修改
	 * 
	 * @param topicId
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwWorksTopicUploadView getUploadView(Integer topicId) throws BizException;

	/**
	 * 组图详情
	 * 
	 * @param topicId
	 * @param userId
	 * @param roleFlag
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwWorksTopicView detail(Integer topicId, Integer userId, Integer roleFlag) throws BizException;

	/**
	 * 添加组图
	 * 
	 * @param form
	 * @return
	 * @throws BizException
	 */
	public boolean create(KpkpWwwWorksTopicForm form) throws BizException;

	/**
	 * 修改组图
	 * 
	 * @param form
	 * @return
	 * @throws BizException
	 */
	public boolean modify(KpkpWwwWorksTopicForm form) throws BizException;

	/**
	 * 回收组图
	 * 
	 * @param userId
	 * @param topicId
	 * @return
	 * @throws BizException
	 */
	public boolean recycle(Integer userId, Integer topicId) throws BizException;

	/**
	 * 获取用户关注组图分页
	 * 
	 * @param userId
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserFocusedTopic(Integer userId, Integer curPage, Integer pageRows)
			throws BizException;

	/**
	 * 获取用户最新组图分页
	 * 
	 * @param userId
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserNewestTopics(Integer userId, Integer curPage, Integer pageRows)
			throws BizException;

	/**
	 * 获取用户最新组图分页
	 * 
	 * @param nickname
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserNewestTopics(String nickname, Integer curPage, Integer pageRows)
			throws BizException;

	/**
	 * 获取推荐组图
	 * 
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getTopTopics(Integer curPage, Integer pageRows) throws BizException;

	/**
	 * 获取最新组图
	 * 
	 * @param curPage
	 * @param pageRows
	 * @return
	 * @throws BizException
	 */
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getNewestTopics(Integer curPage, Integer pageRows)
			throws BizException;

}
