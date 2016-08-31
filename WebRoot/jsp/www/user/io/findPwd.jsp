<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
    <title>忘记密码-快拍快拍</title>
	<script src="/js/lib/jquery/validate/jquery.validate.min.js"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/user/password.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
   	<script type="text/javascript">
		$(document).ready(function() {
			password.prepFind();
		});
	</script>
</head>
<body>
    <section class="container sm jumbotron">
        <s:form autocomplete="off" method="post" theme="simple" cssClass="form">
            <div class="form-group">
                <label for="" class="text-gray text-normal">手机或邮箱</label>
                <span class="help right"></span>
                <s:textfield name="accept"/>
            </div>
            <div class="form-group">
                <div class="col-9">
                    <label for="" class="text-gray text-normal">输入验证码</label>
                   	<s:if test="fieldErrors['authCode'].size > 0">
	                   	<span class="help right error">
							<s:property value="fieldErrors['authCode'][0]"/>
						</span>
					</s:if>
                    <s:else>
                    	<span class="help right"></span>
                    </s:else>
                </div>
                <div class="row-table">
                    <div class="col-9">
                        <s:textfield name="authCode"/>
                    </div>
                    <div class="col-3"><a class="btn btn-default btn-sm m-l-1" href="javascript:password.getAuthCode()">获取验证码</a></div>
                </div>
            </div>
            <div class="form-group">
                <label for="" class="text-gray text-normal">新密码</label>
                <span class="help right"></span>
                <s:textfield type="password" name="newPassword"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary auto" onclick="password.dealFind()">提交</button>
            </div>
            <div class="text-center text-gray">
                已有账号?&nbsp;&nbsp;<a href="/user/io/login/prep.action" class="link-primary">登录</a>
            </div>
        </s:form>
    </section>
</body>