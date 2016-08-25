/**
 * 
 */
package com.lsy.www.biz.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itg.mail.MailItg;
import com.itg.mail.util.MailConstant;
import com.kit.encrypt.EncryptMD5;
import com.kit.exception.BizException;
import com.kit.exception.DaoException;
import com.kit.servlet.ContextHelper;
import com.kit.word.DateTimeHelper;
import com.kit.word.JodaTimeHelper;
import com.kit.word.StringHelper;
import com.lsy.util.SpringBeanUtils;
import com.lsy.util.SpringContextUtil;
import com.lsy.util.SystemConstant;
import com.lsy.util.SystemContext;
import com.lsy.www.biz.LsyWwwBaseBizImpl;
import com.lsy.www.dao.user.KpkpWwwUserAccountDao;
import com.lsy.www.dao.user.KpkpWwwUserAuthMailDao;
import com.lsy.www.dao.user.KpkpWwwUserAuthSmsDao;
import com.lsy.www.dao.user.KpkpWwwUserFocusDao;
import com.lsy.www.dao.user.KpkpWwwUserSetDao;
import com.lsy.www.dao.user.KpkpWwwUserStatsSumDao;
import com.lsy.www.dao.user.KpkpWwwUserSubscribeDao;
import com.lsy.www.dao.works.KpkpWwwWorksTagDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserAccountCond;
import com.lsy.www.entity.cond.user.KpkpWwwUserAuthMailCond;
import com.lsy.www.entity.model.user.KpkpWwwUserAccount;
import com.lsy.www.entity.model.user.KpkpWwwUserAuthMail;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsSum;
import com.lsy.www.entity.view.user.KpkpWwwUserProfileView;
import com.lsy.www.entity.view.user.KpkpWwwUserSessionView;

/**
 * Description:用户账号接口业务实现
 *
 * @version 1.0 2016年4月28日
 * @author LSY
 */
@Service("lsyWwwUserAccountBiz")
public class LsyWwwUserAccountBizImpl extends LsyWwwBaseBizImpl implements LsyWwwUserAccountBiz {

	@Resource(name = "kpkpWwwUserSetDao")
	private KpkpWwwUserSetDao KpkpWwwUserSetDao;

	@Resource(name = "kpkpWwwWorksTagDao")
	private KpkpWwwWorksTagDao kpkpWwwWorksTagDao;

	@Resource(name = "kpkpWwwUserFocusDao")
	private KpkpWwwUserFocusDao kpkpWwwUserFocusDao;

	@Resource(name = "kpkpWwwUserAccountDao")
	private KpkpWwwUserAccountDao kpkpWwwUserAccountDao;

	@Resource(name = "kpkpWwwUserAuthSmsDao")
	private KpkpWwwUserAuthSmsDao kpkpWwwUserAuthSmsDao;

	@Resource(name = "kpkpWwwUserAuthMailDao")
	private KpkpWwwUserAuthMailDao kpkpWwwUserAuthMailDao;

	@Resource(name = "kpkpWwwUserStatsSumDao")
	private KpkpWwwUserStatsSumDao kpkpWwwUserStatsSumDao;

	@Resource(name = "kpkpWwwUserSubscribeDao")
	private KpkpWwwUserSubscribeDao kpkpWwwUserSubscribeDao;

	private LsyWwwUserStatsBiz getLsyWwwUserStatsBiz() {
		return (LsyWwwUserStatsBiz) SpringContextUtil.getApplicationContext().getBean("lsyWwwUserStatsBiz");
	}

