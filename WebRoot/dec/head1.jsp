<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header class="navbar">
    <a href="/index.html" class="navbar-brand">快拍快拍网</a>
    <button class="btn btn-primary navbar-toggle"><i class="icon-menu"></i></button>
	<ul class="nav navbar-nav">
	    <li><a href="/">首页</a></li>
	    <li class="dropdown"><a href="javascript:void(0)">任务和小站</a>
	        <ul>
	            <li><a href="/activity/task/list.action">任务</a></li>
	            <li><a href="/activity/station/list.action">小站</a></li>
	        </ul>
	    </li>
	    <li class="dropdown"><a href="javascript:void(0)">发现</a>
	        <ul>
	            <li><a href="/works/photo/choice.action">编辑精选</a></li>
	            <li><a href="/works/photo/newest.action">最新上传</a></li>
	            <li><a href="/works/tag/recom.action">推荐标签</a></li>
	            <li><a href="/works/shooter/recom.action">摄影师</a></li>
	            <li><a href="/works/photo/star.action">每日之星</a></li>
	            <li><a href="/activity/travel/list.action">一次旅行</a></li>
	        </ul>
	    </li>
	    <li><a href="/news/article/list.action">推荐</a></li>
	    <li><a href="http://app.kpkpw.com" target="_blank">APP</a></li>
	    <li><a href="http://old.kpkpw.com" target="_blank">旧版快拍快拍</a></li>
	</ul>
	<div class="right">
	    <div class="search-form">
	    	<form method="get" action="/sys/search/works.action">
		        <input type="text" name="keyword" class="search-key" placeholder="作品/小友/活动">
		        <button class="btn-search" type="submit">搜索</button>
	            <div class="search-type">
	                <a href="">搜"<span></span>"相关的作品</a>
	                <a href="">搜"<span></span>"相关的小友</a>
	                <a href="">搜"<span></span>"相关的活动</a>
	            </div>
	        </form>
	    </div>
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