/**
 * 
 */
package com.kit.servlet;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * Description:上下文
 *
 * @version 1.0 2016年4月28日
 * @author LSY
 */
public class ContextHelper {

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public static Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	/**
	 * 获取应用
	 * 
	 * @return
	 */
	public static Map<String, Object> getApplication() {
		return ActionContext.getContext().getApplication();
	}

	/**
	 * 获取IP地址
	 * 
	 * @return
	 */
	public static String getRemoteAddr() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	/**
	 * 获取真实IP地址（反向代理）
	 * 
	 * @param request
	 * @return
	 */
	public static String getProxyAddr() {
		String ip = ServletActionContext.getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = ServletActionContext.getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = ServletActionContext.getRequest().getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取URI地址
	 * 
	 * @return
	 */
	public static String getUri() {
		return ServletActionContext.getRequest().getRequestURI();
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	public static String getUrl() {
		return ServletActionContext.getRequest().getRequestURL().toString();
	}

	/**
	 * 获取URI地址后Querytring
	 * 
	 * @return
	 */
	public static String getRequestQuery() {
		return ServletActionContext.getRequest().getQueryString();
	}

	/**
	 * 获取会话id
	 * 
	 * @return
	 */
	public static String getSessionId() {
		return ServletActionContext.getRequest().getSession().getId();
	}

	/**
	 * 获取Cookies
	 * 
	 * @return
	 */
	public static Cookie[] getCookies() {
		return ServletActionContext.getRequest().getCookies();
	}

	/**
	 * 获取域名
	 * 
	 * @return
	 */
	public static String getServerName() {
		return ServletActionContext.getRequest().getServerName();
	}

	/**
	 * 获取物理路径
	 * 
	 * @param path
	 * @return
	 */
	public static String getRealPath(String path) {
		return ServletActionContext.getServletContext().getRealPath(path);
	}

	/**
	 * 获取Spring上下文句柄
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return (ApplicationContext) ServletActionContext.getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}

	/**
	 * 获取基于根目录的全路径
	 * 
	 * @return
	 */
	public static String getRequestPath() {
		if (null == getRequestQuery()) {
			return getUri();
		} else {
			return getUri() + "?" + getRequestQuery();
		}
	}

	/**
	 * 获取cookie中的值
	 * 
	 * @param str
	 * @return
	 */
	public static String getCookieValue(String str) {
		if (null != getCookies() && getCookies().length > 0) {
			for (Cookie cookie : getCookies()) {
				if (cookie.getName().equals(str)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * 获取指定cookie中的值
	 * 
	 * @param cookies
	 * @param str
	 * @return
	 */
	public static String getCookieValue(Cookie[] cookies, String str) {
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(str)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
