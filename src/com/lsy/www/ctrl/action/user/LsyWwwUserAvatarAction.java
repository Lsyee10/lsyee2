/**
 * Project : lsy
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

import com.lsy.www.entity.form.user.KpkpWwwUserAvatarForm;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;
import net.sf.json.JSONObject;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.kit.media.image.ImageAttr;
import com.kit.media.image.ImageHelper;
import com.kit.servlet.ContextHelper;
import com.kit.word.JodaTimeHelper;
import com.kit.word.StringHelper;
import com.lsy.util.SpringBeanUtils;
import com.lsy.util.SystemConstant;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description:
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
@Controller("lsyWwwUserAvatarAction")
@Scope("prototype")
public class LsyWwwUserAvatarAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwUserAvatarForm> {
	private static final long serialVersionUID = 1L;

	private KpkpWwwUserAvatarForm model = new KpkpWwwUserAvatarForm();

	public KpkpWwwUserAvatarForm getModel() {
		return model;
	}

	@Resource(name = "lsyWwwUserAccountBiz")
	private LsyWwwUserAccountBiz lsyWwwUserAccountBiz;

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * 上传头像
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String upload() throws ActionException {
		String name = null;
		String cusDir = null;
		ImageAttr imageAttr = null;
		try {
			cusDir = JodaTimeHelper.getYear();
			name = UUID.randomUUID().toString();

			// 生成照片
			imageAttr = ImageHelper.getInstance().create(this.model.getImage(),
					ContextHelper.getRealPath(SystemConstant.UPLOAD_PATH_USER), SystemConstant.UPLOAD_PATH_USER,
					cusDir, name, ".jpg", 420);

			if (null != imageAttr) {

			}

			// 设置JSON返回结果
			this.inputStream = new ByteArrayInputStream(JSONObject.fromObject(imageAttr).toString().getBytes("UTF-8"));
			return SUCCESS;
		} catch (Exception e) {
			log.error("upload error", e);
			throw new ActionException(this.getText("action.ctl.error"));
		} finally {
			name = null;
			cusDir = null;
			imageAttr = null;
		}
	}

	/**
	 * 裁切保存头像
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String cutting() throws ActionException {
		KpkpWwwUserSessionView sessView = null;
		try {
			// 裁切并保存头像
			this.actionDealMsg = this.lsyWwwUserAccountBiz.modifyAvatar(this.getUserSession().getUserId(),
					this.model.getImageFileName(), this.model.getX(), this.model.getY(), this.model.getW(),
					this.model.getH());

			// 如果保存成功
			if (!StringHelper.ifNull(this.actionDealMsg)) {
				// 修改会话视图中的头像,采用Redis会话共享写法
				sessView = new KpkpWwwUserSessionView();
				SpringBeanUtils.copyProperties(this.getUserSession(), sessView);
				sessView.setAvatar(this.actionDealMsg);
				this.getSession().remove(SystemConstant.SESSION_USER);
				this.getSession().put(SystemConstant.SESSION_USER, sessView);
			}
			return SUCCESS;
		} catch (BizException be) {
			log.error("cutting error", be);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("cutting error", e);
			throw new ActionException(this.getText("action.ctl.error"));
		} finally {
			sessView = null;
		}
	}
}
