/**
 * Project : kpkp
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.lsy.util;

/**
 * Description:incldue system enum value
 * 
 * @version 1.0 2013-6-21
 * @author Wu Guang Jing
 * 
 */
public class SystemContext {

	/**
	 * Description:是否标示
	 * 
	 * @version 1.0 2013-7-6
	 * @author Wu Guang Jing
	 * 
	 */
	public enum YN {
		NO(0, "否"), YES(1, "是");
		private Integer value;
		private String label;

		YN(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static YN parse(Integer value) {
			for (YN type : YN.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:账号类型
	 * 
	 * @version 1.0 2014年7月11日
	 * @author Wu guang jing
	 * 
	 */
	public enum USER_ACCOUNT_TYPE {
		MEMBER(1, "会员"), JURY(2, "评委"), ADMIN(3, "管理员"), MODERATOR(4, "版主");
		private Integer value;
		private String label;

		USER_ACCOUNT_TYPE(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static USER_ACCOUNT_TYPE parse(Integer value) {
			for (USER_ACCOUNT_TYPE type : USER_ACCOUNT_TYPE.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:用户登录方式
	 * 
	 * @version 1.0 2015年9月17日
	 * @author Wu guang jing
	 * 
	 */
	public enum USER_ACCOUNT_LOGIN {
		OFF(0, "离线"), APP(1, "应用"), WEB(2, "网站"), EEOF(3, "运营"), WECHAT(3, "微信");
		private Integer value;
		private String label;

		USER_ACCOUNT_LOGIN(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static USER_ACCOUNT_LOGIN parse(Integer value) {
			for (USER_ACCOUNT_LOGIN type : USER_ACCOUNT_LOGIN.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:账号类型
	 * 
	 * @version 1.0 2014年7月11日
	 * @author Wu guang jing
	 * 
	 */
	public enum USER_AUTH_USE {
		REGISTER(1, "注册"), FIND_PASSWORD(2, "找回密码"), ACCEPT_BING(3, "设置绑定");
		private Integer value;
		private String label;

		USER_AUTH_USE(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static USER_AUTH_USE parse(Integer value) {
			for (USER_AUTH_USE type : USER_AUTH_USE.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:用户事件业务
	 * 
	 * @version 1.0 2014年7月11日
	 * @author Wu guang jing
	 * 
	 */
	public enum USER_EVENT_BIZ {
		PHOTO_PRAISE(1, "照片点赞"), PHOTO_COMMENT(2, "照片评论"), FOCUS_YOU(3, "有人关注你"), CALL_YOU(4, "有人@你"), PHOTO_CHOICE(5,
				"照片精选"), PHOTO_AWARD(6, "照片获奖"), PHOTO_STAR(7, "快拍之星");
		private Integer value;
		private String label;

		USER_EVENT_BIZ(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static USER_EVENT_BIZ parse(Integer value) {
			for (USER_EVENT_BIZ type : USER_EVENT_BIZ.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * 
	 * Description:用户设置
	 * 
	 * @version 1.0 2015年9月15日
	 * @author Li Shi Yuan
	 * 
	 */
	public enum USER_SET_TYPE {
		IOS(1, "苹果设置"), ANDROID(2, "安卓设置"), WEB(3, "网站设置"), WECHAT(3, "微信设置");
		private Integer value;
		private String label;

		USER_SET_TYPE(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static USER_SET_TYPE parse(Integer value) {
			for (USER_SET_TYPE type : USER_SET_TYPE.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:活动状态
	 * 
	 * @version 1.0 2014年7月11日
	 * @author Wu guang jing
	 * 
	 */
	public enum ACTIVITY_STATE {
		WAIT(1, "未开始"), ING(2, "进行中"), END(3, "已结束");
		private Integer value;
		private String label;

		ACTIVITY_STATE(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static ACTIVITY_STATE parse(Integer value) {
			for (ACTIVITY_STATE type : ACTIVITY_STATE.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:活动业务
	 * 
	 * @version 1.0 2015年2月28日
	 * @author Wu guang jing
	 * 
	 */
	public enum ACTIVITY_BIZ {
		TASK(1, "任务"), STATION(2, "小站"), TRAVEL(3, "旅行"), APPLY(4, "报名");
		private Integer value;
		private String label;

		ACTIVITY_BIZ(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static ACTIVITY_BIZ parse(Integer value) {
			for (ACTIVITY_BIZ type : ACTIVITY_BIZ.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:资讯栏目
	 * 
	 * @version 1.0 2015年12月14日
	 * @author Wu guang jing
	 */
	public enum NEWS_COLUMN {
		YCLX(153, "一次旅行"), KPFT(242, "快拍访谈"), MTKSJZHZP(243, "每天看世界最好的照片"), KPSYS(244, "快拍摄影师"), YYP(245, "月月评"), QSD(
				246, "抢书读");
		private Integer value;
		private String label;

		NEWS_COLUMN(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static NEWS_COLUMN parse(Integer value) {
			for (NEWS_COLUMN type : NEWS_COLUMN.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:推送业务
	 * 
	 * @version 1.0 2015年9月8日
	 * @author Wu guang jing
	 * 
	 */
	public enum PUSH_DISCOVER_BIZ {
		STAR(1, "快拍之星"), SHOOTER(2, "我是今天的轮值主编"), NEARBY(3, "附近的照片"), CITY(4, "所在城市照片"), CHOICE(5, "精选照片"), TOP_TAG(6,
				"推荐标签"), ACTIVITY(7, "推荐活动"), NEWEST(8, "最新上传");
		private Integer value;
		private String label;

		PUSH_DISCOVER_BIZ(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static PUSH_DISCOVER_BIZ parse(Integer value) {
			for (PUSH_DISCOVER_BIZ type : PUSH_DISCOVER_BIZ.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:推送链接页面
	 * 
	 * @version 1.0 2015年12月11日
	 * @author Wu guang jing
	 */
	public enum PUSH_LINK_PAGE {
		HOME(1, "首页"), ACTIVITY(2, "奖励"), DISCOVERY(3, "发现"), NEWS(4, "推荐");
		private Integer value;
		private String label;

		PUSH_LINK_PAGE(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static PUSH_LINK_PAGE parse(Integer value) {
			for (PUSH_LINK_PAGE type : PUSH_LINK_PAGE.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:推送链接位置
	 * 
	 * @version 1.0 2015年12月11日
	 * @author Wu guang jing
	 */
	public enum PUSH_LINK_POS {
		P_1_1(1, "p_1_1", "首屏大标题", 1, 1), P_1_2(2, "p_1_2", "首屏焦点图", 1, 6), P_1_3(3, "p_1_3", "首屏重点小图", 1, 3), P_1_4(4,
				"p_1_4", "首屏每日重点", 1, 7), P_1_5(5, "p_1_5", "任务小站轮播图", 1, 5), P_1_6(6, "p_1_6", "任务小站推荐标签", 1, 20), P_1_7(
				7, "p_1_7", "任务小站小图", 1, 2), P_1_8(8, "p_1_8", "发现上部大图", 1, 2), P_1_9(9, "p_1_9", "发现快拍访谈图文", 1, 1), P_1_10(
				10, "p_1_10", "发现快拍访谈列表", 1, 4), P_1_11(11, "p_1_11", "发现抢书读图文", 1, 1), P_1_12(12, "p_1_12", "发现抢书读列表",
				1, 4), P_1_13(13, "p_1_13", "发现下部大图", 1, 2), P_1_14(14, "p_1_14", "发现推荐文章列表", 1, 10), P_1_15(15,
				"p_1_15", "一次旅行推荐图文", 1, 4);
		private Integer value;
		private String handle;
		private String label;
		private Integer page;
		private Integer size;

		PUSH_LINK_POS(Integer value, String handle, String label, Integer page, Integer size) {
			this.value = value;
			this.handle = handle;
			this.label = label;
			this.page = page;
			this.size = size;
		}

		public Integer getValue() {
			return value;
		}

		public String getHandle() {
			return handle;
		}

		public String getLabel() {
			return label;
		}

		public Integer getPage() {
			return page;
		}

		public Integer getSize() {
			return size;
		}

		public static PUSH_LINK_POS parse(Integer value) {
			for (PUSH_LINK_POS type : PUSH_LINK_POS.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:照片编辑
	 * 
	 * @version 1.0 2015年9月16日
	 * @author Wu guang jing
	 * 
	 */
	public enum WORKS_PHOTO_EDIT {
		CHOICE(1, "精选"), AWARD(2, "评奖"), STAR(3, "每日之星");
		private Integer value;
		private String label;

		WORKS_PHOTO_EDIT(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static WORKS_PHOTO_EDIT parse(Integer value) {
			for (WORKS_PHOTO_EDIT type : WORKS_PHOTO_EDIT.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * Description:作品操作
	 * 
	 * @version 1.0 2015年9月21日
	 * @author Wu guang jing
	 * 
	 */
	public enum WORKS_OPTION {
		MAKE_CHOICE(1, "精选"), CANCEL_CHOICE(2, "取消精选"), MAKE_AWARD(3, "评奖"), CANCEL_AWARD(4, "取消评奖"), MAKE_STAR(5,
				"每日之星"), CANCEL_STAR(6, "取消每日之星"), TASK_BACK(7, "任务退稿"), STATION_BACK(8, "小站退稿"), RECYCLE(9, "删除");
		private Integer value;
		private String label;

		WORKS_OPTION(Integer value, String label) {
			this.value = value;
			this.label = label;
		}

		public Integer getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		public static WORKS_OPTION parse(Integer value) {
			for (WORKS_OPTION type : WORKS_OPTION.values()) {
				if (type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	}
}
