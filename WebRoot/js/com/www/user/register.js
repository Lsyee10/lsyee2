register = {
	FORM_ID : "prep",
	SEND_AUTH_CODE_SUCCESS : "发送成功",
	DEAL_URL : "/user/io/register/deal.action",
	VALID_NICKNAME_URL : "/user/io/register/validUsername.action",
	SEND_AUTH_CODE_URL : "/user/io/register/sendAuthCode.action"
};

/**
 * 注册准备
 */
register.prep = function() {
	// 昵称唯一性验证
	$("#" + register.FORM_ID + "_nickname").blur(function() {
		register.validNickname();
	});
	
	// 表单验证
	$("#" + register.FORM_ID).validate({
		rules : {
			accept : {
				required : true,
				isMobileOrEmail : true
			},
			authCode : {
				required : true,
				minlength : 6,
				maxlength : 6
			},
			nickname : {
				required : true,
				rangelength : [ 2, 12]
			},
			password : {
				required : true,
				rangelength : [ 6, 20 ]
			},
			confirmPassword : {
				required : true,
				rangelength : [ 6, 20 ],
				equalTo : "#" + register.FORM_ID + "_password"
			}
		}
	});
	
	// 登录按钮回车事件
	$("#" + register.FORM_ID).bind("keyup", function(e) {
		if (e.keyCode == 13) {
			login.deal();
		}
	});
};

/**
 * 昵称校验
 */ 
register.validNickname = function() {
	// 获取昵称节点
	var nicknameNode = $("#" + register.FORM_ID + "_nickname");
	
	// 如果昵称存在
	if (nicknameNode.val() != "") {
		$.ajax({
			type : "POST",
			url : register.VALID_NICKNAME_URL,
			data : {username:nicknameNode.val()},
			dataType : "json",
			success : function(data) {
				if (data.actionDealMsg != null) {
					nicknameNode.attr("class", "error");
					nicknameNode.prev().text(data.actionDealMsg).addClass("error").show();
				}
			}
		});
	}
};

/**
 * 获取验证码
 */
register.getAuthCode = function() {
	var acceptNode = $("#" + register.FORM_ID + "_accept");
	var helpNode = acceptNode.parent("div").find("span.help");
	
	// 校验发送的手机或邮箱
	var mobile = /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
	var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var acceptVal = acceptNode.val();
	
	// 如果接收为空
	if (acceptVal == "") {
		helpNode.text("手机或邮箱不能为空").addClass("error");
	} else if (!mobile.test(acceptVal) && !email.test(acceptVal)) {
		helpNode.text("请填写正确的手机号码或邮箱").removeClass("hide");
	} else {
		// 倒计时
		register.countdown(60);
		
		// 发送验证码
		$.ajax({
			type : "POST",
			url : register.SEND_AUTH_CODE_URL,
			data : "accept=" + acceptVal,
			dataType : "json",
			success : function(data) {
				// 如果发送成功
				plus.msgDlg("操作提示", data.actionDealMsg, "sm");
			}
		});
	}
};

/**
 * 倒计时
 */
register.countdown = function(count) {
	if (count == 0) {
		$("a[href='javascript:register.getAuthCode()']").attr("disabled", false).text("获取验证码");
	} else {
		$("a[href='javascript:register.getAuthCode()']").attr("disabled", true).text("重新获取（" + count-- + "）");
		
		// 计时
		setTimeout(function() {
			register.countdown(count);
		}, 1000);
	}
};

/**
 * 执行注册
 */
register.deal = function() {
	var registerForm = $("#" + register.FORM_ID);
	registerForm.attr("action", register.DEAL_URL).submit();
	
	// 如果校验通过
	if (registerForm.valid()) {
		$("button[onclick='register.deal()']").attr("onclick", "").text("提交中...");
	}
};