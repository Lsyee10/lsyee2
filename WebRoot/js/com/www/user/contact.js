// 绑定设置
contact = {
	BIND_FORM_ID : "bind",
	SEND_AUTH_CODE_URL : "/user/my/setting/bindSendAuthCode.action",
	DEAL_BIND_URL : "/user/my/setting/bindModify.action"
};

//页面准备加载
contact.prepBind = function() {
	// 绑定信息校验
	$('#bind').validate({
		rules : {
			accept: {
                required: true
            },
			authCode : {
				required : true,
				minlength : 6,
				maxlength : 6
			}
		}
	});
};


/**
 * 获取验证码
 */
contact.getAuthCode = function() {
	var acceptNode = $("#bind_accept");
		acceptNode.prev().text("");
	var mobile = /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
	var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var acceptVal = acceptNode.val();
	
	// 如果为空
	if (acceptVal == "") {
		acceptNode.prev().text("手机或邮箱不能为空").addClass("error");
	} 
	// 如果格式不合法
	else if (!mobile.test(acceptVal) && !email.test(acceptVal)) {
		acceptNode.prev().text("请填写正确的手机号码或邮箱").removeClass("hide");
	} else {
		// 倒计时
		contact.countdown(60);
		
		// 发送验证码
		$.ajax({
			type : "POST",
			url : contact.SEND_AUTH_CODE_URL,
			data : "accept=" + acceptVal,
			dataType : "json",
			success : function(data) {
				plus.msgDlg("验证码", data.actionDealMsg, "sm");
			}
		});
	}
};

/**
 * 倒计时
 */
contact.countdown = function(count) {
	var node = $("button[onClick='javascript:contact.getAuthCode()']");
	if (count == 0) {
		node.attr("disabled", false);
		node.text("获取验证码");
	} else {
		node.attr("disabled", true);
		node.text("重新获取（" + count-- + "）");
		setTimeout(function() {
			contact.countdown(count);
		}, 1000);
	}
};


/**
 * 处理绑定
 */
contact.dealBind = function() {	
	// 如果有错误存在
	if ($("input.error").length > 0) {
		return;
	} else {
		// 防止二次提交
		$("button[onclick='contact.dealBind()']").attr("onclick","javascript:void(0)").text("提交中...");
		
		// 异步提交绑定
		var datas = $("#"+contact.BIND_FORM_ID).serializeObject();
		$.ajax({
			type:"post",
			url:contact.DEAL_BIND_URL,
			data:datas,
			dataType:'json', 
			success:function(data){
				plus.rfhDlg("绑定", data.actionDealMsg, "sm");
				setTimeout(function(){
					window.location.href = window.location.href;
					},500000); 
			}
		});
	}
};

