<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
                    <span><a href="/user/my/works/topic.action?mode=grid"><s:property value='#request.userProfileView.photos'/> 作品</a></span>
                    <span><a href="/user/my/relation/focus.action"><s:property value='#request.userProfileView.focus'/> 关注</a></span>
                    <span><a href="/user/my/relation/fans.action"><s:property value='#request.userProfileView.fans'/> 粉丝</a></span>
                </p>
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
      <a href="/user/my/home.action" <s:if test="#URI_PATH=='/user/my/home.action'">class="active"</s:if>>主页</a>
      <a href="/user/my/works/topic.action?mode=grid" <s:if test="#URI_PATH=='/user/my/works/topic.action'||#URI_PATH=='/user/my/works/choice.action'||#URI_PATH=='/user/my/works/priase.action'">class="active"</s:if>>作品</a>
      <a href="/user/my/tag/list.action" <s:if test="#URI_PATH=='/user/my/tag/list.action'">class="active"</s:if>>订阅</a>
      <a href="/user/my/relation/focus.action" <s:if test="#URI_PATH=='/user/my/relation/focus.action'">class="active"</s:if>>关注</a>
      <a href="/user/my/relation/fans.action" <s:if test="#URI_PATH=='/user/my/relation/fans.action'">class="active"</s:if>>粉丝</a>
      <a href="/user/my/msg/event.action" <s:if test="#URI_PATH=='/user/my/msg/event.action'||#URI_PATH=='/user/my/msg/notice.action'||#URI_PATH=='/user/my/chat/sess.action'||#URI_PATH=='/user/my/chat/msg.action'">class="active"</s:if>>消息</a>
      <a href="/user/my/setting/profile.action" <s:if test="#URI_PATH=='/user/my/setting/profile.action'||#URI_PATH=='/user/my/setting/avatar.action'||#URI_PATH=='/user/my/setting/password.action'||#URI_PATH=='/user/my/setting/wall.action'||#URI_PATH=='/user/my/setting/bind.action'||#URI_PATH=='/user/my/setting/event.action'">class="active"</s:if>>设置</a>
   </nav>
</section>
<!-- 用户导航结束 -->
