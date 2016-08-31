<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>我的主页-快拍快拍</title>
	<script src="/js/com/www/works/topic.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
</head>
<body>
	<content tag="bodyClass">class="uc"</content>
    <s:action name="intro" executeResult="true" namespace="/user/my">
		<s:param name="userId"><s:property value="#session.SESSION_USER.userId"/></s:param>
   	</s:action>
	<section class="container jumbotron">
        <!-- 列表开始 -->
        <s:if test="null != #request.topicPagin && #request.topicPagin.totalRows > 0">
	        <ul class="thumbnails-list horizontal"
				data-cur-page="<s:property value='#request.topicPagin.curPage'/>" 
				data-total-pages="<s:property value='#request.topicPagin.totalPages'/>">
	        	<s:iterator value="#request.topicPagin.curPageList" status="st">
		       		<li>
		                <div class="left">
		                    <a href="/user/his/works.action?userId=<s:property value='userId'/>" target="_blank">
		                        <img src="<s:property value='avatar'/>" class="avatar">
		                        <p class="name"><s:property value="nickname"/></p>
		                    </a>
		                </div>
		                <div class="right">
		                    <a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" class="img" target="_blank">
		                        <img src="/img/www/grey.png" data-original="<s:property value='img2'/>">
		                    </a>
		                    <div class="caption">
		                        <a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" class="title" target="_blank"><s:property value="intro" escape="false"/></a>
		                        <span class="text-primary">
		                        	<s:if test="photos == 1">[单张]</s:if>
		                        	<s:else>[组图<s:property value="photos"/>P]</s:else>
		                        </span>
		                    </div>
		                    <div class="ft">
		                        <span class="time"><s:property value="addTimeDes"/></span>
		                        <span class="btn-group">
									<a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" title="赞" class="btn-like" target="_blank">
										<i class="icon-heart"></i> <span><s:property value='praises'/></span>
									</a>
									<a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" title="评论" class="btn-comment" target="_blank">
										<i class="icon-speech"></i> <span><s:property value='comments'/></span>
								    </a>
								</span>
		                    </div>
		                </div>
		            </li>
	      	  	</s:iterator>
			    <s:if test="#request.topicPagin.curPage < #request.topicPagin.totalPages">
			     	<li class="footer">
			            <div class="right">
					   		<a href="javascript:topic.myFocusPagin(<s:property value='#session.SESSION_USER.userId'/>)" class="btn btn-gray btn-xs">更多作品 &gt;&gt;</a>
			            </div>
			        </li>
			    </s:if>
	        </ul>
        </s:if>
     </section>
</body>
</html>
