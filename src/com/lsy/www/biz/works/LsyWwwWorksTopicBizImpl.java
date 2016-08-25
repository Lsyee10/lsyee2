/**
 * 
 */
package com.lsy.www.biz.works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.lsy.www.dao.activity.KpkpWwwActivityItemDao;
import com.lsy.www.dao.user.KpkpWwwUserAccountDao;
import com.lsy.www.dao.works.KpkpWwwWorksPhotoDao;
import com.lsy.www.dao.works.KpkpWwwWorksPhotoTagDao;
import com.lsy.www.dao.works.KpkpWwwWorksPraiseDao;
import com.lsy.www.dao.works.KpkpWwwWorksTagDao;
import com.lsy.www.dao.works.KpkpWwwWorksTopicDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPhotoCond;
import com.lsy.www.entity.cond.works.KpkpWwwWorksTopicCond;
import com.lsy.www.entity.form.works.KpkpWwwWorksTopicForm;
import com.lsy.www.entity.model.activity.KpkpWwwActivityItem;
import com.lsy.www.entity.model.user.KpkpWwwUserAccount;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhoto;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhotoTag;
import com.lsy.www.entity.model.works.KpkpWwwWorksTag;
import com.lsy.www.entity.model.works.KpkpWwwWorksTopic;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.works.KpkpWwwWorksPhotoUploadView;
import com.lsy.www.entity.view.works.KpkpWwwWorksPhotoView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicUploadView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicView;

/**
 * Description:作品业务实现
 *
 * @version 1.0 2016年5月18日
 * @author LSY
 */
@Service("lsyWwwWorksTopicBiz")
public class LsyWwwWorksTopicBizImpl extends LsyWwwBaseBizImpl implements LsyWwwWorksTopicBiz {

	@Resource(name = "kpkpWwwWorksTagDao")
	private KpkpWwwWorksTagDao kpkpWwwWorksTagDao;
	@Resource(name = "kpkpWwwWorksTopicDao")
	private KpkpWwwWorksTopicDao kpkpWwwWorksTopicDao;
	@Resource(name = "kpkpWwwWorksPhotoDao")
	private KpkpWwwWorksPhotoDao kpkpWwwWorksPhotoDao;
	@Resource(name = "kpkpWwwWorksPhotoTagDao")
	private KpkpWwwWorksPhotoTagDao kpkpWwwWorksPhotoTagDao;
	@Resource(name = "kpkpWwwActivityItemDao")
	private KpkpWwwActivityItemDao kpkpWwwActivityItemDao;
	@Resource(name = "kpkpWwwUserAccountDao")
	private KpkpWwwUserAccountDao kpkpWwwUserAccountDao;
	@Resource(name = "kpkpWwwWorksPraiseDao")
	private KpkpWwwWorksPraiseDao kpkpWwwWorksPraiseDao;

	private LsyWwwUserStatsBiz getKpkpWwwUserStatsBiz() {
		return (LsyWwwUserStatsBiz) SpringContextUtil.getApplicationContext().getBean("lsyWwwUserStatsBiz");
	}

	/**
	 * 过滤字符串
	 * 
	 * @param str
	 * @return
	 */
	private String filterIntro(String str) {

		// 如果字符存在
		if (!StringHelper.ifNull(str)) {
			str = StringHelper.url2Text(str);
		}

		// 如果字符存在
		if (!StringHelper.ifNull(str)) {
			str = StringHelper.html2Text(str);
		}

		// 如果字符存在
		if (!StringHelper.ifNull(str)) {
			str = SecureHelper.filterWord(str);
		}

		return str;
	}

	/**
	 * 替换标签链接
	 * 
	 * @param content
	 * @return
	 * @throws BizException
	 */
	private String replaceLink(String content) throws BizException {
		List<String> tags = null;
		List<String> nicknames = null;
		try {
			// 如果内容存在
			if (!StringHelper.ifNull(content)) {
				tags = StringHelper.getTags(content);
				nicknames = StringHelper.getAtNicknames(content);

				// 如果标签存在
				if (null != tags && !tags.isEmpty()) {
					for (String tag : tags) {
						content = content.replace("#" + tag, SystemConstant.TMP_WORKS_TAG_HREF.replace("TAG", tag));
					}
				}

				// 如果昵称存在
				if (null != nicknames && !nicknames.isEmpty()) {
					for (String nickname : nicknames) {
						content = content.replace("@" + nickname,
								SystemConstant.TMP_USER_HIS_HREF.replace("NICKNAME", nickname));
					}
				}
			}
			return content;
		} catch (Exception e) {
			log.error("replaceLink error", e);
			throw new BizException("replaceLink failure");
		} finally {
			tags = null;
			nicknames = null;
		}
	}

