/**
 * Project : kpkp
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.lsy.util;

import com.kit.config.SystemConfig;

/**
 * Description:include system static value
 * 
 * @version 1.0 2013-6-21
 * @author Wu Guang Jing
 * 
 */
public class SystemConstant {

	// ACTION返回标志
	public final static String ACTION_RESULT_NONE = "none";
	public final static String ACTION_RESULT_LOGIN = "login";
	public final static String ACTION_RESULT_EXIST = "exist";
	public final static String ACTION_RESULT_INPUT = "input";
	public final static String ACTION_RESULT_ERROR = "error";
	public final static String ACTION_RESULT_AUTHEN = "authen";
	public final static String ACTION_RESULT_REGISTER = "register";
	public final static String ACTION_RESULT_SUCCESS = "success";
	public final static String ACTION_RESULT_FAILURE = "failure";

	// 全局ACTION
	public final static String GLOBAL_ACTION_AUTH = "auth";
	public final static String GLOBAL_ACTION_INIT = "init";
	public final static String GLOBAL_ACTION_ERROR = "error";
	public final static String GLOBAL_ACTION_LOGIN = "login";

	// 分页参数
	public final static String PAGIN_JUMP_FIRST = "first";
	public final static String PAGIN_JUMP_PREV = "prev";
	public final static String PAGIN_JUMP_NEXT = "next";
	public final static String PAGIN_JUMP_LAST = "last";
	public final static String PAGIN_JUMP_POINT = "point";
	public final static Integer PAGIN_INIT_CUR_PAGE = 1;
	public final static Integer PAGIN_INIT_PAGE_ROWS = 5;

	// 时间查询后缀
	public final static String QUERY_TIME_START = " 00:00:00";
	public final static String QUERY_TIME_END = " 23:59:59";
	
	// 请求可见范围
	public final static String REQUEST_SCOPE_ALL = "all";
	public final static String REQUEST_SCOPE_TODAY = "today";

	// 会话
	public final static String SESSION_ID = "SESSION_ID";
	public final static String SESSION_URL = "SESSION_URL";
	public final static String SESSION_USER = "SESSION_USER";
	public final static String SESSION_ADMIN = "SESSION_ADMIN";
	public final static String SESSION_PURVIEW = "SESSION_PURVIEW";
	public final static String SESSION_VALID_CODE = "SESSION_VALID_CODE";
	
	// 上传路径
	public final static String UPLOAD_PATH_NEWS = SystemConfig.getProperty("upload_path_news", "/sysConfig.properties");
	public final static String UPLOAD_PATH_USER = SystemConfig.getProperty("upload_path_user", "/sysConfig.properties");
	public final static String UPLOAD_PATH_WORKS = SystemConfig.getProperty("upload_path_works",
			"/sysConfig.properties");
	public final static String UPLOAD_PATH_ACTIVITY = SystemConfig.getProperty("upload_path_activity",
			"/sysConfig.properties");

	// 默认参数
	public final static String DEFAULT_AVATAR = SystemConfig.getProperty("default_avatar", "/sysConfig.properties");
	public final static String DEFAULT_BG_IMG = SystemConfig.getProperty("default_bg_img", "/sysConfig.properties");
	public final static String DEFAULT_KP_IMG = SystemConfig.getProperty("default_kp_img", "/sysConfig.properties");
	public final static Integer DEFAULT_USER_ID = Integer.valueOf(SystemConfig.getProperty("default_user_id",
			"/sysConfig.properties"));
	public final static String DEFAULT_LOGIN_INTERCEPT_PATH = SystemConfig.getProperty("default_intercept_login_path",
			"/sysConfig.properties");
	public final static Integer DEFAULT_NEWS_HIDDEN_COLUMN_ID = Integer.valueOf(SystemConfig.getProperty("default_news_hidden_column_id",
			"/sysConfig.properties"));

	// 主机相关
	public final static String HOST_APP = SystemConfig.getProperty("host_app", "/sysConfig.properties");
	public final static String HOST_WEB = SystemConfig.getProperty("host_web", "/sysConfig.properties");
	public final static String HOST_EEOP = SystemConfig.getProperty("host_eeop", "/sysConfig.properties");
	public final static String HOST_FDFS = SystemConfig.getProperty("host_fdfs", "/sysConfig.properties");
	public final static String HOST_WECHAT = SystemConfig.getProperty("host_wechat", "/sysConfig.properties");

	// 内容模板
	public final static String TMP_USER_AUTH_SMS = SystemConfig.getProperty("tmp_user_auth_sms",
			"/sysConfig.properties");
	public final static String TMP_USER_AUTH_MAIL = SystemConfig.getProperty("tmp_user_auth_mail",
			"/sysConfig.properties");
	public final static String TMP_USER_REG_WELCOME = SystemConfig.getProperty("tmp_user_reg_welcome",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_PRAISE = SystemConfig.getProperty("tmp_user_event_praise",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_COMMENT = SystemConfig.getProperty("tmp_user_event_comment",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_FOCUS = SystemConfig.getProperty("tmp_user_event_focus",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_CALL = SystemConfig.getProperty("tmp_user_event_call",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_CHOICE = SystemConfig.getProperty("tmp_user_event_choice",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_STAR = SystemConfig.getProperty("tmp_user_event_star",
			"/sysConfig.properties");
	public final static String TMP_USER_EVENT_AWARD = SystemConfig.getProperty("tmp_user_event_award",
			"/sysConfig.properties");
	public final static String TMP_USER_HIS_HREF = SystemConfig.getProperty("tmp_user_his_href",
			"/sysConfig.properties");
	public final static String TMP_WORKS_TAG_HREF = SystemConfig.getProperty("tmp_works_tag_href",
			"/sysConfig.properties");
	public final static String TMP_NEWS_TAG_HREF = SystemConfig.getProperty("tmp_news_tag_href",
			"/sysConfig.properties");

	// 极光推送配置
	public final static String JPUSH_APP_KEY = SystemConfig.getProperty("jpush_app_key", "/sysConfig.properties");
	public final static String JPUSH_MASTER_SECRET = SystemConfig.getProperty("jpush_master_secret",
			"/sysConfig.properties");
	
	// 首页静态化相关
	public final static String STATICIZE_HOME_LINK_FILE_NAME = SystemConfig.getProperty("staticize_home_link_file_name",
			"/sysConfig.properties");
	public final static String STATICIZE_HOME_CHOICE_FILE_NAME = SystemConfig.getProperty("staticize_home_chocie_file_name",
			"/sysConfig.properties");
	public final static String STATICIZE_HOME_LINK_FTL_NAME = SystemConfig.getProperty("staticize_home_link_ftl_name",
			"/sysConfig.properties");
	public final static String STATICIZE_HOME_CHOICE_FTL_NAME = SystemConfig.getProperty("staticize_home_choice_ftl_name",
			"/sysConfig.properties");
}
