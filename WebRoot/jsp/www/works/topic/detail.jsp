<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set id="YN_YES" value="@com.kpkp.util.SystemContext$YN@YES.getValue()"/>
<!doctype html>
<html lang="zh-CN">
<head>
	<title>作品-我的主页-快拍快拍</title>
	<script src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=923e02c7-ae35-4b80-8a9a-620d34e001b9&amp;pophcol=2&amp;lang=zh" type="text/javascript"></script>
	<script src="http://static.bshare.cn/b/bshareC0.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.min.js"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/works/topic.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/works/photo.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/works/praise.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/works/comment.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<link href="/css/www/common.css?r=<%=new Random().nextInt()%>" rel="stylesheet">
	<script type="text/javascript">
		$(document).ready(function() {
			comment.prepPub();
		});
	</script>
</head>
<body>
    <article class="container md">
        <header class="works-hd jumbotron">
            <div class="user">
                <div class="avatar">
                    <a href="/user/his/works.action?userId=<s:property value='#request.topicView.userId'/>" target="_blank">
                    	<img src="<s:property value='#request.topicView.avatar'/>">
                    </a>
                </div>
                <div class="center">
                    <p class="name">
                    	<a href="/user/his/works.action?userId=<s:property value='#request.topicView.userId'/>" target="_blank">
                    		<s:property value="#request.topicView.nickname"/>
                    	</a>
                    </p>
                    <p class="stat">
                    	<s:if test="#request.topicView.taskId > 0">
	                        <span>	
	                        	来自 <a href="/activity/task/newest.action?activityId=<s:property value='#request.topicView.taskId'/>" class="link-primary" target="_blank">
	                        		<s:property value="#request.topicView.taskName"/>
	                        	</a>
	                        </span>
                        </s:if>
                        <s:if test="#request.topicView.stationId > 0">
                       		<span>
	                       		来自 <a href="/activity/station/newest.action?activityId=<s:property value='#request.topicView.stationId'/>" class="link-primary" target="_blank">
	                        		<s:property value="#request.topicView.stationName"/>
	                        	</a>
                        	</span>
                       	</s:if>	
                        <span><s:property value="#request.topicView.addTimeDes"/></span>
                        <s:if test="null!=#session.SESSION_USER&&#session.SESSION_USER.userId==#request.topicView.userId">
                        	<a href="/works/topic/prepModify.action?topicId=<s:property value='#request.topicView.topicId'/>" class="btn btn-gray btn-xs m-l-1">编辑</a>
                        </s:if>
                    </p>
                </div>
                <div class="right">
                    <div class="bshare-custom icon-medium">
                        <div class="bsPromo bsPromo2"></div>
                        <a title="分享到QQ空间" class="bshare-qzone"></a>
                        <a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
                        <a title="分享到微信" class="bshare-weixin" href="javascript:void(0);"></a>
                        <a title="分享到人人网" class="bshare-renren"></a>
                        <a title="分享到豆瓣" class="bshare-douban" href="javascript:void(0);"></a>
                        <a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a>
                    </div>
                </div>
            </div>
            <div class="intro"><s:property value="#request.topicView.intro" escape="false" /></div>
        </header>
        <!-- 列表开始 -->
		<s:if test="null != #request.topicView.photoList && #request.topicView.photoList.size > 0">
		<ul class="thumbnails-list">
			<s:iterator value="#request.topicView.photoList" status="st">
			<li>
                <a href="/works/photo/detail.action?photoId=<s:property value='photoId'/>" target="_blank" class="img default">
                    <img src="/img/www/grey.png" data-original="<s:property value='img2'/>">
                    <s:if test="null!=exif">
	                    <i class="icon-exif">EXIF</i>
	                    <ul class="picexif-container">
	                        <li>品牌：<b><s:property value='exif.make'/></b></li>
	                        <li>型号：<b><s:property value='exif.model'/></b></li>
	                        <li>焦距：<b><s:property value='exif.focalLength'/></b></li>
	                        <li>光圈：<b><s:property value='exif.aperture'/></b></li>
	                        <li>快门速度：<b><s:property value='exif.shutterSpeed'/></b></li>
	                        <li>ISO：<b><s:property value='exif.iso'/></b></li>
	                        <li>曝光补偿：<b><s:property value='exif.ev'/></b></li>
	                        <li>镜头：<b><s:property value='exif.lens'/></b></li>
	                    </ul>
                    </s:if>
                </a>
				<div class="caption">
					<a href="/works/photo/detail.action?photoId=<s:property value='photoId'/>" target="_blank">
                    	<s:property value="intro" escape="false"/>
                    </a>
                    <s:if test="#YN_YES==awardFlag">
                    	<p class="text-gray"><i class="icon-medal"></i><s:property value='awardPrize'/></p>
                    </s:if>
                    <s:if test="#YN_YES==starFlag">
                    	<p class="text-gray"><i class="icon-star"></i><s:property value='starDateDes'/>&nbsp;&nbsp;<s:if test="starIntro==null || starIntro=='' ">每日之星</s:if><s:property value='starIntro'/></p>
                    </s:if>
                    <s:if test="#request.topicView.taskId > 0 || #request.topicView.stationId>0">
                    	<p class="text-gray"><i class="icon-mission"></i>
                    		<s:if test="#request.topicView.taskId > 0">
                    		来自<a href="/activity/task/newest.action?activityId=<s:property value='#request.topicView.taskId'/>" class="link-primary" target="_blank">
	                        	<s:property value="#request.topicView.taskName"/>
	                        </a>
	                        </s:if>
	                        <s:if test="stationId > 0">
                    		来自<a href="/activity/station/newest.action?activityId=<s:property value='#request.topicView.stationId'/>" class="link-primary" target="_blank">
	                        	<s:property value="#request.topicView.stationName"/>
	                        </a>
	                        </s:if>
                    	</p>
                    </s:if>
                    <s:if test="#YN_YES==choiceFlag">
                    	<p class="text-gray"><i class="icon-choice"></i>哇哇！照片被精选啦。好在哪里呢？</p>
                    </s:if>
				</div>
				<div class="ft">
					<s:if test="null!=#session.SESSION_USER">
					<div class="left">
						<!-- 如果是精选 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@MAKE_CHOICE.getValue()]">
							<a href="javascript:photo.dealMakeChoice(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">精选</a>
						</s:if>
						<!-- 如果是取消精选 -->
                        <s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@CANCEL_CHOICE.getValue()]">
							<a href="javascript:photo.dealCancelChoice(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">取消精选</a>
						</s:if>
                    	<!-- 如果是评奖 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@MAKE_AWARD.getValue()]">
							<a href="javascript:photo.callMakeAward(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">评奖</a>
						</s:if>
						<!-- 如果是取消评奖 -->
                        <s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@CANCEL_AWARD.getValue()]">
							<a href="javascript:photo.callCancelAward(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">取消评奖</a>
						</s:if>
						<!-- 如果是设为每日之星 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@MAKE_STAR.getValue()]">
							<a href="javascript:photo.callMakeStar(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">每日之星</a>
						</s:if>
						<!-- 如果是取消每日之星 -->
                        <s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@CANCEL_STAR.getValue()]">
							<a href="javascript:photo.callCancelStar(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">取消每日之星</a>
						</s:if>
						<!-- 如果是任务退稿 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@TASK_BACK.getValue()]">
							<a href="javascript:photo.callTaskBack(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">任务退稿</a>
						</s:if>
						<!-- 如果是小站退稿 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@STATION_BACK.getValue()]">
							<a href="javascript:photo.callStationBack(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">小站退稿</a>
						</s:if>
						<!-- 如果是删除 -->
						<s:if test="null != options[@com.kpkp.util.SystemContext$WORKS_OPTION@RECYCLE.getValue()]">
							<a href="javascript:photo.callRecycle(<s:property value='photoId'/>)" class="btn btn-gray btn-xs">删除</a>
						</s:if>
						</div>
						<span class="btn-group">
							<s:if test="#YN_YES==praiseFlag">
								<a href="javascript:praise.cancel(<s:property value='photoId'/>)" title="取消点赞" class="btn-like active">
									<i class="icon-heart"></i> <span><s:property value='praises'/></span>
								</a>
							</s:if>
							<s:else>
								<a href="javascript:praise.make(<s:property value='photoId'/>)" title="赞" class="btn-like">
									<i class="icon-heart"></i> <span><s:property value='praises'/></span>
								</a>
							</s:else>
							<a href="javascript:comment.callPub(<s:property value='photoId'/>)" title="评论" class="btn-comment">
								<i class="icon-speech"></i> <span><s:property value='comments'/></span>
						    </a>
						</span>
                    </s:if>
                    <s:else>
                    	<span class="btn-group">
							<a href="javascript:praise.make(<s:property value='photoId'/>)" title="赞" class="btn-like">
								<i class="icon-heart"></i> <span><s:property value='praises'/></span>
							</a>
							<a href="javascript:comment.callPub(<s:property value='photoId'/>)" title="评论" class="btn-comment">
								<i class="icon-speech"></i> <span><s:property value='comments'/></span>
						    </a>
						</span>
                    </s:else>
				</div>
			</li>
			</s:iterator>
		</ul>
		</s:if>
		<s:else>
		<!-- 暂无内容开始 -->
		<div class="msg-box">
			<img src="/img/www/icon-box.png">
			<p class="text-center">暂无内容</p>
		</div>
		<!-- 暂无内容结束 -->
		</s:else>
        <!-- 列表结束 -->
        <!-- 个人信息开始 -->
        <s:action name="summary" executeResult="true" namespace="/works/shooter">
			<s:param name="userId"><s:property value="#request.topicView.userId"/></s:param>
	   	</s:action>
        <!-- 个人信息结束 -->
        <!-- 赞和评论开始 -->
        <aside class="works-ft jumbotron">
            <!-- 赞开始 -->
		    <s:action name="list" executeResult="true" namespace="/works/praise">
				<s:param name="topicId"><s:property value="#request.topicView.topicId"/></s:param>
				<s:param name="curPage">1</s:param>
		   	</s:action>
            <!-- 赞结束 -->
            <!-- 评论开始 -->
			<s:form method="post" theme="simple" cssClass="form m-b-8">
				<div class="form-group" data-topic-id="<s:property value='#request.topicId'/>" data-photo-id="0">
					<label class="text-lg text-normal m-b-1">评论（<span class="comment-count"><s:property value="#request.topicView.comments"/></span>）</label>
					<s:textarea name="word" rows="6" data-maxsize="500" placeholder="我要说几句..."></s:textarea>
					<div class="text-right m-t-1">
						<span class="help m-r-1">还可以输入<b>500</b>字</span>
						<span disabled="disabled" class="btn btn-primary btn-sm btn-submit">发表</span>
					</div>
				</div>
			</s:form>
            <!-- 评论结束 -->
            <!-- 评论列表开始 -->
		    <s:action name="list" executeResult="true" namespace="/works/comment">
				<s:param name="topicId"><s:property value="#request.topicView.topicId"/></s:param>
				<s:param name="curPage">1</s:param>
		   	</s:action>
            <!-- 评论列表结束 -->
        </aside>
        <!-- 赞和评论结束 -->
    </article>
</body>
</html>
