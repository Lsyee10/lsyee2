// 个人资料
config = {
	EVENT_FROM_ID : "event",
	EVENT_MODIFY_URL : "/user/my/setting/eventModify.action",
};

/**
 * 处理设置
 */
config.eventModify = function() {	
	var form = $("#" + config.EVENT_FROM_ID);
	form.attr("action", config.EVENT_MODIFY_URL).submit();
	$(".btn").attr("onclick", "").text("提交中...");
};

