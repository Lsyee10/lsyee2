// 个人资料
profile = {
	MODIFY_FORM_ID : "prepProfile",
	MODIFY_PROFILE_URL : "/user/my/setting/profileModify.action",
	MODIFY_WALL_URL : "/user/my/setting/wallModifyAsync.action"
};

/**
 * 准备修改
 */
profile.prepModify = function(){
    //表单校验
    $("#"+profile.MODIFY_FORM_ID).validate({
		rules : {
			nickname : {
				required : true,
				maxlength: 10
			},
			intro: {
	            rangelength: [5, 50]
	        },
	        city: {
	            maxlength: 10
	        }
		}
	});
    
    // 保存按钮回车事件
    $("#"+profile.MODIFY_FORM_ID).bind("keyup", function(e) {
    	if (e.keyCode == 13) {
    		profile.dealModify();
		}
    });
    
};

/**
 * 处理修改
 */
profile.dealModify = function(){
	var form = $("#" + profile.MODIFY_FORM_ID);
	form.attr("action", profile.MODIFY_PROFILE_URL).submit();
	
	// 如果校验通过
	if (form.valid()) {
		$(".btn").attr("onclick", "javascript:void(0)").text("提交中...");
	}
};

/**
 * 准备编辑 
 */
profile.modifyWall = function(sessionId) {
	//初始化上传控件
	$("#wall_image").uploadify({
		multi : false,
		width : '112',
		height : '40',
		buttonClass : "border:0;",
		cancelImg : '/js/lib/jquery/uploadify/cancel.png',
		buttonImage : '/img/www/select-photo-min.png',
		swf : '/js/lib/jquery/uploadify/uploadify.swf',
		uploader : profile.MODIFY_WALL_URL+";jsessionid="+sessionId,
		formData : {sessionId:sessionId},
		fileObjName : 'image',
		fileSizeLimit : '3MB',
		fileTypeDesc : 'jpg;gif;jpeg;png',
		fileTypeExts : '*.jpg;*.gif;*.jpeg;*.png',
		queueID : 'queue',
		queueSizeLimit : 1,
		overrideEvents: ['onSelect', 'onSelectError', 'onDialogClose', 'onUploadError'],
		onDialogClose  : function(queueData) {
			//如果有选择图片
			if(queueData.filesSelected==0){
        		 $("p.help").text("请选择照片。").attr("class", "help error");
			}else{
				$("p.help").text("").attr("class", "help hide");
			}
        },
        onSelectError: function (file, errorCode, errorMsg) {
        	//拦截各类异常
            switch (errorCode) {
                case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
                   $("p.help").text("一次最多上传"+this.settings.queueSizeLimit+"张照片。").attr("class", "help error");
                   break;
                case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
                   $("p.help").text(file.name + "的大小超过了"+this.settings.fileSizeLimit+"的限制。").attr("class", "help error");
                   break;
                case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
                   $("p.help").text(file.name + "的大小异常。").attr("class", "help error");
                   break;
                case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
                   $("p.help").text(file.name + "的类型不正确。").attr("class", "help error");
                   break;
            }
         },
        onFallback: function () {
        	//检测FLASH失败调用 
             alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
        },
        onSelect: function(file) {
        	 // 添加预览项及进度
            $("div.load").append(
            	"<div class='caption form-group text-middle'>" +
            	"<div class='progress'><span class='progress-bar' style='width:0%;'></span><p>" +file.name + "（" + Math.round(file.size / (1024 * 1024)) + "MB）<strong>0%</strong></p></div><div>");
        },
        onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
            var progress = parseInt(bytesUploaded / bytesTotal * 100, 10);
            $("div.load").find("span.progress-bar").css("width", progress + "%");
            $("div.load").find(".progress").find("strong").text(progress + "%");
        },
        onUploadSuccess : function(file, data, response) {
        	window.location.reload();
        },
		onUploadError : function(file, errorCode, errorMsg, errorString) {
			$("p.help").text("出错了！请重新上传。").attr("class", "help error");
			$("div.load").html("");
		}
	});
};

