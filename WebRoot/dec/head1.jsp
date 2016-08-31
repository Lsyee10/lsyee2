<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header class="navbar">
    <a href="/index.html" class="navbar-brand">快拍快拍网</a>
    <button class="btn btn-primary navbar-toggle"><i class="icon-menu"></i></button>
	<ul class="nav navbar-nav">
	    <li><a href="/">首页</a></li>
	    <li class="dropdown"><a href="javascript:void(0)">发现</a>
	        <ul>
	            <li><a href="/works/topic/choice.action">编辑精选</a></li>
	            <li><a href="/works/topic/newest.action">最新上传</a></li>
	        </ul>
	    </li>
	    <li><a href="/news/article/list.action">推荐</a></li>
	</ul>
	<div class="right">
	    <a href="/works/topic/prepCreate.action" class="btn btn-primary btn-upload"><i class="icon-camera"></i>上传作品</a>
	    <s:if test="null!=#session.SESSION_USER">
	    	<div class="avatar dropdown">
		        <a href="/user/my/home.action"><img src="${sessionScope.SESSION_USER.avatar}">${sessionScope.SESSION_USER.nickname}<i></i></a>
		        <ul class="menu">
		            <li><a href="/user/my/home.action" target="_blank">个人中心</a></li>
		            <li><a href="/user/my/works/topic.action?mode=grid" target="_blank">我的作品</a></li>
		            <li><a href="/user/my/setting/profile.action" target="_blank">个人设置</a></li>
		            <li><a href="/user/io/login/exit.action">退出</a></li>
		        </ul>
		    </div>
	    	<s:action name="stats" executeResult="true" namespace="/user/my/msg"></s:action>
	    </s:if>
		<s:else>
    	<a href="/user/io/login/prep.action?url=<%=request.getRequestURI()+(null==request.getQueryString()?"":"?"+request.getQueryString().replace("&", "$"))%>" class="btn btn-sm link-primary">登录</a>
		<a href="/user/io/register/prep.action" class="btn btn-sm link-muted">注册</a>
		</s:else>
	</div>
</header>