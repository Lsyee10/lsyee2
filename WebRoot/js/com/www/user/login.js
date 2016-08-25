login = {
	FROM_ID : "prep",
	CHECK_IMG_URL : "/authImg.img",
	DEAL_URL : "/user/io/login/deal.action",
};

/**
 * 登录准备
 */
login.prep = function() {
	// 点击更新验证码图片
	$("img.m-l-1").click(function() {
		$(this).prop("src", login.CHECK_IMG_URL + "?now=" + new Date());
	});

	// 表单校验
	
	$("#" + login.FROM_ID).validate({
		rules : {
			username : "required",
			password : "required",
			authCode : {
				required : true,
				isAuthCode : true
			}
		}
	});

	// 登录按钮回车事件
	$("#"+login.FROM_ID).bind("keyup change", function(e) {
		if (e.keyCode == 13) {
			login.deal();
		}
	});
};

/**
 * 登录处理
 */
login.deal = function() {
	var loginForm = $("#" + login.FROM_ID);
	loginForm.attr("action", login.DEAL_URL).submit();

	// 如果校验通过
	if (loginForm.valid()) {
		$("button[onclick='login.deal()']").attr("onclick", "javascript:void(0)").text("登录中...");
	}
};