	/**
	 * 获取用户权限
	 * 
	 * @param userId
	 * @param userRoleFlag
	 * @param topic
	 * @return
	 * @throws BizException
	 */
	private Map<Integer, String> getOptions(Integer userId, Integer userRoleFlag, KpkpWwwWorksTopic topic)
			throws BizException {
		Map<Integer, String> options = null;
		try {
			/*************************************** 获取操作权限 *********************************************/
			options = new HashMap<Integer, String>(0);

			// 如果是管理员
			if (SystemContext.USER_ACCOUNT_TYPE.ADMIN.getValue().equals(userRoleFlag)) {
				// 回收
				options.put(SystemContext.WORKS_OPTION.RECYCLE.getValue(),
						SystemContext.WORKS_OPTION.RECYCLE.getLabel());
			}
			// 如果是本人组照
			else if (topic.getUserId().equals(userId)) {
				// 回收
				options.put(SystemContext.WORKS_OPTION.RECYCLE.getValue(),
						SystemContext.WORKS_OPTION.RECYCLE.getLabel());
			}

			return options;
		} catch (Exception e) {
			log.error("getOptions error", e);
			throw new BizException("getOptions failure");
		} finally {
			options = null;
		}
	}

	/**
	 * 获取主题下的照片
	 * 
	 * @param topicId
	 * @param size
	 * @return
	 * @throws BizException
	 */
	public List<KpkpWwwWorksPhotoView> getTopicPhotos(Integer topicId, Integer size) throws BizException {
		// TODO Auto-generated method stub
		List<KpkpWwwWorksPhoto> photos = null;
		KpkpWwwWorksPhotoCond photoCond = null;
		KpkpWwwWorksPhotoView photoView = null;
		List<KpkpWwwWorksPhotoView> photoViews = null;
		try {
			// 获取该主题下的照片
			photoCond = new KpkpWwwWorksPhotoCond();
			photoCond.setTopicId(topicId);
			photoCond.setFirstResult(0);
			photoCond.setMaxResults(size);
			photoCond.setOrderParam("kpkp_works_photo.sn asc");
			photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			photos = this.kpkpWwwWorksPhotoDao.queryByCond(photoCond);

			// 如果照片存在
			if (null != photos && !photos.isEmpty()) {
				photoViews = new ArrayList<KpkpWwwWorksPhotoView>(photos.size());

				// 迭代处理
				for (KpkpWwwWorksPhoto photo : photos) {
					photoView = new KpkpWwwWorksPhotoView();
					SpringBeanUtils.copyProperties(photo, photoView);
					photoView.setImg2(SystemConstant.HOST_FDFS + photo.getImg2());
					photoView.setImg3(SystemConstant.HOST_FDFS + photo.getImg3());
					photoView.setStarDateDes(JodaTimeHelper.getMonthDay(photo.getStarDate()));
					photoView.setAddTimeDes(JodaTimeHelper.getBeforeNowDay(photo.getAddTime()));
					photoViews.add(photoView);
				}
			}
			return photoViews;
		} catch (DaoException de) {
			log.error("getTopicPhotos error", de);
			throw new BizException("getTopicPhotos failure");
		} catch (Exception e) {
			log.error("getTopicPhotos error", e);
			throw new BizException("getTopicPhotos failure");
		} finally {
			photos = null;
			photoCond = null;
			photoView = null;
			photoViews = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#detail(java.lang.Integer
	 * )
	 */
	@Override
	public KpkpWwwWorksTopicView detail(Integer topicId) throws BizException {
		KpkpWwwUserAccount user = null;
		KpkpWwwWorksTopic topic = null;
		KpkpWwwWorksTopicView topicView = null;
		try {
			// 获取组照主题封面
			topic = this.kpkpWwwWorksTopicDao.query(topicId);

			// 如果主题存在
			if (null != topic && topic.getRecycleFlag().equals(SystemContext.YN.NO.getValue())) {
				// 拷贝属性
				topicView = new KpkpWwwWorksTopicView();
				SpringBeanUtils.copyProperties(topic, topicView);
				topicView.setIntro(this.replaceLink(topic.getIntro()));
				topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));

				// 获取用户
				user = this.kpkpWwwUserAccountDao.query(topic.getUserId());

				// 如果用户存在,且有效
				if (null != user && SystemContext.YN.NO.getValue().equals(user.getRecycleFlag())
						&& SystemContext.YN.YES.getValue().equals(user.getStateFlag())) {
					topicView.setNickname(user.getNickname());
					topicView.setAvatar(SystemConstant.HOST_FDFS + user.getAvatar());
				} else {
					return null;
				}

				// 获取该组照的所有照片
				topicView.setPhotoList(this.getTopicPhotos(topicId, topic.getPhotos()));
			}
			return topicView;
		} catch (DaoException de) {
			log.error("detail error", de);
			throw new BizException("detail failure");
		} catch (Exception e) {
			log.error("detail error", e);
			throw new BizException("detail failure");
		} finally {
			topic = null;
			topicView = null;
			user = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#detail(java.lang.Integer
	 * , java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public KpkpWwwWorksTopicView detail(Integer topicId, Integer userId, Integer roleFlag) throws BizException {
		KpkpWwwUserAccount user = null;
		KpkpWwwActivityItem activity = null;
		KpkpWwwWorksTopic topic = null;
		KpkpWwwWorksTopicView topicView = null;
		try {
			// 获取组照主题封面
			topic = this.kpkpWwwWorksTopicDao.query(topicId);

			// 如果主题存在
			if (null != topic && topic.getRecycleFlag().equals(SystemContext.YN.NO.getValue())) {
				// 拷贝属性
				topicView = new KpkpWwwWorksTopicView();
				SpringBeanUtils.copyProperties(topic, topicView);
				topicView.setIntro(this.replaceLink(topic.getIntro()));
				topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));

				// 获取用户
				user = this.kpkpWwwUserAccountDao.query(topic.getUserId());

				// 如果用户存在,且有效
				if (null != user && SystemContext.YN.NO.getValue().equals(user.getRecycleFlag())
						&& SystemContext.YN.YES.getValue().equals(user.getStateFlag())) {
					topicView.setNickname(user.getNickname());
					topicView.setAvatar(SystemConstant.HOST_FDFS + user.getAvatar());
				} else {
					return null;
				}

				// 如果任务ID存在
				if (topic.getTaskId() > 0) {
					// 获取活动
					activity = this.kpkpWwwActivityItemDao.query(topic.getTaskId());

					// 如果活动存在
					if (null != activity) {
						topicView.setTaskName(activity.getName());
					}
				}

				// 如果小站ID存在
				if (topic.getStationId() > 0) {
					// 获取小站
					activity = this.kpkpWwwActivityItemDao.query(topic.getStationId());

					// 如果小站存在
					if (null != activity) {
						topicView.setStationName(activity.getName());
					}
				}

				// 获取该组照的所有照片
				topicView.setPhotoList(this.getTopicPhotos(topicId, topic.getPhotos()));

				// 设置操作权限
				topicView.setOptions(this.getOptions(userId, roleFlag, topic));
			}
			return topicView;
		} catch (DaoException de) {
			log.error("detail error", de);
			throw new BizException("detail failure");
		} catch (Exception e) {
			log.error("detail error", e);
			throw new BizException("detail failure");
		} finally {
			activity = null;
			topic = null;
			topicView = null;
			user = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#getUploadView(java.
	 * lang.Integer)
	 */
	@Override
	public KpkpWwwWorksTopicUploadView getUploadView(Integer topicId) throws BizException {
		List<KpkpWwwWorksPhoto> photos = null;
		KpkpWwwWorksPhotoCond photoCond = null;
		KpkpWwwWorksTopic topic = null;
		KpkpWwwWorksTopicUploadView topicView = null;
		KpkpWwwWorksPhotoUploadView photoView = null;
		List<KpkpWwwWorksPhotoUploadView> photoViews = null;
		try {
			// 获取组照主题封面
			topic = this.kpkpWwwWorksTopicDao.query(topicId);

			// 如果主题存在
			if (null != topic) {
				// 拷贝属性
				topicView = new KpkpWwwWorksTopicUploadView();
				SpringBeanUtils.copyProperties(topic, topicView);

				// 获取该主题下的照片
				photoCond = new KpkpWwwWorksPhotoCond();
				photoCond.setTopicId(topicId);
				photoCond.setFirstResult(0);
				photoCond.setMaxResults(topic.getPhotos());
				photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				photoCond.setOrderParam("sn asc");
				photos = this.kpkpWwwWorksPhotoDao.queryByCond(photoCond);

				// 如果照片存在
				if (null != photos && !photos.isEmpty()) {
					photoViews = new ArrayList<KpkpWwwWorksPhotoUploadView>(photos.size());

					// 迭代处理
					for (KpkpWwwWorksPhoto photo : photos) {
						photoView = new KpkpWwwWorksPhotoUploadView();
						SpringBeanUtils.copyProperties(photo, photoView);
						photoView.setHost(SystemConstant.HOST_FDFS);
						photoView.setJson(JSONObject.fromObject(photoView).toString());
						photoViews.add(photoView);
					}

					topicView.setPhotoList(photoViews);
				}
			}
			return topicView;
		} catch (DaoException de) {
			log.error("getUploadView error", de);
			throw new BizException("getUploadView failure");
		} catch (Exception e) {
			log.error("getUploadView error", e);
			throw new BizException("getUploadView failure");
		} finally {
			photos = null;
			photoCond = null;
			topic = null;
			topicView = null;
			photoView = null;
			photoViews = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#create(com.lsy.www.
	 * entity.form.works.KpkpWwwWorksTopicForm)
	 */
	@Override
	public boolean create(KpkpWwwWorksTopicForm topicForm) throws BizException {
		JSONObject json = null;
		JSONArray photos = null;
		List<String> tagNames = null;
		KpkpWwwWorksTag tag = null;
		KpkpWwwWorksTopic topic = null;
		KpkpWwwWorksPhoto photo = null;
		KpkpWwwWorksPhotoTag photoTag = null;
		try {
			// 如果照片存在
			if (!StringHelper.ifNull(topicForm.getPhotoJson())) {

				// 转成java对象
				json = JSONObject.fromObject(topicForm.getPhotoJson());
				photos = json.getJSONArray("photos");

				// 如果照片对象存在
				if (null != photos && !photos.isEmpty()) {

					// 如果照片超过10
					if (photos.size() > 30) {
						return false;
					}

					/********************************************** 开始处理封面 *****************************************************/
					// 迭代添加主题
					for (int i = 0; i < photos.size(); i++) {

						// 如果是封面
						if (SystemContext.YN.YES.getValue().equals(photos.getJSONObject(i).getInt("coverFlag"))) {

							// 保存组照封面
							topic = new KpkpWwwWorksTopic();
							SpringBeanUtils.copyProperties(topicForm, topic);
							topic.setViews(0);
							topic.setPraises(0);
							topic.setComments(0);
							topic.setPhotos(photos.size());
							topic.setIntro(this.filterIntro(topic.getIntro()));
							topic.setImg2(photos.getJSONObject(i).getString("img2"));
							topic.setImg3(photos.getJSONObject(i).getString("img3"));
							topic.setImg4(photos.getJSONObject(i).getString("img4"));
							topic.setTopTime(DateTimeHelper.getTimestamp());
							topic.setAddTime(DateTimeHelper.getTimestamp());
							topic.setTopFlag(SystemContext.YN.NO.getValue());
							topic.setRecycleFlag(SystemContext.YN.NO.getValue());
							this.kpkpWwwWorksTopicDao.insert(topic);

							// 增加用户组照主题数
							this.getKpkpWwwUserStatsBiz().updownTopics(topic.getUserId(), DateTimeHelper.getDate(), 1);
							break;
						}
					}
					/********************************************** 结束处理封面 *****************************************************/

					/********************************************** 开始处理照片 *****************************************************/
					// 迭代添加照片
					for (int i = 0; i < photos.size(); i++) {

						// 保存照片
						photo = new KpkpWwwWorksPhoto();
						SpringBeanUtils.copyProperties(topic, photo);
						photo.setSn(i + 1);
						photo.setViews(0);
						photo.setPraises(0);
						photo.setComments(0);
						photo.setEffect("");
						photo.setTopicId(topic.getTopicId());
						photo.setImg2(photos.getJSONObject(i).getString("img2"));
						photo.setImg3(photos.getJSONObject(i).getString("img3"));
						photo.setImg4(photos.getJSONObject(i).getString("img4"));
						photo.setIntro(this.filterIntro(photos.getJSONObject(i).getString("intro")));
						photo.setAwardFlag(SystemContext.YN.NO.getValue());
						photo.setChoiceFlag(SystemContext.YN.NO.getValue());
						photo.setCoverFlag(SystemContext.YN.YES.getValue().equals(
								photos.getJSONObject(i).getInt("coverFlag")) ? SystemContext.YN.YES.getValue()
								: SystemContext.YN.NO.getValue());
						// 入库
						this.kpkpWwwWorksPhotoDao.insert(photo);

						// 如果描述存在
						if (!StringHelper.ifNull(photo.getIntro())) {

							// 获取照片描述中的标签
							tagNames = StringHelper.getTags(photo.getIntro());

							// 如果标签存在
							if (null != tagNames && !tagNames.isEmpty()) {

								// 迭代处理标签
								for (String tagName : tagNames) {

									// 获取作品标签
									tag = this.kpkpWwwWorksTagDao.queryByName(tagName);

									// 如果标签不存在
									if (null == tag) {

										// 添加到标签库
										tag = new KpkpWwwWorksTag();
										tag.setUserId(photo.getUserId());
										tag.setName(tagName);
										tag.setUsers(1);
										tag.setPhotos(1);
										tag.setAddTime(DateTimeHelper.getTimestamp());
										tag.setTopFlag(SystemContext.YN.NO.getValue());
										tag.setRecycleFlag(SystemContext.YN.NO.getValue());
										this.kpkpWwwWorksTagDao.insert(tag);
									} else {

										// 更新标签的照片数
										this.kpkpWwwWorksTagDao.updownPhotos(tag.getTagId(), 1);
									}

									// 保存标签关系
									photoTag = new KpkpWwwWorksPhotoTag();
									photoTag.setTagId(tag.getTagId());
									photoTag.setUserId(photo.getUserId());
									photoTag.setPhotoId(photo.getPhotoId());
									photoTag.setTopicId(topic.getTopicId());
									this.kpkpWwwWorksPhotoTagDao.insert(photoTag);
								}
							}
						}
					}

					// 增加用户照片数
					this.getKpkpWwwUserStatsBiz().updownPhotos(topic.getUserId(), DateTimeHelper.getDate(),
							photos.size());
					return true;
					/********************************************** 结束处理照片 *****************************************************/
				}
			}

			return false;
		} catch (DaoException de) {
			log.error("create error", de);
			throw new BizException("create failure");
		} catch (Exception e) {
			log.error("create error", e);
			throw new BizException("create failure");
		} finally {
			json = null;
			photos = null;
			tagNames = null;
			tag = null;
			topic = null;
			photo = null;
			photoTag = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#modify(com.lsy.www.
	 * entity.form.works.KpkpWwwWorksTopicForm)
	 */
	@Override
	public boolean modify(KpkpWwwWorksTopicForm topicForm) throws BizException {
		JSONObject json = null;
		JSONArray photos = null;
		List<String> tagNames = null;
		KpkpWwwWorksTag tag = null;
		KpkpWwwWorksTopic topic = null;
		KpkpWwwWorksPhoto photo = null;
		KpkpWwwWorksPhotoTag photoTag = null;
		List<KpkpWwwWorksPhotoTag> photoTags = null;
		try {
			// 如果照片存在
			if (!StringHelper.ifNull(topicForm.getPhotoJson())) {
				// 转化成java对象
				json = JSONObject.fromObject(topicForm.getPhotoJson());
				photos = json.getJSONArray("photos");

				// 如果照片对象存在
				if (null != photos && !photos.isEmpty()) {
					// 如果上传照片数超过30
					if (photos.size() > 30) {
						return false;
					}
					/* 开始处理封面 */
					// 获取当前封面主题
					topic = this.kpkpWwwWorksTopicDao.query(topicForm.getTopicId());

					// 如果主题存在
					if (null != topic && SystemContext.YN.NO.getValue().equals(topic.getRecycleFlag())) {

						// 迭代遍历主题
						for (int i = 0; i < photos.size(); i++) {

							// 如果是封面
							if (SystemContext.YN.YES.getValue().equals(photos.getJSONObject(i).getInt("coverFlag"))) {

								// 保存组照封面
								topic = new KpkpWwwWorksTopic();
								SpringBeanUtils.copyProperties(topicForm, topic);
								topic.setPhotos(photos.size());
								topic.setImg2(photos.getJSONObject(i).getString("img2"));
								topic.setImg3(photos.getJSONObject(i).getString("img3"));
								topic.setImg4(photos.getJSONObject(i).getString("img4"));
								topic.setIntro(this.filterIntro(topic.getIntro()));
								this.kpkpWwwWorksTopicDao.insert(topic);
								break;
							}
						}
					}
					/* 开始处理照片 */
					// 回收组照
					this.recycle(topic.getUserId(), topic.getTopicId());

					// 迭代修改照片
					for (int i = 0; i < photos.size(); i++) {
						// 如果是新照片
						if (photos.getJSONObject(i).containsKey("photoId")
								&& photos.getJSONObject(i).getInt("photoId") == 0) {

							// 保存照片
							photo = new KpkpWwwWorksPhoto();
							SpringBeanUtils.copyProperties(topic, photo);
							photo.setSn(i + 1);
							photo.setViews(0);
							photo.setPraises(0);
							photo.setComments(0);
							photo.setTopicId(topic.getTopicId());
							photo.setImg2(photos.getJSONObject(i).getString("img2"));
							photo.setImg3(photos.getJSONObject(i).getString("img3"));
							photo.setImg4(photos.getJSONObject(i).getString("img4"));
							topic.setIntro(this.filterIntro(photos.getJSONObject(i).getString("intro")));
							photo.setAwardFlag(SystemContext.YN.NO.getValue());
							photo.setChoiceFlag(SystemContext.YN.NO.getValue());
							photo.setCoverFlag(SystemContext.YN.YES.getValue().equals(
									photos.getJSONObject(i).getInt("coverFlag")) ? SystemContext.YN.YES.getValue()
									: SystemContext.YN.NO.getValue());

						}
						// 如果是老照片
						else {
							// 获取当前照片ID
							int photoId = photos.getJSONObject(i).getInt("photoId");

							// 获取当前照片的标签关系
							photoTags = this.kpkpWwwWorksPhotoTagDao.query(photoId);

							// 如果标签关系存在
							if (null != photoTags && !photoTags.isEmpty()) {
								// 迭代更新标签对应的照片数和使用人数
								for (KpkpWwwWorksPhotoTag item : photoTags) {
									this.kpkpWwwWorksTagDao.updownUsers(item.getTagId(), -1);
									this.kpkpWwwWorksTagDao.updownPhotos(item.getTagId(), -1);
								}
							}
							// 删除当前照片的标签关系
							this.kpkpWwwWorksPhotoTagDao.delete(photoId);

							// 恢复被回收照片
							photo = new KpkpWwwWorksPhoto();
							photo.setPhotoId(photoId);
							photo.setTaskId(topicForm.getTaskId());
							photo.setStationId(topicForm.getStationId());
							photo.setIntro(this.filterIntro(photos.getJSONObject(i).getString("intro")));
							photo.setRecycleFlag(SystemContext.YN.NO.getValue());
							this.kpkpWwwWorksPhotoDao.update(photo);
						}

						// 如果描述存在
						if (!StringHelper.ifNull(photo.getIntro())) {

							// 获取照片描述中的标签
							tagNames = StringHelper.getTags(photo.getIntro());

							// 如果标签存在
							if (null != tagNames && !tagNames.isEmpty()) {

								// 迭代处理标签
								for (String tagName : tagNames) {

									// 获取作品标签
									tag = this.kpkpWwwWorksTagDao.queryByName(tagName);

									// 如果标签不存在
									if (null == tag) {

										// 添加到标签库
										tag = new KpkpWwwWorksTag();
										tag.setUserId(photo.getUserId());
										tag.setName(tagName);
										tag.setUsers(1);
										tag.setPhotos(1);
										tag.setAddTime(DateTimeHelper.getTimestamp());
										tag.setTopFlag(SystemContext.YN.NO.getValue());
										tag.setRecycleFlag(SystemContext.YN.NO.getValue());
										this.kpkpWwwWorksTagDao.insert(tag);
									} else {

										// 更新标签的照片数
										this.kpkpWwwWorksTagDao.updownPhotos(tag.getTagId(), 1);
									}

									// 保存标签关系
									photoTag = new KpkpWwwWorksPhotoTag();
									photoTag.setTagId(tag.getTagId());
									photoTag.setUserId(photo.getUserId());
									photoTag.setPhotoId(photo.getPhotoId());
									photoTag.setTopicId(topic.getTopicId());
									this.kpkpWwwWorksPhotoTagDao.insert(photoTag);
								}
							}
						}
					}
					// 增加用户照片数
					this.getKpkpWwwUserStatsBiz().updownPhotos(topic.getUserId(), DateTimeHelper.getDate(),
							photos.size());

					// 恢复组照的回收标示
					this.kpkpWwwWorksTopicDao.updateRecycle(topicForm.getTopicId(), SystemContext.YN.NO.getValue());

					return true;
				}

			}
			return false;
		} catch (DaoException de) {
			log.error("modify error", de);
			throw new BizException("modify failure");
		} catch (Exception e) {
			log.error("modify error", e);
			throw new BizException("modify failure");
		} finally {
			json = null;
			photos = null;
			tagNames = null;
			tag = null;
			topic = null;
			photo = null;
			photoTag = null;
			photoTags = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#recycle(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public boolean recycle(Integer userId, Integer topicId) throws BizException {
		KpkpWwwWorksTopic topic = null;
		List<KpkpWwwWorksPhoto> photos = null;
		KpkpWwwWorksPhotoCond photoCond = null;
		try {
			// 获取组照主题封面
			topic = this.kpkpWwwWorksTopicDao.query(topicId);

			// 如果主题存在
			if (null != topic) {

				// 获取当前主题照片
				photoCond = new KpkpWwwWorksPhotoCond();
				photoCond.setTopicId(topicId);
				photoCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				photos = this.kpkpWwwWorksPhotoDao.queryByCond(photoCond);

				// 如果照片存在
				if (null != photos && !photos.isEmpty()) {

					// 迭代判断
					for (KpkpWwwWorksPhoto photo : photos) {

						// 如果照片已被编辑
						if (SystemContext.YN.YES.getValue().equals(photo.getChoiceFlag())
								|| SystemContext.YN.YES.getValue().equals(photo.getStarFlag())
								|| SystemContext.YN.YES.getValue().equals(photo.getAwardFlag())) {
							return false;
						}
					}
				}

				// 回收组照封面主题
				this.kpkpWwwWorksTopicDao.updateRecycle(topicId, SystemContext.YN.YES.getValue());

				// 回收当前主题下的老照片
				this.kpkpWwwWorksPhotoDao.updateRecycle(topicId, SystemContext.YN.YES.getValue());

				// 减少用户照片数
				this.getKpkpWwwUserStatsBiz().updownPhotos(userId, DateTimeHelper.getDate(), topic.getPhotos());

				// 减少新用户组照数
				this.getKpkpWwwUserStatsBiz().updownTopics(userId, DateTimeHelper.getDate(), 1);
				return true;
			}

			return false;
		} catch (DaoException de) {
			log.error("recycle error", de);
			throw new BizException("recycle failure");
		} catch (Exception e) {
			log.error("recycle error", e);
			throw new BizException("recycle failure");
		} finally {
			topic = null;
			photos = null;
			photoCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#getUserFocusedTopic
	 * (java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserFocusedTopic(Integer userId, Integer curPage, Integer pageRows)
			throws BizException {
		Integer totalRows = null;
		KpkpWwwWorksTopicCond topicCond = null;
		KpkpWwwWorksTopicView topicView = null;
		List<KpkpWwwWorksTopic> topics = null;
		List<KpkpWwwWorksTopicView> topicViews = null;
		LsyWwwPaginView<KpkpWwwWorksTopicView> topicPagin = null;
		try {
			// 获取用户组照主题数
			topicCond = new KpkpWwwWorksTopicCond();
			topicCond.setFocusUserId(userId);
			topicCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			totalRows = this.kpkpWwwWorksTopicDao.countByCond(topicCond);

			// 如果组照存在
			if (null != totalRows && totalRows > 0) {

				// 构建分页对象
				topicPagin = new LsyWwwPaginView<KpkpWwwWorksTopicView>(curPage, pageRows, totalRows);

				// 获取分页查询结果
				topicCond.setProfileFlag(SystemContext.YN.YES.getValue());
				topicCond.setFirstResult(topicPagin.getFirstResult());
				topicCond.setMaxResults(topicPagin.getMaxResults());
				topicCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				topicCond.setOrderParam("kpkp_works_topic.addTime desc");
				topics = this.kpkpWwwWorksTopicDao.queryByCond(topicCond);

				// 如果结果存在
				if (null != topics && !topics.isEmpty()) {
					topicViews = new ArrayList<KpkpWwwWorksTopicView>(topics.size());

					// 迭代处理
					for (KpkpWwwWorksTopic topic : topics) {
						topicView = new KpkpWwwWorksTopicView();
						SpringBeanUtils.copyProperties(topic, topicView);
						topicView.setImg2(SystemConstant.HOST_FDFS + topic.getImg2());
						topicView.setImg3(SystemConstant.HOST_FDFS + topic.getImg3());
						topicView.setImg4(SystemConstant.HOST_FDFS + topic.getImg4());
						topicView.setAvatar(SystemConstant.HOST_FDFS + topic.getAvatar());
						topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));
						topicViews.add(topicView);
					}

					// 入页
					topicPagin.setCurPageList(topicViews);
				}
			}

			return topicPagin;
		} catch (DaoException de) {
			log.error("getUserFocusedTopics error", de);
			throw new BizException("getUserFocusedTopics failure");
		} catch (Exception e) {
			log.error("getUserFocusedTopics error", e);
			throw new BizException("getUserFocusedTopics failure");
		} finally {
			totalRows = null;
			topicCond = null;
			topicView = null;
			topics = null;
			topicViews = null;
			topicPagin = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#getUserNewsTopics(java
	 * .lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserNewestTopics(Integer userId, Integer curPage, Integer pageRows)
			throws BizException {
		Integer totalRows = null;
		KpkpWwwWorksTopicCond topicCond = null;
		KpkpWwwWorksTopicView topicView = null;
		List<KpkpWwwWorksTopic> topics = null;
		List<KpkpWwwWorksTopicView> topicViews = null;
		LsyWwwPaginView<KpkpWwwWorksTopicView> topicPagin = null;
		try {
			// 获取用户组照主题数
			totalRows = this.getKpkpWwwUserStatsBiz().getTopics(userId);

			// 如果组照存在
			if (null != totalRows && totalRows > 0) {
				// 获取分页查询结果
				topicPagin = new LsyWwwPaginView<KpkpWwwWorksTopicView>(curPage, pageRows, totalRows);
				topicCond = new KpkpWwwWorksTopicCond();
				topicCond.setUserId(userId);
				topicCond.setFirstResult(topicPagin.getFirstResult());
				topicCond.setMaxResults(topicPagin.getMaxResults());
				topicCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				topicCond.setProfileFlag(SystemContext.YN.YES.getValue());
				topicCond.setOrderParam("kpkp_works_topic.addTime desc");
				topics = this.kpkpWwwWorksTopicDao.queryByCond(topicCond);

				// 如果结果存在
				if (null != topics && !topics.isEmpty()) {
					topicViews = new ArrayList<KpkpWwwWorksTopicView>(topics.size());

					// 迭代处理
					for (KpkpWwwWorksTopic topic : topics) {
						topicView = new KpkpWwwWorksTopicView();
						SpringBeanUtils.copyProperties(topic, topicView);
						topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));
						topicView.setAddMonthDes(JodaTimeHelper.getMonth(topic.getAddTime()));
						topicView.setAddDayDes(JodaTimeHelper.getDay(topic.getAddTime()));
						topicView.setImg2(SystemConstant.HOST_FDFS + topic.getImg2());
						topicView.setImg3(SystemConstant.HOST_FDFS + topic.getImg3());
						topicView.setImg4(SystemConstant.HOST_FDFS + topic.getImg4());
						// 入列
						topicViews.add(topicView);
					}

					// 入页
					topicPagin.setCurPageList(topicViews);
				}
			}

			return topicPagin;
		} catch (DaoException de) {
			log.error("getUserNewestTopics error", de);
			throw new BizException("getUserNewestTopics failure");
		} catch (Exception e) {
			log.error("getUserNewestTopics error", e);
			throw new BizException("getUserNewestTopics failure");
		} finally {
			totalRows = null;
			topicCond = null;
			topicView = null;
			topics = null;
			topicViews = null;
			topicPagin = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.ctrl.action.works.LsyWwwWorksTopicBiz#getUserNewsTopics(java
	 * .lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getUserNewestTopics(String nickname, Integer curPage, Integer pageRows)
			throws BizException {
		KpkpWwwUserAccount user = null;
		try {
			user = this.kpkpWwwUserAccountDao.queryByNickname(nickname);

			// 如果用户存在
			if (null != user) {
				return this.getUserNewestTopics(user.getUserId(), curPage, pageRows);
			} else {
				return null;
			}
		} catch (DaoException de) {
			log.error("getUserNewestTopics error", de);
			throw new BizException("getUserNewestTopics failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.works.LsyWwwWorksTopicBiz#getTopTopics(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getTopTopics(Integer curPage, Integer pageRows) throws BizException {
		Integer totalRows = null;
		List<KpkpWwwWorksTopic> topics = null;
		KpkpWwwWorksTopicCond topicCond = null;
		KpkpWwwWorksTopicView topicView = null;
		List<KpkpWwwWorksTopicView> topicViews = null;
		LsyWwwPaginView<KpkpWwwWorksTopicView> topicPagin = null;
		try {
			// 获取用户组照主题数
			totalRows = this.getKpkpWwwUserStatsBiz().getTopics();

			// 如果组照存在
			if (null != totalRows && totalRows > 0) {
				// 获取分页查询结果
				topicPagin = new LsyWwwPaginView<KpkpWwwWorksTopicView>(curPage, pageRows, totalRows);
				topicCond = new KpkpWwwWorksTopicCond();
				topicCond.setFirstResult(topicPagin.getFirstResult());
				topicCond.setMaxResults(topicPagin.getMaxResults());
				topicCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				topicCond.setTopFlag(SystemContext.YN.YES.getValue());
				topicCond.setOrderParam("kpkp_works_topic.addTime desc");
				topics = this.kpkpWwwWorksTopicDao.queryByCond(topicCond);

				// 如果结果存在
				if (null != topics && !topics.isEmpty()) {
					topicViews = new ArrayList<KpkpWwwWorksTopicView>(topics.size());

					// 迭代处理
					for (KpkpWwwWorksTopic topic : topics) {
						topicView = new KpkpWwwWorksTopicView();
						SpringBeanUtils.copyProperties(topic, topicView);
						topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));
						topicView.setAddMonthDes(JodaTimeHelper.getMonth(topic.getAddTime()));
						topicView.setAddDayDes(JodaTimeHelper.getDay(topic.getAddTime()));
						topicView.setImg2(SystemConstant.HOST_FDFS + topic.getImg2());
						topicView.setImg3(SystemConstant.HOST_FDFS + topic.getImg3());
						topicView.setImg4(SystemConstant.HOST_FDFS + topic.getImg4());
						// 入列
						topicViews.add(topicView);
					}

					// 入页
					topicPagin.setCurPageList(topicViews);
				}
			}
			return topicPagin;
		} catch (DaoException de) {
			log.error("getTopTopics error", de);
			throw new BizException("getTopTopics failure");
		} catch (Exception e) {
			log.error("getTopTopics error", e);
			throw new BizException("getTopTopics failure");
		} finally {
			totalRows = null;
			topics = null;
			topicCond = null;
			topicView = null;
			topicViews = null;
			topicPagin = null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.works.LsyWwwWorksTopicBiz#getNewestTopics(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public LsyWwwPaginView<KpkpWwwWorksTopicView> getNewestTopics(Integer curPage, Integer pageRows)
			throws BizException {
		Integer totalRows = null;
		List<KpkpWwwWorksTopic> topics = null;
		KpkpWwwWorksTopicCond topicCond = null;
		KpkpWwwWorksTopicView topicView = null;
		List<KpkpWwwWorksTopicView> topicViews = null;
		LsyWwwPaginView<KpkpWwwWorksTopicView> topicPagin = null;
		try {
			// 获取用户组照主题数
			totalRows = this.getKpkpWwwUserStatsBiz().getTopics();

			// 如果组照存在
			if (null != totalRows && totalRows > 0) {
				// 获取分页查询结果
				topicPagin = new LsyWwwPaginView<KpkpWwwWorksTopicView>(curPage, pageRows, totalRows);
				topicCond = new KpkpWwwWorksTopicCond();
				topicCond.setFirstResult(topicPagin.getFirstResult());
				topicCond.setMaxResults(topicPagin.getMaxResults());
				topicCond.setRecycleFlag(SystemContext.YN.NO.getValue());
				topicCond.setOrderParam("kpkp_works_topic.addTime desc");
				topics = this.kpkpWwwWorksTopicDao.queryByCond(topicCond);

				// 如果结果存在
				if (null != topics && !topics.isEmpty()) {
					topicViews = new ArrayList<KpkpWwwWorksTopicView>(topics.size());

					// 迭代处理
					for (KpkpWwwWorksTopic topic : topics) {
						topicView = new KpkpWwwWorksTopicView();
						SpringBeanUtils.copyProperties(topic, topicView);
						topicView.setAddTimeDes(JodaTimeHelper.getBeforeNow(topic.getAddTime()));
						topicView.setAddMonthDes(JodaTimeHelper.getMonth(topic.getAddTime()));
						topicView.setAddDayDes(JodaTimeHelper.getDay(topic.getAddTime()));
						topicView.setImg2(SystemConstant.HOST_FDFS + topic.getImg2());
						topicView.setImg3(SystemConstant.HOST_FDFS + topic.getImg3());
						topicView.setImg4(SystemConstant.HOST_FDFS + topic.getImg4());
						// 入列
						topicViews.add(topicView);
					}

					// 入页
					topicPagin.setCurPageList(topicViews);
				}
			}
			return topicPagin;
		} catch (DaoException de) {
			log.error("getNewestTopics error", de);
			throw new BizException("getNewestTopics failure");
		} catch (Exception e) {
			log.error("getNewestTopics error", e);
			throw new BizException("getNewestTopics failure");
		} finally {
			totalRows = null;
			topics = null;
			topicCond = null;
			topicView = null;
			topicViews = null;
			topicPagin = null;

		}
	}

}
