<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>设置-我的主页-快拍快拍</title>
    <script src="/js/lib/jquery/validate/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>	
    <script src="/js/com/www/user/profile.js?r=<%=new Random().nextInt()%>" type="text/javaScript"></script>
    <script type="text/javascript">
	    $(document).ready(function(){
	    	profile.prepModify();
	    });
    </script>
</head>
<body class="uc">
	<content tag="bodyClass">class="uc"</content>
	<s:action name="intro" executeResult="true" namespace="/user/my">
		<s:param name="userId"><s:property value="#session.SESSION_USER.userId"/></s:param>
   	</s:action>
    <section class="container jumbotron">
        <header class="uc-title">
            <div class="row-table">
                <nav class="left">
                    <a href="/user/my/setting/profile.action" class="active">个人信息</a>
                    <a href="/user/my/setting/avatar.action">修改头像</a>
                    <a href="/user/my/setting/password.action">修改密码</a>
                    <a href="/user/my/setting/wall.action">背景图设置</a>
                    <a href="/user/my/setting/bind.action">绑定设置</a>
                    <a href="/user/my/setting/event.action">通知设置</a>
                </nav>
            </div>
        </header>
        <s:form id="prepProfile" method="post" theme="simple" cssClass="form">
            <div class="form-group">
                <label for="">昵称</label>
                <s:if test="fieldErrors['nickname'].size > 0">
					<span class="help right error">
						<s:property value="fieldErrors['nickname'][0]" />
					</span>
				 </s:if>
				 <s:else>
					<span class="help right"></span>
				 </s:else>
                <input type="text" name="nickname" placeholder="请输入昵称" value="<s:property value="#request.userProfileView.nickname"/>">
            </div>       
            <div class="form-group">
                <label for="">一句话介绍自己</label>
                <span class="help right"></span>
                <textarea name="intro" rows="2" placeholder="请用一句简短的话介绍自己，50字以内"><s:property value="#request.userProfileView.intro"/></textarea>
            </div>
            <div class="form-group">
                <label for="">所在城市</label>
                <span class="help right"></span>
                <input type="text" name="city" placeholder="请填写你常住的城市，比如“杭州”" value="<s:property value="#request.userProfileView.city"/>">
            </div>
            <div>
                <button onClick="profile.dealModify()" type="button" class="btn btn-primary btn-xl">保存</button>
            </div>
        </s:form>
    </section>
    <!-- 底部结束 -->
</body>
</html>
