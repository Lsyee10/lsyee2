<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
    <title>修改密码-设置-我的主页-快拍快拍</title>
    <script src="/js/lib/jquery/validate/jquery.validate.min.js"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/user/password.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
   	<script type="text/javascript">
		$(document).ready(function() {
			password.prepModify();
		});
	</script>	
</head>
<body>
	<content tag="bodyClass">class="uc"</content>
	<s:action name="intro" executeResult="true" namespace="/user/my">
		<s:param name="userId"><s:property value="#session.SESSION_USER.userId"/></s:param>
   	</s:action>
    <!-- 用户导航结束 -->
    <section class="container jumbotron">
        <header class="uc-title">
            <div class="row-table">
                <nav class="left">
                    <a href="/user/my/setting/profile.action">个人信息</a>
                    <a href="/user/my/setting/avatar.action">修改头像</a>
                    <a href="/user/my/setting/password.action" class="active">修改密码</a>
                    <a href="/user/my/setting/wall.action">背景图设置</a>
                    <a href="/user/my/setting/bind.action">绑定设置</a>
                    <a href="/user/my/setting/event.action">通知设置</a>
                </nav>
            </div>
        </header>
        <s:form id="prepPassword" method="post" theme="simple" cssClass="form">
            <div class="form-group">
                <label for="">原密码</label>
                <s:if test="fieldErrors['oldPassword'].size > 0">
					<span class="help right error">
						<s:property value="fieldErrors['oldPassword'][0]" />
					</span>
				 </s:if>
				 <s:else>
					<span class="help right"></span>
				 </s:else>
                <s:password name="oldPassword" placeholder="请输入原密码"/>
            </div>
            <div class="form-group">
                <label for="">新密码</label>
                <span class="help right"></span>
				<s:password name="newPassword" placeholder="设置新密码"/>
            </div>
            <div class="form-group">
                <label for="">重复密码</label>
                <span class="help right"></span>
                <s:password name="cfmPassword"/>
            </div>
            <div>
                <button onClick="password.dealModify()" type="button" class="btn btn-primary btn-xl">修改</button>
            </div>
        </s:form>
    </section>
</body>
</html>
