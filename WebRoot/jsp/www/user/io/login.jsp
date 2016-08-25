<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
    <title>登录-快拍快拍</title>
    <script src="/js/lib/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/jquery-migrate-1.2.1.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.min.js"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/user/login.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<link href="/css/www/common.css?r=<%=new Random().nextInt()%>" rel="stylesheet">
   	<script type="text/javascript">
		$(document).ready(function() {
			login.prep();
		});
	</script>
</head>
<body>
    <section class="container sm jumbotron">
        <s:form method="post" theme="simple" cssClass="form">
        	<s:hidden name="url"/>
            <div class="form-group">
                <label class="text-gray text-normal">昵称/手机/邮箱</label>
                <span class="help right"></span>
                <s:textfield name="username"/>
            </div>
            <div class="form-group">
                <label for="" class="text-gray text-normal">密码</label>
                <span class="help right"></span>
                <s:textfield type="password" name="password"/>
            </div>
			<div class="form-group">
                <div class="col-9">
                    <label for="" class="text-gray text-normal">输入验证码</label>
                    <s:if test="fieldErrors['authCode'].size > 0">
						<span class="help right error">
							<s:property value="fieldErrors['authCode'][0]" />
						</span>
					</s:if>
					<s:else>
						<span class="help right"></span>
					</s:else>
                </div>
                <div class="row-table">
                    <div class="col-9">
                        <s:textfield type="text" name="authCode"/>
                    </div>
                    <div class="col-3"><img src="/authImg.img" width="80" height="36" class="btn-link m-l-1"></div>
                </div>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary auto" onclick="login.deal()">登录</button>
            </div>
            <div class="text-center text-gray">
                没有账号?&nbsp;&nbsp;<a href="/user/io/register/prep.action" class="link-primary">立即注册</a>&nbsp;/&nbsp;<a href="/user/io/password/prepFind.action" class="link-primary">忘记密码？</a>
            </div>
        </s:form>
    </section>
</body>
</html>