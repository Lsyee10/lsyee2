<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>修改头像-设置-我的主页-快拍快拍</title>
    <link href="/js/lib/jquery/jcrop/jquery.Jcrop.css" rel="stylesheet">
    <script src="/js/lib/jquery/jcrop/jquery.Jcrop.js" type="text/javascript"></script>
    <script src="/js/lib/jquery/uploadify/jquery.uploadify.js" type="text/javascript"></script>	
	<script src="/js/com/www/user/avatar.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			avatar.upload("${pageContext.session.id}");
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
                    <a href="/user/my/setting/profile.action">个人信息</a>
                    <a href="/user/my/setting/avatar.action" class="active">修改头像</a>
                    <a href="/user/my/setting/password.action">修改密码</a>
                    <a href="/user/my/setting/wall.action">背景图设置</a>
                    <a href="/user/my/setting/bind.action">绑定设置</a>
                    <a href="/user/my/setting/event.action">通知设置</a>
                </nav>
            </div>
        </header>
        <div class="upload-wrapper">
            <div class="select-picture">
                <div class="load"></div>
                <div class="m-t-1">
	            	<p class="help hide"></p>
	            	<s:file name="image" id="avatar_image"/>
	            </div>
            </div>
            <div class="preview">
                <div class="preview-avatar avatar">
                	<img src="${sessionScope.SESSION_USER.avatar}"/>
                </div>
                <p class="m-t-3">
                    <a href="javascript:avatar.save()" disabled="disabled" class="btn btn-primary btn-sm">保存</a>
                    <a href="javascript:window.location.reload()" class="btn btn-gray btn-sm">取消</a>
                </p>
            </div>
            <s:form name="model" theme="simple">
	            <s:hidden name="x" value="0"/>
				<s:hidden name="y" value="0"/>
				<s:hidden name="w" value="180"/>
				<s:hidden name="h" value="180"/>
				<s:hidden name="imageFileName"/>
            </s:form>
        </div>
    </section>
</body>
</html>
