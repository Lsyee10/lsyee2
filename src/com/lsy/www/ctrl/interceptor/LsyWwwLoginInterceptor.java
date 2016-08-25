package com.lsy.www.ctrl.interceptor;

import java.util.Map;

import com.kit.servlet.ContextHelper;
import com.kit.word.StringHelper;
import com.lsy.util.SystemConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Description:登录监听器
 *
 * @version 1.0 2016年4月28日
 * @author LSY
 */
public class LsyWwwLoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * 判断是否需要拦截
	 * 
	 * @param path
	 * @param uri
	 * @return
	 */
	private boolean ifIntercept(String path, String uri) {
		String[] paths = null;
		try {
			// 如果配置路径存在
			if (!StringHelper.ifNull(path)) {
				paths = path.split(",");
				// 迭代判断
				for (String pathStr : paths) {
					// 如果需要拦截
					if (uri.indexOf(pathStr) != -1) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			paths = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept
	 * (com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		String uri = ContextHelper.getUri();
		try {
			// 如果会话不存在且需要拦截登录
			if (null == session.get(SystemConstant.SESSION_USER)
					&& this.ifIntercept(SystemConstant.DEFAULT_LOGIN_INTERCEPT_PATH, uri)) {
				return SystemConstant.GLOBAL_ACTION_AUTH;
			}
			return invocation.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			return SystemConstant.GLOBAL_ACTION_ERROR;
		} finally {
			uri = null;
			ctx = null;
			session = null;
		}
	}
}