	private MailItg getMailItg() {
		return (MailItg) SpringContextUtil.getApplicationContext().getBean("mailItg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.user.LsyWwwUserAccountBiz#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Map<String, KpkpWwwUserSessionView> login(String username, String password) throws BizException {
		KpkpWwwUserAccount curAcct = null;
		KpkpWwwUserAccount updAcct = null;
		List<KpkpWwwUserAccount> accounts = null;
		KpkpWwwUserAccountCond accountCond = null;
		KpkpWwwUserSessionView sessionView = null;
		Map<String, KpkpWwwUserSessionView> rst = new HashMap<String, KpkpWwwUserSessionView>(1);
		try {
			// 构建账号查询
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setPassword(EncryptMD5.encrypt(password));
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);

			// 如果是手机
			if (StringHelper.ifMobile(username)) {
				accountCond.setCellphone(username);
			}
			// 如果是邮箱
			else if (StringHelper.ifMail(username)) {
				accountCond.setEmail(username);
			}
			// 如果是昵称
			else {
				accountCond.setNickname(username);
			}
			// 获取账号详情
			accounts = this.kpkpWwwUserAccountDao.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				curAcct = accounts.get(0);

				// 更新账号登录信息
				updAcct = new KpkpWwwUserAccount();
				updAcct.setUserId(curAcct.getUserId());
				updAcct.setLoginIp(ContextHelper.getProxyAddr());
				updAcct.setLoginTime(DateTimeHelper.getTimestamp());
				updAcct.setWebSessionId(ContextHelper.getSessionId());
				updAcct.setLoginFlag(SystemContext.USER_ACCOUNT_LOGIN.WEB.getValue());
				this.kpkpWwwUserAccountDao.update(updAcct);

				// 更新用户登录次数
				this.getLsyWwwUserStatsBiz().updownLogins(curAcct.getUserId(), DateTimeHelper.getDate(), 1);

				// 构建成功登录后的响应结果
				sessionView = new KpkpWwwUserSessionView();
				sessionView.setUserId(curAcct.getUserId());
				sessionView.setNickname(curAcct.getNickname());
				sessionView.setTypeFlag(curAcct.getTypeFlag());
				sessionView.setCellphone(curAcct.getCellphone());
				sessionView.setEmail(curAcct.getEmail());
				sessionView.setWebSessionId(curAcct.getWebSessionId());
				sessionView.setAvatar(curAcct.getAvatar());

				// 如果手机和邮箱都不存在
				if (StringHelper.ifNull(curAcct.getCellphone()) && StringHelper.ifNull(curAcct.getEmail())) {
					rst.put(LsyWwwUserAccountBiz.LOGIN_RST_BIND_CONTACT, sessionView);
				} else {
					rst.put(LsyWwwUserAccountBiz.LOGIN_RST_SUCCESS, sessionView);
				}
			}

			return rst;
		} catch (BizException e) {
			log.error("login err", e);
			throw new BizException("login falier");
		} catch (Exception ec) {
			log.error("login err", ec);
			throw new BizException("login falier");
		}
	}

	/**
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean logout(Integer userId) throws BizException {
		// TODO Auto-generated method stub
		KpkpWwwUserAccount account = null;
		try {
			// 获取用户
			account = this.kpkpWwwUserAccountDao.query(userId);

			// 如果用户存在且有效
			if (null != account && SystemContext.YN.YES.getValue().equals(account.getLoginFlag())) {

				// 注销更新
				account = new KpkpWwwUserAccount();
				account.setUserId(userId);
				account.setLoginFlag(SystemContext.YN.NO.getValue());
				this.kpkpWwwUserAccountDao.update(account);
				return true;
			} else {
				return false;
			}
		} catch (DaoException de) {
			log.error("logout error", de);
			throw new BizException("logout failure");
		} catch (Exception e) {
			log.error("logout error", e);
			throw new BizException("logout failure");
		} finally {
			account = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.user.LsyWwwUserAccountBiz#sendAuthCode(java.lang.Integer,
	 * java.lang.String, java.lang.Integer)
	 */
	@Override
	public String sendAuthCode(Integer userId, String accept, Integer useFlag) throws BizException {
		Integer limit = 5;
		String content = null;
		String authCode = null;
		KpkpWwwUserAuthMail mail = null;
		List<KpkpWwwUserAuthMail> mails = null;
		KpkpWwwUserAuthMailCond mailCond = null;
		try {
			// 如果是邮箱验证
			if (accept.indexOf("@") != -1) {

				// 如果是注册业务
				if (SystemContext.USER_AUTH_USE.REGISTER.getValue().equals(useFlag)) {

					// 如果邮箱被注册
					if (null != this.kpkpWwwUserAccountDao.queryByEmail(accept)) {
						return LsyWwwUserAccountBiz.SEND_AUTH_CODE_RST_REGISTERED;
					}
				}
			}

			// 获取当日邮件发送记录
			mailCond = new KpkpWwwUserAuthMailCond();
			mailCond.setEmail(accept);
			mailCond.setUseFlag(useFlag);
			mailCond.setSendTimeSt(JodaTimeHelper.getDate());
			mails = this.kpkpWwwUserAuthMailDao.queryByCond(mailCond);

			// 如果超过发送次数
			if (null != mails && mails.size() > limit) {
				return LsyWwwUserAccountBiz.SEND_AUTH_CODE_RST_FREQUENT;

			}
			// 如果允许发送
			else {
				// 获取验证码和发送内容
				authCode = StringHelper.getRandomNumByLength(6);
				content = SystemConstant.TMP_USER_AUTH_MAIL.replace("AUTH_CODE", authCode);

				// 发送邮件
				if (this.getMailItg().send(MailConstant.MAIL_SMTP_HOST, MailConstant.MAIL_SEND_USERNAME,
						MailConstant.MAIL_SEND_PASSWORD, true, MailConstant.MAIL_SEND_USERNAME, accept, "搭嗒嗒邮箱验证",
						content)) {

					// 记录邮件发送
					mail = new KpkpWwwUserAuthMail();
					mail.setEmail(accept);
					mail.setContent(content);
					mail.setAuthCode(authCode);
					mail.setUseFlag(useFlag);
					mail.setSendTime(DateTimeHelper.getTimestamp());
					mail.setCheckFlag(SystemContext.YN.NO.getValue());
					this.kpkpWwwUserAuthMailDao.insert(mail);
					return LsyWwwUserAccountBiz.SEND_AUTH_CODE_RST_SUCCESS;
				} else {
					return LsyWwwUserAccountBiz.SEND_AUTH_CODE_RST_FAILURE;
				}

			}
		} catch (DaoException de) {
			log.error("sendAuthCode error", de);
			throw new BizException("sendAuthCode failure");
		} catch (Exception e) {
			log.error("sendAuthCode error", e);
			throw new BizException("sendAuthCode failure");
		} finally {
			limit = null;
			content = null;
			authCode = null;
			mail = null;
			mails = null;
			mailCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.user.LsyWwwUserAccountBiz#checkAuthCode(java.lang.String,
	 * java.lang.String, java.lang.Integer)
	 */
	@Override
	public String checkAuthCode(String accept, String authCode, Integer useFlag) throws BizException {
		Integer limit = 5;
		KpkpWwwUserAuthMail mail = null;
		List<KpkpWwwUserAuthMail> mails = null;
		KpkpWwwUserAuthMailCond mailCond = null;
		try {
			// 如果是邮箱接收方式
			if (accept.indexOf("@") != -1) {

				// 获取邮件发送记录验证
				mailCond = new KpkpWwwUserAuthMailCond();
				mailCond.setEmail(accept);
				mailCond.setUseFlag(useFlag);
				mailCond.setFirstResult(0);
				mailCond.setMaxResults(1);
				mailCond.setCheckFlag(SystemContext.YN.NO.getValue());
				mails = this.kpkpWwwUserAuthMailDao.queryByCond(mailCond);

				// 如果记录存在
				if (null != mails && !mails.isEmpty()) {
					// 如果检查次数超过限制
					if (mails.get(0).getCheckTimes() > limit) {
						return LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_FREQUENT;
					}
					// 如果验证次数正常
					else {
						// 如果验证通过
						if (mails.get(0).getAuthCode().equals(authCode)) {
							// 更新验证次数
							mail = new KpkpWwwUserAuthMail();
							mail.setMailId(mails.get(0).getMailId());
							mail.setCheckFlag(SystemContext.YN.YES.getValue());
							mail.setCheckTimes(mails.get(0).getCheckTimes() + 1);
							this.kpkpWwwUserAuthMailDao.update(mail);
							return LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_SUCCESS;
						} else {
							// 更新验证次数
							mail = new KpkpWwwUserAuthMail();
							mail.setMailId(mails.get(0).getMailId());
							mail.setCheckTimes(mails.get(0).getCheckTimes() + 1);
							this.kpkpWwwUserAuthMailDao.update(mail);
							return LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_FAILURE;
						}
					}
				} else {
					return LsyWwwUserAccountBiz.CHECK_AUTH_CODE_RST_FAILURE;
				}

			}

		} catch (DaoException de) {
			log.error("checkAuthCode error", de);
			throw new BizException("checkAuthCode failure");
		} catch (Exception e) {
			log.error("checkAuthCode error", e);
			throw new BizException("checkAuthCode failure");
		} finally {
			limit = null;
			mail = null;
			mails = null;
			mailCond = null;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.user.LsyWwwUserAccountBiz#findPassword(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean findPassword(String accept, String password) throws BizException {
		KpkpWwwUserAccount account = null;
		KpkpWwwUserAccountCond accountCond = null;
		List<KpkpWwwUserAccount> accounts = null;
		try {
			// 构建用户账号查询条件
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());

			// 如果是邮箱
			if (StringHelper.ifMail(accept)) {
				accountCond.setEmail(accept);
			}
			// 如果是手机
			else {
				accountCond.setCellphone(accept);
			}

			// 获取用户账号
			accounts = this.kpkpWwwUserAccountDao.queryByCond(accountCond);

			// 如果账号存在且有效
			if (null != accounts && !accounts.isEmpty()) {

				// 更新密码
				account = new KpkpWwwUserAccount();
				account.setUserId(accounts.get(0).getUserId());
				account.setPassword(EncryptMD5.encrypt(password));
				this.kpkpWwwUserAccountDao.update(account);
				return true;
			} else {
				return false;
			}
		} catch (DaoException de) {
			log.error("findPassword error", de);
			throw new BizException("findPassword failure");
		} catch (Exception e) {
			log.error("findPassword error", e);
			throw new BizException("findPassword failure");
		} finally {
			account = null;
			accountCond = null;
			accounts = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.user.LsyWwwUserAccountBiz#modifyPassword(java.lang.Integer
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public boolean modifyPassword(Integer userId, String newPassword, String oldPassword) throws BizException {
		KpkpWwwUserAccount account = null;
		try {
			// 获取用户账号
			account = this.kpkpWwwUserAccountDao.query(userId);

			// 如果账号存在且有效
			if (null != account && SystemContext.YN.YES.getValue().equals(account.getStateFlag())
					&& SystemContext.YN.NO.getValue().equals(account.getRecycleFlag())
					&& account.getPassword().equals(EncryptMD5.encrypt(oldPassword))) {

				// 更新密码
				account = new KpkpWwwUserAccount();
				account.setUserId(userId);
				account.setPassword(EncryptMD5.encrypt(newPassword));
				this.kpkpWwwUserAccountDao.update(account);
				return true;
			} else {
				return false;
			}
		} catch (DaoException de) {
			log.error("modifyPassword error", de);
			throw new BizException("modifyPassword failure");
		} catch (Exception e) {
			log.error("modifyPassword error", e);
			throw new BizException("modifyPassword failure");
		} finally {
			account = null;
		}
	}

	@Override
	public boolean bindContact(Integer userId, String accept, String authCode) throws BizException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.biz.user.LsyWwwUserAccountBiz#validUsername(java.lang.String)
	 */
	@Override
	public boolean validUsername(String username) throws BizException {
		List<KpkpWwwUserAccount> accounts = null;
		KpkpWwwUserAccountCond accountCond = null;
		try {
			// 构建账号查询条件
			accountCond = new KpkpWwwUserAccountCond();
			accountCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			accountCond.setStateFlag(SystemContext.YN.YES.getValue());
			accountCond.setFirstResult(0);
			accountCond.setMaxResults(1);

			// 如果是手机
			if (StringHelper.ifMobile(username)) {
				accountCond.setCellphone(username);
			}
			// 如果是邮箱
			else if (StringHelper.ifMail(username)) {
				accountCond.setEmail(username);
			}
			// 如果是昵称
			else {
				accountCond.setNickname(username);
			}
			// 获取账号
			accounts = this.kpkpWwwUserAccountDao.queryByCond(accountCond);

			// 如果账号存在
			if (null != accounts && !accounts.isEmpty()) {
				return true;
			} else {
				return false;
			}
		} catch (DaoException de) {
			log.error("validUsername error", de);
			throw new BizException("validUsername failure");
		} catch (Exception e) {
			log.error("validUsername error", e);
			throw new BizException("validUsername failure");
		} finally {
			accounts = null;
			accountCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.user.LsyWwwUserAccountBiz#register(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public KpkpWwwUserSessionView register(String accept, String nickname, String passowrd) throws BizException {
		KpkpWwwUserAccount account = null;
		KpkpWwwUserSessionView sessionView = null;
		try {
			// 如果昵称已存在
			if (null != this.kpkpWwwUserAccountDao.queryByNickname(nickname)) {
				return null;
			} else {

				// 注册用户
				account = new KpkpWwwUserAccount();
				account.setNickname(nickname);
				account.setPassword(EncryptMD5.encrypt(passowrd));
				account.setAvatar(SystemConstant.DEFAULT_AVATAR);
				account.setAppBgImg(SystemConstant.DEFAULT_BG_IMG);
				account.setAppTokenId(StringHelper.getRandomNumByLength(6));
				account.setStateFlag(SystemContext.YN.YES.getValue());
				account.setLoginFlag(SystemContext.USER_ACCOUNT_LOGIN.APP.getValue());
				account.setTypeFlag(SystemContext.USER_ACCOUNT_TYPE.MEMBER.getValue());
				account.setRegTime(DateTimeHelper.getTimestamp());
				account.setLoginTime(DateTimeHelper.getTimestamp());
				account.setLoginIp(ContextHelper.getRemoteAddr());

				// 如果是邮箱
				if (accept.indexOf("@") != -1) {
					account.setEmail(accept);
				}
				// 如果是手机
				else {
					account.setCellphone(accept);
				}

				// 添加用户
				this.kpkpWwwUserAccountDao.insert(account);

				// 构建登录成功后的响应结果
				sessionView = new KpkpWwwUserSessionView();
				sessionView.setUserId(account.getUserId());
				sessionView.setAvatar(SystemConstant.HOST_FDFS + account.getAvatar());
				sessionView.setNickname(account.getNickname());
				sessionView.setTypeFlag(account.getTypeFlag());
				sessionView.setCellphone(account.getCellphone());
				sessionView.setEmail(account.getEmail());

				// 设置响应结果
				return sessionView;
			}
		} catch (DaoException de) {
			log.error("register error", de);
			throw new BizException("register failure");
		} catch (Exception e) {
			log.error("register error", e);
			throw new BizException("register failure");
		} finally {
			account = null;
			sessionView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.user.LsyWwwUserAccountBiz#profile(java.lang.Integer)
	 */
	@Override
	public KpkpWwwUserProfileView profile(Integer userId) throws BizException {
		KpkpWwwUserAccount account = null;
		KpkpWwwUserStatsSum statsSum = null;
		KpkpWwwUserProfileView profileView = null;
		try {
			// 获取账号
			account = this.kpkpWwwUserAccountDao.query(userId);

			// 如果账号存在
			if (null != account && SystemContext.YN.NO.getValue().equals(account.getRecycleFlag())
					&& SystemContext.YN.YES.getValue().equals(account.getStateFlag())) {
				profileView = new KpkpWwwUserProfileView();
				SpringBeanUtils.copyProperties(account, profileView);
				profileView.setFocusFlag(SystemContext.YN.NO.getValue());
				profileView.setAvatar(SystemConstant.HOST_FDFS + account.getAvatar());
				profileView.setBgImg(StringHelper.ifNull(account.getWebBgImg()) ? "" : SystemConstant.HOST_FDFS
						+ account.getWebBgImg());

				// 获取用户统计汇总
				statsSum = this.kpkpWwwUserStatsSumDao.query(userId);

				// 如果汇总存在
				if (null != statsSum) {
					profileView.setFans(statsSum.getFans() - 1);
					profileView.setFocus(statsSum.getFocus() - 1);
					profileView.setPhotos(statsSum.getPhotos());
				} else {
					profileView.setFans(0);
					profileView.setFocus(0);
					profileView.setPhotos(0);
				}
			}

			return profileView;
		} catch (DaoException de) {
			log.error("profile error", de);
			throw new BizException("profile failure");
		} catch (Exception e) {
			log.error("profile error", e);
			throw new BizException("profile failure");
		} finally {
			statsSum = null;
			account = null;
			profileView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.user.LsyWwwUserAccountBiz#profile(java.lang.String)
	 */
	public KpkpWwwUserProfileView profile(String nickname) throws BizException {
		// TODO Auto-generated method stub
		KpkpWwwUserAccount account = null;
		KpkpWwwUserProfileView profileView = null;
		try {
			// 获取账号
			account = this.kpkpWwwUserAccountDao.queryByNickname(nickname);

			// 如果账号存在
			if (null != account && SystemContext.YN.NO.getValue().equals(account.getRecycleFlag())
					&& SystemContext.YN.YES.getValue().equals(account.getStateFlag())) {
				profileView = new KpkpWwwUserProfileView();
				SpringBeanUtils.copyProperties(account, profileView);
				profileView.setAvatar(SystemConstant.HOST_FDFS + account.getAvatar());
				profileView.setBgImg(StringHelper.ifNull(account.getWebBgImg()) ? "" : SystemConstant.HOST_FDFS
						+ account.getWebBgImg());
			}

			return profileView;
		} catch (DaoException de) {
			log.error("profile error", de);
			throw new BizException("profile failure");
		} catch (Exception e) {
			log.error("profile error", e);
			throw new BizException("profile failure");
		} finally {
			account = null;
			profileView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserAccountBiz#profile(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public KpkpWwwUserProfileView profile(Integer userId, Integer shooterId) throws BizException {
		// TODO Auto-generated method stub
		KpkpWwwUserAccount account = null;
		KpkpWwwUserStatsSum statsSum = null;
		KpkpWwwUserProfileView profileView = null;
		try {
			// 获取账号
			account = this.kpkpWwwUserAccountDao.query(shooterId);

			// 如果账号存在
			if (null != account && SystemContext.YN.NO.getValue().equals(account.getRecycleFlag())
					&& SystemContext.YN.YES.getValue().equals(account.getStateFlag())) {
				profileView = new KpkpWwwUserProfileView();
				SpringBeanUtils.copyProperties(account, profileView);
				profileView.setAvatar(SystemConstant.HOST_FDFS + account.getAvatar());
				profileView.setBgImg(StringHelper.ifNull(account.getWebBgImg()) ? "" : SystemConstant.HOST_FDFS
						+ account.getWebBgImg());

				// 如果是本人
				if (userId.equals(shooterId)) {
					profileView.setFocusFlag(SystemContext.YN.YES.getValue());
				}
				// 如果已关注
				else if (null != this.kpkpWwwUserFocusDao.queryByCond(userId, shooterId)) {
					profileView.setFocusFlag(SystemContext.YN.YES.getValue());
				} else {
					profileView.setFocusFlag(SystemContext.YN.NO.getValue());
				}

				// 获取用户统计汇总
				statsSum = this.kpkpWwwUserStatsSumDao.query(shooterId);

				// 如果汇总存在
				if (null != statsSum) {
					profileView.setFans(statsSum.getFans() - 1);
					profileView.setFocus(statsSum.getFocus() - 1);
					profileView.setPhotos(statsSum.getPhotos());
				} else {
					profileView.setFans(0);
					profileView.setFocus(0);
					profileView.setPhotos(0);
				}
			}

			return profileView;
		} catch (DaoException de) {
			log.error("profile error", de);
			throw new BizException("profile failure");
		} catch (Exception e) {
			log.error("profile error", e);
			throw new BizException("profile failure");
		} finally {
			account = null;
			statsSum = null;
			profileView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserAccountBiz#profile(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public KpkpWwwUserProfileView profile(Integer userId, String nickname) throws BizException {
		// TODO Auto-generated method stub
		KpkpWwwUserAccount account = null;
		KpkpWwwUserStatsSum statsSum = null;
		KpkpWwwUserProfileView profileView = null;
		try {
			// 获取昵称
			nickname = StringHelper.getAtNickname(nickname);

			// 获取账号
			account = this.kpkpWwwUserAccountDao.queryByNickname(nickname);

			// 如果账号存在
			if (null != account && SystemContext.YN.NO.getValue().equals(account.getRecycleFlag())
					&& SystemContext.YN.YES.getValue().equals(account.getStateFlag())) {
				profileView = new KpkpWwwUserProfileView();
				SpringBeanUtils.copyProperties(account, profileView);
				profileView.setAvatar(SystemConstant.HOST_FDFS + account.getAvatar());
				profileView.setBgImg(StringHelper.ifNull(account.getWebBgImg()) ? "" : SystemConstant.HOST_FDFS
						+ account.getWebBgImg());

				// 如果是本人
				if (userId.equals(account.getUserId())) {
					profileView.setFocusFlag(SystemContext.YN.YES.getValue());
				}
				// 如果已关注
				else if (null != this.kpkpWwwUserFocusDao.queryByCond(userId, account.getUserId())) {
					profileView.setFocusFlag(SystemContext.YN.YES.getValue());
				} else {
					profileView.setFocusFlag(SystemContext.YN.NO.getValue());
				}

				// 获取用户统计汇总
				statsSum = this.kpkpWwwUserStatsSumDao.query(account.getUserId());

				// 如果汇总存在
				if (null != statsSum) {
					profileView.setFans(statsSum.getFans() - 1);
					profileView.setFocus(statsSum.getFocus() - 1);
					profileView.setPhotos(statsSum.getPhotos());
				} else {
					profileView.setFans(0);
					profileView.setFocus(0);
					profileView.setPhotos(0);
				}
			}

			return profileView;
		} catch (DaoException de) {
			log.error("profile error", de);
			throw new BizException("profile failure");
		} catch (Exception e) {
			log.error("profile error", e);
			throw new BizException("profile failure");
		} finally {
			account = null;
			statsSum = null;
			profileView = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserAccountBiz#modifyProfile(java.lang.Integer
	 * , java.io.File, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean modifyProfile(Integer userId, String nickname, String intro) throws BizException {
		// TODO Auto-generated method stub
		KpkpWwwUserAccount curAccount = null;
		KpkpWwwUserAccount updAccount = null;
		try {
			// 获取用户资料
			curAccount = this.kpkpWwwUserAccountDao.query(userId);

			// 如果用户账号存在
			if (null != curAccount) {

				// 构建更新对象
				updAccount = new KpkpWwwUserAccount();
				updAccount.setUserId(userId);

				// 如果昵称有变化
				if (!nickname.equals(curAccount.getNickname())) {

					// 如果新的昵称已存在
					if (null != this.kpkpWwwUserAccountDao.queryByNickname(nickname)) {
						return false;
					} else {
						updAccount.setNickname(nickname);
					}
				}

				// 如果需要修改资料
				if (!StringHelper.ifNull(intro)) {
					updAccount.setIntro(StringHelper.abbreviate(intro, 100, ""));
				}

				// 更新资料
				this.kpkpWwwUserAccountDao.update(updAccount);
				return true;
			}
			return false;
		} catch (DaoException de) {
			log.error("modifyProfile error", de);
			throw new BizException("modifyProfile failure");
		} catch (Exception e) {
			log.error("modifyProfile error", e);
			throw new BizException("modifyProfile failure");
		} finally {
			curAccount = null;
			updAccount = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserAccountBiz#modifyProfile(java.lang.Integer
	 * , java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean modifyProfile(Integer userId, String nickname, String intro, String city) throws BizException {
		KpkpWwwUserAccount curAccount = null;
		KpkpWwwUserAccount updAccount = null;
		try {
			// 获取用户资料
			curAccount = this.kpkpWwwUserAccountDao.query(userId);

			// 如果用户账号存在
			if (null != curAccount) {

				// 构建更新对象
				updAccount = new KpkpWwwUserAccount();
				updAccount.setUserId(userId);

				// 如果昵称有变化
				if (!nickname.equals(curAccount.getNickname()) && !StringHelper.ifNull(nickname)) {

					// 如果新的昵称已存在
					if (null != this.kpkpWwwUserAccountDao.queryByNickname(nickname)) {
						return false;
					} else {
						updAccount.setNickname(nickname);
					}
				}

				// 如果需要修改资料
				if (!StringHelper.ifNull(intro)) {
					updAccount.setIntro(StringHelper.abbreviate(intro, 100, ""));
				}

				// 如果需要修改城市
				if (!StringHelper.ifNull(city) && !curAccount.getCity().equals(city)) {
					updAccount.setCity(city);
				}

				// 更新资料
				this.kpkpWwwUserAccountDao.update(updAccount);
				return true;
			}
			return false;
		} catch (DaoException de) {
			log.error("modifyProfile error", de);
			throw new BizException("modifyProfile failure");
		} catch (Exception e) {
			log.error("modifyProfile error", e);
			throw new BizException("modifyProfile failure");
		} finally {
			curAccount = null;
			updAccount = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kpkp.www.biz.user.KpkpWwwUserAccountBiz#modifyAvatar(java.lang.Integer
	 * , java.lang.String, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer)
	 */
	public String modifyAvatar(Integer userId, String fileName, Integer cutX, Integer cutY, Integer cutW, Integer cutH)
			throws BizException {
		return null;
	}

}
