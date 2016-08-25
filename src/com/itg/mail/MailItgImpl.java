/**
 * 
 */
package com.itg.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import com.ibatis.common.logging.LogFactory;
import com.kit.logger.SystemLog;

/**
 * Description:邮件发送类
 *
 * @version 1.0 2016年5月9日
 * @author LSY
 */
@Component("mailItg")
public class MailItgImpl implements MailItg {

	// 系统日志
	protected final SystemLog log = (SystemLog) LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itg.mail.MailItg#send(java.lang.String, java.lang.String,
	 * java.lang.String, boolean, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String subject, String content) {
		Session session = null;// 邮件会话对象
		Properties props = null;// 系统属性
		BodyPart bodyPart = null;
		Multipart multiPart = null;// Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象
		MimeMessage mimeMsg = null;// MIME邮件对象
		Transport transport = null;
		try {
			// 获得系统属性对象
			props = System.getProperties();
			// 设置SMTP主机
			props.put("mail.smtp.host", stmp);

			// 如果需要主机认证
			if (auth) {
				props.put("mail.smtp.auth", "true");
			} else {
				props.put("mail.smtp.auth", "false");
			}

			// 获取邮件会话对象
			session = Session.getDefaultInstance(props, null);

			// 设置HTM内容
			bodyPart = new MimeBodyPart();
			multiPart = new MimeMultipart();
			// 设置邮件正文
			bodyPart.setContent(content, "text/html;charset=utf-8");
			multiPart.addBodyPart(bodyPart);

			// 创建MIME邮件对象
			mimeMsg = new MimeMessage(session);
			// 设置邮件主题
			mimeMsg.setSubject(subject);
			// 设置发信人
			mimeMsg.setFrom(new InternetAddress(from));
			// 设置收信人
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// 保存内容
			mimeMsg.setContent(multiPart);
			mimeMsg.saveChanges();

			// 发送邮件
			transport = session.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			transport.close();

			return true;
		} catch (Exception e) {
			log.error("send error", e);
			e.printStackTrace();
			return false;
		} finally {
			session = null;
			props = null;
			bodyPart = null;
			multiPart = null;
			mimeMsg = null;
			transport = null;
		}
	}

	/* (non-Javadoc)
	 * @see com.itg.mail.MailItg#send(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String copyto, String subject, String content) {
		// TODO Auto-generated method stub
		Session session = null;
		Properties props = null;
		BodyPart bodyPart = null;
		Multipart multipart = null;
		MimeMessage mimeMsg = null;
		Transport transport = null;
		try {
			// 设置基本属性
			props = System.getProperties();
			props.put("mail.smtp.host", stmp); // 设置SMTP主机

			// 如果需要身份认证
			if (auth) {
				props.put("mail.smtp.auth", "true");
			} else {
				props.put("mail.smtp.auth", "false");
			}

			// 建立会话
			session = Session.getDefaultInstance(props, null);

			// 设置HTML内容
			bodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			bodyPart.setContent(content, "text/html;charset=utf-8");
			multipart.addBodyPart(bodyPart);

			// 创建MIME邮件对象
			mimeMsg = new MimeMessage(session);
			mimeMsg.setSubject(subject);
			mimeMsg.setFrom(new InternetAddress(from));
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copyto));
			mimeMsg.setContent(multipart);// 保存内容
			mimeMsg.saveChanges();

			// 发送邮件
			transport = session.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			transport.close();

			return true;
		} catch (Exception e) {
			log.error("send error", e);
			return false;
		} finally {
			session = null;
			props = null;
			bodyPart = null;
			multipart = null;
			mimeMsg = null;
			transport = null;
		}
	}

	@Override
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String copyto, String subject, String content, String attach) {
		// TODO Auto-generated method stub
		Session session = null;
		Properties props = null;
		BodyPart bodyPart = null;
		Multipart multipart = null;
		MimeMessage mimeMsg = null;
		Transport transport = null;
		FileDataSource fileds = null;
		try {
			// 设置基本属性
			props = System.getProperties();
			props.put("mail.smtp.host", stmp); // 设置SMTP主机

			// 如果需要身份认证
			if (auth) {
				props.put("mail.smtp.auth", "true");
			} else {
				props.put("mail.smtp.auth", "false");
			}

			// 建立会话
			session = Session.getDefaultInstance(props, null);

			// 设置HTML内容
			bodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			bodyPart.setContent(content, "text/html;charset=utf-8");
			multipart.addBodyPart(bodyPart);

			// 添加附件
			bodyPart = new MimeBodyPart();
			fileds = new FileDataSource(attach);
			bodyPart.setDataHandler(new DataHandler(fileds));
			bodyPart.setFileName(fileds.getName());
			multipart.addBodyPart(bodyPart);

			// 创建MIME邮件对象
			mimeMsg = new MimeMessage(session);
			mimeMsg.setSubject(subject);
			mimeMsg.setFrom(new InternetAddress(from));
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copyto));
			mimeMsg.setContent(multipart);// 保存内容
			mimeMsg.saveChanges();

			// 发送邮件
			transport = session.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			transport.close();

			return true;
		} catch (Exception e) {
			log.error("send error", e);
			return false;
		} finally {
			session = null;
			props = null;
			bodyPart = null;
			multipart = null;
			mimeMsg = null;
			fileds = null;
			transport = null;
		}
	}

}
