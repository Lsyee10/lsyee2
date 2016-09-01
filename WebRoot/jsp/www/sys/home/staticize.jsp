<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="zh-CN">
<head>
   <title>首页－快拍快拍网</title>
    <script src="/js/lib/jquery/jcarousel/jquery.jcarousel.min-1.2.js" type="text/javascript"></script>	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#banner-top').carousel('0.4', '0', '20');
            $('#banner-md').carousel('0.75', '38', '72');
		});
	</script>
</head>
<body>
	<s:include value="/html/www/sys/home/link.html"></s:include>
    <!-- 一次旅行开始 -->
    <section class="container">
    	<ul class="avg-sm-1 avg-md-3 avg-lg-3 thumbnails together-list">
    		<s:if test="#request.topTravels.size > 0">
	        	<s:iterator value="#request.topTravels" status="st">
	        		<li>
		                <p class="title">
		                	<a href="/activity/travel/detail.action?activityId=<s:property value='activityId'/>" target="_blank">
		                		<s:property value='name' escape='false'/>
		                	</a>
		                </p>
		                <div class="desc">
		                    <p><i class="icon-calendar"></i> 时间：<s:property value='prize' escape='false'/></p>
		                    <p><i class="icon-flag"></i> 路线：<s:property value='area' escape='false'/></p>
		                </div>
		                <div class="user">
		                    <div class="avatar">
		                        <a href="/user/his/home.action?shooterId=<s:property value='leader.userId'/>" target="_blank">
		                        	<img src="<s:property value='leader.avatar'/>">
		                        </a>
		                    </div>
		                    <div class="center">
		                        <p class="name">
		                        	<a href="/user/his/home.action?shooterId=<s:property value='leader.userId'/>" target="_blank">
		                        		<s:property value='leader.nickname' escape='false'/>
		                        	</a>
		                        </p>
		                        <p class="intro">带队导师</p>
		                    </div>
		                    <div class="right">
		                        <a href="/activity/travel/detail.action?activityId=<s:property value='activityId'/>" class="btn btn-primary btn-sm">
									<s:property value='leftDayDes' escape='false'/>
								</a>
		                    </div>
		                </div>
		            </li>
	        	</s:iterator>
	        </s:if>
        </ul>
    </section>
    <!-- 一次旅行结束 -->
    <!-- 精选及最新开始 -->
    <section class="container">
        <header class="title">
            <nav>
                <a href="/works/topic/choice.action" target="_blank">精选</a>
                <a href="/works/topic/newest.action" target="_blank">最新</a>
            </nav>
            <p>今天最新鲜的好照片都在这里哟！点我吧！</p>
        </header>
        <ul class="avg-sm-2 avg-md-4 avg-lg-4 thumbnails auto">
	        <s:if test="#request.choicePhotos.size > 0">
		        <s:iterator value="#request.choiceTopics" status="st">
		        	<li>
		                <a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" target="_blank" class="img">
		                	<img src="/img/www/grey.png" data-original="<s:property value='img4'/>">
		                </a>
		                <div class="caption">
		                    <p class="title">
		                    	<a href="/works/topic/detail.action?topicId=<s:property value='topicId'/>" target="_blank">
		                    		<s:property value='intro' escape='false'/>
		                    	</a>
		                    </p>
		                    <p>
		                    	<a href="/user/his/works.action?userId=<s:property value='userId'/>" target="_blank">
								 	@<s:property value='nickname' escape='false'/>
								</a>
							</p>
		                </div>
		            </li>
		        </s:iterator>
		    </s:if>
        </ul>
    </section>
</body>
</html>

