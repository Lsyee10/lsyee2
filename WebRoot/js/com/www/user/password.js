password = {
		FIND_FORM_ID : "prepFind",
		MODIFY_FORM_ID : "prepPassword",
		SEND_AUTH_CODE_SUCCESS : "发送成功",
		USERNAME_VALID_URL : "/user/io/password/validUsername.action",
		SEND_AUTHCODE_URL : "/user/io/password/sendAuthCode.action",
		FIND_DEAL_URL : "/user/io/password/dealFind.action",
		MODIFY_DEAL_URL : "/user/my/setting/passwordModify.action"
};

/**
 * 准备找回密码
 */
password.prepFind = function() {
	// 表单验证
	$("#" + password.FIND_FORM_ID).validate({
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
			newPassword : {
				required : true,
				rangelength : [ 6, 20 ]
			}
		}
	});
};

/**
 * 获取验证码
 */
password.getAuthCode = function() {
	var accept = $("#" + password.FIND_FORM_ID + "_accept");
	accept.prev().text("");
	
	// 校验发送的手机或邮箱
	var mobile = /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
	var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var acceptVal = accept.val();
	
	// 如果接收为空
	if (acceptVal == "") {
		accept.prev().text("手机或邮箱不能为空").addClass("error");
	} else if (!mobile.test(acceptVal) && !email.test(acceptVal)) {
		accept.prev().text("请填写正确的手机号码或邮箱").removeClass("hide");
	} else {
		// 倒计时
		password.countdown(60);
		
		// 发送验证码
		$.ajax({
			type : "POST",
			url : password.SEND_AUTHCODE_URL,
			data : "accept=" + acceptVal,
			dataType : "json",
			success : function(data) {
				// 如果发送成功
				if(password.SEND_AUTH_CODE_SUCCESS==data.actionDealMsg){
					accept.prev().text(data.actionDealMsg).removeClass("hide");
				}else{
					accept.prev().text(data.actionDealMsg).removeClass("hide").addClass("error");
				}
			}
		});
	}
};

/**
 * 倒计时
 */
password.countdown = function(count) {
	if (count == 0) {
		$("a[href='javascript:password.getAuthCode()']").attr("disabled", false).text("获取验证码");
	} else {
		$("a[href='javascript:password.getAuthCode()']").attr("disabled", true).text("重新获取（" + count-- + "）");
		
		// 计时
		setTimeout(function() {
			password.countdown(count);
		}, 1000);
	}
};

/**
 * 处理找回密码
 */
password.dealFind = function() {
	var passwordForm = $("#" + password.FIND_FORM_ID);
	passwordForm.attr("action", password.FIND_DEAL_URL).submit();
	
	// 如果校验通过
	if (passwordForm.valid()) {
		$("button[onclick='password.dealFind()']").attr("onclick", "javascript:void(0)").text("提交中...");
	}
};

/**
 * 准备修改密码
 */
password.prepModify = function() {
	// 表单验证
	$("#" + password.MODIFY_FORM_ID).validate({
		rules : {
			oldPassword : {
				required : true,
			},
			newPassword : {
				required : true,
				isPwd: true,
				rangelength : [6, 20]
			},
			cfmPassword : {
				required : true,
				isPwd: true,
				rangelength : [6, 20],
				equalTo : "#"+password.MODIFY_FORM_ID+"_newPassword"
			}
		}
	});
	
};

/**
 * 修改密码
 */
password.dealModify = function() {
	var passwordForm = $("#" + password.MODIFY_FORM_ID);
	passwordForm.attr("action", password.MODIFY_DEAL_URL).submit();
	
	// 如果校验通过
	if (passwordForm.valid()) {
		$("button.btn").attr("onclick", "javascript:void(0)").text("提交中...");
	}
};
