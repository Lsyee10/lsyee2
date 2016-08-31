<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
    <title>背景图设置-设置-我的主页-快拍快拍</title>
    <script src="/js/lib/jquery/uploadify/jquery.uploadify.js" type="text/javascript"></script>	
	<script src="/js/com/www/user/profile.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			profile.modifyWall("${pageContext.session.id}");
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
                    <a href="/user/my/setting/avatar.action" >修改头像</a>
                    <a href="/user/my/setting/password.action">修改密码</a>
                    <a href="/user/my/setting/wall.action" class="active">背景图设置</a>
                    <a href="/user/my/setting/bind.action">绑定设置</a>
                    <a href="/user/my/setting/event.action">通知设置</a>
                </nav>
            </div>
        </header>
        <div class="upload-wrapper">
            <div class="load"></div>
            <div class="m-t-1">
            	<p class="help hide"></p>
            	<s:file name="image" id="wall_image"/>
            </div>
            <div>支持jpg、png格式，图片不超过3MB，建议上传图片尺寸1920*480</div>
        </div>
    </section>
</body>
</html>
