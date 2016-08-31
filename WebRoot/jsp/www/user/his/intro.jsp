<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set id="YN_YES" value="@com.kpkp.util.SystemContext$YN@YES.getValue()"/>
<!-- 用户信息开始 -->
<s:if test="null != #request.userProfileView">
<section class="uc-header" style="background-image:url(<s:property value='#request.userProfileView.bgImg'/>)">
    <div class="container">
        <div class="user">
            <div class="avatar">
                <a href="javascript:void(0)">
                	<img src="<s:property value='#request.userProfileView.avatar'/>">
                </a>
            </div>
            <div class="center">
                <p class="name"><s:property value='#request.userProfileView.nickname'/></p>
                <p class="intro"><s:property value='#request.userProfileView.intro'/></p>
                <p class="stat">
                   <span>
                   <a href="/user/his/works.action?userId=<s:property value='#request.userProfileView.userId'/>">
                   	<s:property value='#request.userProfileView.photos'/>作品
                   </a>
                   </span>
                   <span>
                   <a href="/user/his/focus.action?userId=<s:property value='#request.userProfileView.userId'/>">
                   	<s:property value='#request.userProfileView.focus'/> 关注
                   </a>
                   </span>
                   <span>
                   <a href="/user/his/fans.action?userId=<s:property value='#request.userProfileView.userId'/>">
                   	<s:property value='#request.userProfileView.fans'/> 粉丝
                   </a>
                   </span>
                </p>
                <s:if test = "null != #session.SESSION_USER">
                	<s:if test = "#session.SESSION_USER.userId != #request.userProfileView.userId">
						<div class="btn-group">
							<a href="/user/my/chat/msg.action?friendId=<s:property value='#request.userProfileView.userId'/>" class="btn btn-black btn-sm"><i class="icon-envelope"></i> 发私信</a>
							<s:if test="#YN_YES == #request.userProfileView.focusFlag">
								<a href="javascript:relation.cancelFocus(<s:property value='#request.userProfileView.userId'/>)" class="btn btn-gray btn-sm">取消关注</a>
							</s:if>
							<s:else>
								<a href="javascript:relation.makeFocus(<s:property value='#request.userProfileView.userId'/>)" class="btn btn-primary btn-sm">加关注</a>
							</s:else>
						</div>
					</s:if>
					<s:else>
						<div class="btn-group"></div>
					</s:else>
				</s:if>
				<s:else>
					<div class="btn-group">
						<a href="/user/my/chat/msg.action?friendId=<s:property value='#request.userProfileView.userId'/>" class="btn btn-black btn-sm"><i class="icon-envelope"></i> 发私信</a>
						<a href="javascript:relation.makeFocus(<s:property value='#request.userProfileView.userId'/>)" class="btn btn-primary btn-sm">加关注</a>
					</div>
				</s:else>
            </div>
        </div>
    </div>
</section>
</s:if>
<!-- 用户信息结束 -->
<!-- 用户导航开始 -->
<s:set id="URI_PATH" value="#request.get('struts.request_uri')"/>
<section class="uc-nav">
   <nav class="container">
      <a href="/user/his/works.action?userId=<s:property value='#request.userProfileView.userId'/>" <s:if test="#URI_PATH=='/user/his/works.action'">class="active"</s:if>>作品</a>
      <a href="/user/his/focus.action?userId=<s:property value='#request.userProfileView.userId'/>" <s:if test="#URI_PATH=='/user/his/focus.action'">class="active"</s:if>>关注</a>
      <a href="/user/his/fans.action?userId=<s:property value='#request.userProfileView.userId'/>" <s:if test="#URI_PATH=='/user/his/fans.action'">class="active"</s:if>>粉丝</a>
   </nav>
</section>
<!-- 用户导航结束 -->
