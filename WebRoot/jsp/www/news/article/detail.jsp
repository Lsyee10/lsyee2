<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="zh-CN">
<head>
<title><s:property value="#request.articleView.title" /> - <s:property value="#request.articleView.columnName" /> - 快拍快拍</title>
<script src="http://dup.baidustatic.com/js/ds.js"></script>
<script src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=923e02c7-ae35-4b80-8a9a-620d34e001b9&amp;pophcol=2&amp;lang=zh" type="text/javascript"></script>
<script src="http://static.bshare.cn/b/bshareC0.js" type="text/javascript"></script>
<script src="/js/com/www/news/comment.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
<link href="/css/www/common.css?r=<%=new Random().nextInt()%>" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		comment.prepPub();
	});
</script>
</head>
<body>
	<!-- 顶部结束 -->
	<div class="container main-aside-wrapper">
		<!-- 左侧开始 -->
		<article class="main content-main">
			<!-- 正文开始 -->
			<header class="jumbotron">
				<h1>
					<s:property value="#request.articleView.title" />
				</h1>
				<div>
					<time datetime="<s:property value='#request.articleView.pubDateDes'/>">
						发布时间：<s:property value="#request.articleView.pubDateDes" />
					</time>
					/ <span>
						分类：<a href="/news/article/list.action?columnId=<s:property value='#request.articleView.columnId'/>">
								<s:property value="#request.articleView.columnName" /></a>
					  </span>
					/ <span>阅读数：<s:property value="#request.articleView.views" /></span>
				</div>
			</header>
			<section class="jumbotron content">
				<s:property value="#request.articleView.content" escape="false"/>
			</section>
			<footer class="jumbotron">
				<s:if test="null != #request.articleView.tag && '' != #request.articleView.tag">
					<div class="label-group">
						标签： <s:property value="#request.articleView.tag" escape="false"/>
					</div>
				</s:if>
				<div class="bshare-custom icon-medium text-right">
					分享到：
					<div class="bsPromo bsPromo2"></div>
					<a title="分享到QQ空间" class="bshare-qzone"></a> 
					<a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
					<a title="分享到微信" class="bshare-weixin" href="javascript:void(0);"></a>
					<a title="分享到人人网" class="bshare-renren"></a> 
					<a title="分享到豆瓣" class="bshare-douban" href="javascript:void(0);"></a> 
					<a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a>
				</div>
			</footer>
			<s:if test="null != #request.relateList && #request.relateList.size > 0">
				<ul class="thumbnails">
					<s:iterator value="#request.relateList" status="st">
						<li>
							<a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>" class="img" target="_blank">
								<img src="/img/www/grey.png" data-original="<s:property value="cover2"/>">
							</a>
							<div class="caption">
								<p class="title">
									<a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>" target="_blank">
										<s:property value="title" />
									</a>
								</p>
							</div></li>
					</s:iterator>
				</ul>
			</s:if>
			<div class="jumbotron m-t-3">
				<!-- 评论开始 -->
				<s:form id="pub_comment" method="post" theme="simple" cssClass="form m-b-8">
					<s:hidden name="newsId"/>
					<div class="form-group">
						<label for="comment-input" class="text-lg text-normal m-b-1">
							<s:if test="#request.commentPagin.totalRows > 0">对该文章的评论（<span><s:property value="#request.commentPagin.totalRows"/></span>条）</s:if>
							<s:else><span>邀请你给文章做第一个评论</span></s:else>
						</label>
						<s:textarea name="content" rows="6" data-maxsize="500" placeholder="我要说几句..."></s:textarea>
						<div class="text-right m-t-1">
							<span class="help m-r-1">还可以输入<b>500</b>字</span> 
							<button type="button" class="btn btn-primary btn-sm btn-submit" disabled="disabled" onclick="comment.dealPub()">发表</button>
						</div>
					</div>
				</s:form>
				<!-- 评论结束 -->
				<!-- 评论列表开始 -->
				<ul class="thumbnails-list horizontal" data-curpage="<s:property value='#request.commentPagin.curPage'/>" data-totalpages="<s:property value='#request.commentPagin.totalPages'/>">
					<s:if test="null != #request.commentPagin && #request.commentPagin.totalRows > 0">
						<s:iterator value="#request.commentPagin.curPageList" status="st">
							<li>
								<div class="left">
									<a href="/user/his/works.action?userId=<s:property value='userId'/>" target="_blank"> <img src="<s:property value="avatar" />" class="avatar">
									</a>
								</div>
								<div class="right">
									<p class="text-bold">
										<a href="/user/his/works.action?userId=<s:property value='userId'/>" target="_blank"><span><s:property value="nickname"/></span></a>
									</p>
									<p>
										<s:property value="content" escape="false" />
									</p>
									<p class="ft">
										<span class="right">
											<s:if test="null != #session.SESSION_USER">
												<s:if test="#request.userId == #session.SESSION_USER.userId">
													<span class="btn-msg-delete" onclick="comment.callRecycle(<s:property value='commentId'/>)">删除</span>
												</s:if>
												<s:else>
													<span class="btn-msg-reply" onclick="comment.reply('<s:property value='nickname'/>')">回复</span>
												</s:else>
											</s:if>
										</span> 
										<span class="time"><s:property value="addTimeDes" /></span>
									</p>
								</div>
							</li>
						</s:iterator>
					</s:if>
				</ul>
				<s:if test="#request.commentPagin.curPage < #request.commentPagin.totalPages">
					<li class="footer">
						<div class="right">
							<a class="btn btn-gray btn-xs" href="javascript:comment.pagin()">查看更多评论&gt;&gt;</a>
						</div>
					</li>
				</s:if>
				<!-- 评论列表结束 -->
			</div>
			<!-- 正文结束 -->
		</article>
		<!-- 左侧结束，右侧开始 -->
		<aside class="aside">
			<!-- 导航开始 -->
			<nav class="article-nav">
				<s:if test="null != #request.columnList && #request.columnList.size > 0">
					<s:iterator value="#request.columnList" status="st">
						<a href="/news/article/list.action<s:if test="null != columnId">?columnId=<s:property value="columnId"/></s:if>" 
							<s:if test="#request.articleView.columnName == #request.name"> class="active"</s:if>>
							<s:property value="name" />（<s:property value="articles" />）
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
							<li><a href="/news/article/detail.action?newsId=<s:property value = "newsId"/>"><s:property value="title" /></a></li>
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
		<!-- 右侧结束 -->
	</div>
</body>
</html>
