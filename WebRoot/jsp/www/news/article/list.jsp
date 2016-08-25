<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<title><s:property value="#request.title" /> - 推荐  - 快拍快拍</title>
	<script src="http://dup.baidustatic.com/js/ds.js"></script>
	<link href="/css/www/common.css?r=<%=new Random().nextInt()%>" rel="stylesheet">
</head>
<body>
	<section class="container">
		<header class="title">
			<h2>
				<s:property value="#request.title" />
			</h2>
			<p>
				共有
				<s:if test="null != #request.articlePagin && #request.articlePagin.totalRows > 0">
					<s:property value="#request.articlePagin.totalRows" />
				</s:if>
				<s:else>0</s:else>
				篇
			</p>
		</header>
		<div class="main-aside-wrapper">
			<!-- 左侧开始 -->
			<div class="main">
				<!-- 列表开始 -->
				<s:if test="null != #request.articlePagin && #request.articlePagin.totalRows > 0">
					<ul class="thumbnails-list">
						<s:iterator value="#request.articlePagin.curPageList" status="st">
							<li><a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>" target="_blank" class="img"> <img src="/img/www/grey.png" data-original="<s:property value="cover2"/>">
							</a>
								<div class="caption">
									<h3>
										<a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>" target="_blank"><s:property value="title" /></a>
									</h3>
									<p class="text-gray">
										<s:property value="summary" escape="false" />
									</p>
								</div>
								<div class="ft">
									<div class="left">
										<span class="m-r-1"><i class="icon-time"></i> <s:property value="pubDateDes" /></span> 
										<a href="/news/article/list.action?columnId=<s:property value = "columnId"/>"> <i class="icon-file"></i> <s:property value="columnName" />
										</a>
									</div>
									<span class="btn-group"> 
										<a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>#pub_comment" title="评论"><i class="icon-speech"></i><s:property value="comments"/></a>
                               			<!-- <a href="javascript:void(0)"><i class="icon-share-to"></i>&nbsp;</a> -->
									</span>
								</div></li>
						</s:iterator>
					</ul>
				</s:if>
				<!-- 列表结束 -->
				<!-- 分页开始 -->
				<nav>
					<s:set value="#request.articlePagin.curPage" name="curPage" />
					<s:set value="#request.articlePagin.totalPages" name="totalPages" />
					<s:include value="/jsp/www/pagin.jsp">
						<s:param name="pageLink">list.action?d=123<s:if test="#request.columnId>0">&columnId=<s:property value="#request.columnId"/></s:if>
						<s:if test="#request.tag != null && #request.tag != '' ">&tag=<s:property value="#request.tag"/></s:if></s:param>
						<s:param name="anchor"></s:param>
						<s:param name="curPage">
							<s:property value='#curPage' />
						</s:param>
						<s:param name="totalPages">
							<s:property value='#totalPages' />
						</s:param>
					</s:include>
				</nav>
				<!-- 分页结束 -->
			</div>
			<!-- 左侧结束，右侧开始 -->
			<aside class="aside">
				<!-- 导航开始 -->
				<nav class="article-nav">
					<s:if test="null != #request.columnList && #request.columnList.size > 0">
						<s:iterator value="#request.columnList" status="st">
							<a href="/news/article/list.action<s:if test="null != columnId">?columnId=<s:property value="columnId"/></s:if>" 
								<s:if test="#request.title == #request.name"> class="active"</s:if>> <s:property value="name" />（<s:property value="articles" />）
							</a>
						</s:iterator>
					</s:if>
				</nav>
				<!-- 导航结束，资讯开始 -->
				<div class="aside-list">
					<div class="title-line">猜你喜欢</div>
					<s:if test="null != #request.topArticleList && #request.topArticleList.size > 0">
						<ul class="list">
							<s:iterator value="#request.topArticleList" status="st">
								<li><a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>" target="_blank"><s:property value="title" /></a></li>
							</s:iterator>
						</ul>
					</s:if>
				</div>
				<!-- 资讯结束，广告开始 -->
				<div class="ad-list">
					<!-- 广告位：kp_推荐页右侧广告位1 -->
					<script>
						(function() {
						    var s = "_" + Math.random().toString(36).slice(2);
						    document.write('<div id="' + s + '"></div>');
						    (window.slotbydup=window.slotbydup || []).push({
						        id: '2471238',
						        container: s,
						        size: '310,270',
						        display: 'inlay-fix'
						    });
						})();
					</script>
				</div>
				<!-- 广告结束 -->
			</aside>
		</div>
		<!-- 右侧结束 -->
	</section>
</body>
</html>