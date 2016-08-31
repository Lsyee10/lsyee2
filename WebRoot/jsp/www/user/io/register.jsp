<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
    <title>注册-快拍快拍</title>
	<script src="/js/lib/jquery/validate/jquery.validate.min.js"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/user/register.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
   	<script type="text/javascript">
		$(document).ready(function() {
			register.prep();
		});
	</script>
</head>
<body>
    <section class="container sm jumbotron">
        <header class="title">
            <h2>注册</h2>
        </header>
        <s:form method="post" theme="simple" cssClass="form">
            <div class="form-group">
                <label class="text-gray text-normal">手机或邮箱</label>
                <s:if test="fieldErrors['accept'].size > 0">
                   	<span class="help right error">
						<s:property value="fieldErrors['accept'][0]"/>
					</span>
				</s:if>
                <s:else>
                   	<span class="help right"></span>
                </s:else>
                <s:textfield name="accept"/>
            </div>
            <div class="form-group">
                <div class="col-9">
                    <label class="text-gray text-normal">输入验证码</label>
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
                    <div class="col-3">
                    	<a href="javascript:register.getAuthCode()" class="btn btn-default btn-sm m-l-1">获取验证码</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-gray text-normal">昵称</label>
                <s:if test="fieldErrors['nickname'].size > 0">
                   	<span class="help right error">
						<s:property value="fieldErrors['nickname'][0]"/>
					</span>
				</s:if>
                <s:else>
                   	<span class="help right"></span>
                </s:else>
                <s:textfield name="nickname" placeholder="2~12位，支持中文、英文、下划线"/>
            </div>
            <div class="form-group">
                <label class="text-gray text-normal">密码</label>
                <span class="help right"></span>
                <s:textfield type="password" name="password" placeholder="6-20位，支持字符、数字和下划线"/>
            </div>
            <div class="form-group">
                <label for="" class="text-gray text-normal">重复密码</label>
                <span class="help right"></span>
                <s:textfield type="password" name="confirmPassword" placeholder="再次输入密码"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary auto" onclick="register.deal()">完成注册</button>
            </div>
            <div class="text-center text-gray">
                已有账号?&nbsp;&nbsp;<a href="/user/io/login/prep.action" class="link-primary">登录</a>
            </div>
        </s:form>
    </section>
</body>
