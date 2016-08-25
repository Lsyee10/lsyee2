/**
 * 
 */
package com.lsy.www.biz.user;

import java.util.Map;

import com.kit.exception.BizException;
import com.lsy.www.entity.view.user.KpkpWwwUserProfileView;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;

/**
 * Description:用户账号业务接口
 *
 * @version 1.0 2016年4月28日
 * @author LSY
 */
public interface LsyWwwUserAccountBiz {

	// 登录结果定义
	public static final String LOGIN_RST_FAILURE = "kpkpWwwUserAccountBiz.login.failure";
	public static final String LOGIN_RST_SUCCESS = "kpkpWwwUserAccountBiz.login.success";
	public static final String LOGIN_RST_BIND_CONTACT = "kpkpWwwUserAccountBiz.login.bing.contact";

	// 发送验证码结果定义
	public static final String SEND_AUTH_CODE_RST_SUCCESS = "kpkpWwwUserAccountBiz.sendAuthCode.success";
	public static final String SEND_AUTH_CODE_RST_FAILURE = "kpkpWwwUserAccountBiz.sendAuthCode.failure";
	public static final String SEND_AUTH_CODE_RST_FREQUENT = "kpkpWwwUserAccountBiz.sendAuthCode.frequent";
	public static final String SEND_AUTH_CODE_RST_REGISTERED = "kpkpWwwUserAccountBiz.sendAuthCode.registered";

	// 验证码校验结果定义
	public static final String CHECK_AUTH_CODE_RST_SUCCESS = "kpkpWwwUserAccountBiz.checkAuthCode.success";
	public static final String CHECK_AUTH_CODE_RST_FAILURE = "kpkpWwwUserAccountBiz.checkAuthCode.failure";
	public static final String CHECK_AUTH_CODE_RST_FREQUENT = "kpkpWwwUserAccountBiz.checkAuthCode.frequent";
	public static final String CHECK_AUTH_CODE_RST_CODE_ERROR = "kpkpWwwUserAccountBiz.checkAuthCode.code.error";

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws BizException
	 */
	public Map<String, KpkpWwwUserSessionView> login(String username, String password) throws BizException;

	/**
	 * 用户注销
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public boolean logout(Integer userId) throws BizException;

	/**
	 * 发送验证码
	 * 
	 * @param userId
	 * @param accept
	 * @param useFlag
	 * @return
	 * @throws BizException
	 */
	public String sendAuthCode(Integer userId, String accept, Integer useFlag) throws BizException;

	/**
	 * 校验验证码
	 * 
	 * @param accept
	 * @param authCode
	 * @param useFlag
	 * @return
	 * @throws BizException
	 */
	public String checkAuthCode(String accept, String authCode, Integer useFlag) throws BizException;

	/**
	 * 找回密码
	 * 
	 * @param accept
	 * @param password
	 * @return
	 * @throws BizException
	 */
	public boolean findPassword(String accept, String password) throws BizException;

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws BizException
	 */
	public boolean modifyPassword(Integer userId, String newPassword, String oldPassword) throws BizException;

	/**
	 * 绑定联系方式，手机、邮箱
	 * 
	 * @param userId
	 * @param accept
	 * @param authCode
	 * @return
	 * @throws BizException
	 */
	public boolean bindContact(Integer userId, String accept, String authCode) throws BizException;

	/**
	 * 校验用户名
	 * 
	 * @param username
	 * @return
	 * @throws BizException
	 */
	public boolean validUsername(String username) throws BizException;

	/**
	 * 用户注册
	 * 
	 * @param accept
	 * @param nickname
	 * @param passowrd
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwUserSessionView register(String accept, String nickname, String passowrd) throws BizException;

	/**
	 * 用户资料
	 * 
	 * @param userId
	 * @return
	 */
	public KpkpWwwUserProfileView profile(Integer userId) throws BizException;

	/**
	 * 用户资料
	 * 
	 * @param nickname
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwUserProfileView profile(String nickname) throws BizException;

	/**
	 * 用户资料
	 * 
	 * @param userId
	 * @param shooterId
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwUserProfileView profile(Integer userId, Integer shooterId) throws BizException;

	/**
	 * 用户资料
	 * 
	 * @param userId
	 * @param nickname
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwUserProfileView profile(Integer userId, String nickname) throws BizException;

	/**
	 * 修改资料
	 * 
	 * @param userId
	 * @param nickname
	 * @param intro
	 * @return
	 * @throws BizException
	 */
	public boolean modifyProfile(Integer userId, String nickname, String intro) throws BizException;

	/**
	 * 修改资料
	 * 
	 * @param userId
	 * @param nickname
	 * @param intro
	 * @param city
	 * @return
	 * @throws BizException
	 */
	public boolean modifyProfile(Integer userId, String nickname, String intro, String city) throws BizException;

	/**
	 * 修改头像
	 * 
	 * @param userId
	 * @param filePath
	 * @param cutX
	 * @param cutY
	 * @param cutW
	 * @param cutH
	 * @return
	 * @throws BizException
	 */
	// public String modifyAvatar(Integer userId, String fileName, Integer cutX,
	// Integer cutY, Integer cutW, Integer cutH)
	// throws BizException;

	/**
	 * 修改个人空间背景
	 * 
	 * @param userId
	 * @param image
	 * @return
	 * @throws BizException
	 */
	// public String modifyBgImg(Integer userId, File image) throws
	// BizException;
}
