<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<title>作品-TA的主页-快拍快拍</title>
	<script type="text/javascript">
		$(document).ready(function() {
			plus.readMode();
		});
	</script>
</head>
<body class="uc">
	<content tag="bodyClass">class="uc"</content>
    <s:action name="intro" executeResult="true" namespace="/user/his">
		<s:param name="userId"><s:property value="#request.userId"/></s:param>
   	</s:action>
	<section class="container jumbotron">
		<s:if test="null != #request.topicPagin && #request.topicPagin.totalRows > 0">
		<header class="uc-title mobile-hidden">
			<div class="row-table">
				<div class="text-gray">共<s:property value="#request.topicPagin.totalRows" />张照片</div> 
				<div class="right">
					<span class="nav-tabs">
						<a href="javascript:void(0)" title="网格模式" <s:if test="#request.mode=='grid'">class="active"</s:if>><i class="icon-grid"></i></a>
						<a href="javascript:void(0)" title="列表模式" <s:if test="#request.mode=='list'">class="active"</s:if>><i class="icon-list"></i></a>
					</span>
				</div>
			</div>
		</header>
		<div class="tab-content">
		<ul class="avg-sm-2 avg-md-2 avg-lg-3 thumbnails md auto border tab-pane <s:if test="#request.mode=='grid'">active</s:if>">
			<s:iterator value="#request.topicPagin.curPageList" status="st">
				<li>
					<a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" target="_blank" class="img">
						<img src="/img/www/grey.png" data-original="<s:property value="img3"/>">
					</a>
					<div class="caption">
						<p class="title">
							<a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" target="_blank">
							<s:property value="intro" escape="false"/></a>
						</p>
					</div>
				</li>
			</s:iterator>
		</ul>
		<ul class="thumbnails-list horizontal tab-pane <s:if test="#request.mode=='list'">active</s:if>">
			<s:iterator value="#request.topicPagin.curPageList" status="st">
				<li>
					<div class="left">
						<p class="day">
							<s:property value='addDayDes' />
						</p>
						<p class="month">
							<s:property value='addMonthDes' />
						</p>
					</div>
					<div class="right">
						<a href="/works/topic/detail.action?topicId=<s:property value='topicId' />" target="_blank" class="img">
							<img src="/img/www/grey.png" data-original="<s:property value='img2'/>">
						</a>
						<div class="caption">
							<a href="/works/topic/detail.action?topicId=<s:property value='topicId' />" target="_blank">
								<s:property value='intro' escape="false"/>
							</a>
							<span class="text-primary">
								<s:if test="photos == 1">[单张]</s:if>
		                        <s:else>[组图<s:property value="photos"/>P]</s:else>
							</span>
						</div>
						<div class="ft">
							<span class="btn-group">
								<a href="/works/topic/detail.action?topicId=<s:property value='topicId' />" title="赞" target="_blank" class="btn-like">
									<i class="icon-heart"></i><s:property value='praises' />
								</a>
								<a href="/works/topic/detail.action?topicId=<s:property value='topicId' />" title="评论" target="_blank">
									<i class="icon-speech"></i><s:property value='comments' />
								</a>
							</span>
						</div>
					</div>
				</li>
			</s:iterator>
		</ul>
		</div>
		</s:if>
		<s:else>
			<!-- 暂无内容开始 -->
			<div class="msg-box">
				<img src="/img/www/icon-box.png">
				<p class="text-center">暂无内容</p>
			</div>
			<!-- 暂无内容结束 -->
		</s:else>
	</section>
	<nav>
		<s:set value="#request.topicPagin.curPage" name="curPage" />
		<s:set value="#request.topicPagin.totalPages" name="totalPages" />
		<s:include value="/jsp/www/pagin.jsp">
			<s:param name="pageLink">works.action?userId=<s:property value='#request.userId'/>&mode=<s:property value='#request.mode'/></s:param>
			<s:param name="anchor"></s:param>
			<s:param name="curPage">
				<s:property value='#curPage' />
			</s:param>
			<s:param name="totalPages">
				<s:property value='#totalPages' />
			</s:param>
		</s:include>
	</nav>
</body>
</html>
