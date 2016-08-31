avatar = {
	PERVIEW_W : 180,
	PERVIEW_H : 180,
	FORM_ID : "avatar",
	CUT_URL : "/user/my/setting/avatarCutting.action",
	UPLOAD_URL : "/user/my/setting/avatarUploadAsync.action"
};

/**
 * 准备编辑 
 */
avatar.upload = function(sessionId) {
	//初始化上传控件
	$("#"+avatar.FORM_ID+"_image").uploadify({
		multi : false,
		width : '112',
		height : '40',
		buttonClass : "border:0;",
		cancelImg : '/js/lib/jquery/uploadify/cancel.png',
		buttonImage : '/img/www/select-photo-min.png',
		swf : '/js/lib/jquery/uploadify/uploadify.swf',
		uploader : avatar.UPLOAD_URL+";jsessionid="+sessionId,
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
        	// 设置上传头像文件名称
        	var rst = eval("("+data+")");
        	$("#"+avatar.FORM_ID+"_imageFileName").val(rst.name);
        	
        	//隐藏上传按钮
        	$("div.col-right").find("p.btn").css("display","");
        	$("a[href='javascript:avatar.save()']").attr("disabled",false);
        	
        	// 载入头像
        	avatar.load(rst.path,rst.height,rst.width);
        },
		onUploadError : function(file, errorCode, errorMsg, errorString) {
			$("p.help").text("出错了！请重新上传。").attr("class", "help error");
		}
	});
};


/**
 * 像头载入动作
 * 
 * @param w
 * @param h
 * @param file
 */
avatar.load = function(file, h, w) {
	//记录高度和宽度
	avatar.PERVIEW_H = h;
	avatar.PERVIEW_W = w;
	
	//载入裁切图
	$("div.load").empty();
	$("div.load").append("<img src='"+file+"' id='cropbox'/>");
	
	//载入预览图
	$("div.preview-avatar").find("img").attr("src", file);
	
	$("#cropbox").Jcrop({
		onChange : avatar.preview,
		onSelect : avatar.updateCoords,
		setSelect : [ 0, 0, 180, 180]
	});
};

/**
 * 生成预览
 */
avatar.preview = function(coords) {
	if (parseInt(coords.w) > 0) {
		var rx = 100 / coords.w;
		var ry = 100 / coords.h;
		$($("div.preview-avatar").find("img")).css({
			width : Math.round(rx * avatar.PERVIEW_W) + "px",
			height : Math.round(ry * avatar.PERVIEW_H) + "px",
			marginLeft : '-' + Math.round(rx * coords.x) + "px",
			marginTop : '-' + Math.round(ry * coords.y) + "px"
		});
	}
};

/**
 * 更新坐标等参数
 * 
 * @param c
 */
avatar.updateCoords = function(c) {
	$("#"+avatar.FORM_ID+"_x").val(c.x);
	$("#"+avatar.FORM_ID+"_y").val(c.y);
	$("#"+avatar.FORM_ID+"_w").val(c.w);
	$("#"+avatar.FORM_ID+"_h").val(c.h);
};

/**
 * 裁切
 */
avatar.save = function() {
	if(""!=$("#"+avatar.FORM_ID+"_imageFileName").val()){
		$("a[href='javascript:avatar.save()']").text("保存中...").attr("href","javascript:void(0)");
		$.ajax({
			type : "POST",
			url : avatar.CUT_URL,
			data : $("#"+avatar.FORM_ID).serialize(),
			dataType : "json",
			success : function(data) {
				window.location.reload();
			}
		});
	}
};