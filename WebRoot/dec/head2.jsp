<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header class="navbar">
  	<a href="/" class="navbar-brand">快拍快拍网</a>
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
	        </ul>
	    </li>
	    <li><a href="/news/article/list.action">推荐</a></li>
	    <li><a href="http://app.kpkpw.com" target="_blank">APP</a></li>
	    <li><a href="http://old.kpkpw.com" target="_blank">旧版快拍快拍</a></li>
	</ul>
</header>
