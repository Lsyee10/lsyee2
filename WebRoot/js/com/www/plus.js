/**
 * Project:xsee Copyright (c) Hang Zhou Daily Press Group All rights reserved
 * 
 * @author wu guang jing
 */
plus = {
};

/**
 * 阅读展现模式切换
 * 
 * @param dom
 */
plus.readMode = function() {
	$("span.nav-tabs a").click(function() {
        //高亮标签
        $(this).addClass("active").siblings().removeClass("active");
        
        //显示对应的内容块
        $("ul.tab-pane").eq($(this).index()).addClass("active").siblings().removeClass("active");
        
        // 修改分页展现模式参数
        if($(this).attr("title")=="网格模式"){
			$("ul.pagination a").each(function(){
				$(this).attr("href",$(this).attr("href").replace("mode=list","mode=grid"));
			});	        
        }else{
        	$("ul.pagination a").each(function(){
				$(this).attr("href",$(this).attr("href").replace("mode=grid","mode=list"));
			});
        }
        return false;
    });
};

/**
 * 放回顶部
 */
plus.backTop = function() {
	// 回顶部
	$(window).scroll(function() {
		if ($(window).scrollTop() > $(document.body).height() * 0.4) {
			$(".back-top").fadeIn(500);
		} else {
			$(".back-top").fadeOut(500);
		}
	});
	$(document).on("click", ".back-top", function() {
		$('html,body').animate({
			scrollTop : 0
		}, 500);
		return false;
	});
};

/**
 * 确认对话框
 * 
 * @param title
 * @param body
 * @param size 小号：sm 中号：md 大号：lg 全屏:auto
 * @param func
 */
plus.cfrmDlg = function(title, body, size, func) {
	var box = null;
	// 如果确认框已存在
	if($("#cfm-modal-box").length>0){
		box = $("#cfm-modal-box");
		box.attr("class","modal fade "+size);
		box.find("h4.modal-title").html(title);
		box.find("div.modal-body").html(body);
		box.find("button.cfrm").attr("onclick",func);
	}else{
		box = $("<div id='cfm-modal-box' class='modal fade "+size+"'>"+
				"<div class='modal-dialog'><div class='modal-content'>"+
				"<div class='modal-header'>" +
				"<span class='close' data-dismiss='modal' aria-hidden='true'></span>" +
				"<h4 class='modal-title'>"+title+"</h4></div>"+
				"<div class='modal-body'>"+body+"</div><div class='modal-footer'>"+
	            "<button type='button' class='btn btn-primary cfrm' data-dismiss='modal' onclick='"+func+"'>确定</button>"+
	            "<button type='button' class='btn btn-gray cancel' data-dismiss='modal'>取消</button></div>");
		$("body").append(box);
	}
	
	//打开
	box.modal("show");
};

/**
 * 消息对话框
 * 
 * @param title
 * @param body
 * @param size 小号：sm 中号：md 大号：lg 全屏:auto
 */
plus.msgDlg = function(title, body, size) {
	var box = null;
	// 如果确认框已存在
	if($("#msg-modal-box").length>0){
		box = $("#msg-modal-box");
		box.attr("class","modal fade "+size);
		box.find("h4.modal-title").html(title);
		box.find("div.modal-body").html(body);
	}else{
		box = $("<div id='msg-modal-box' class='modal fade "+size+"'>"+
				"<div class='modal-dialog'><div class='modal-content'>"+
				"<div class='modal-header'>" +
				"<span class='close' data-dismiss='modal' aria-hidden='true'></span>" +
				"<h4 class='modal-title'>"+title+"</h4></div>"+
				"<div class='modal-body'>"+body+"</div><div class='modal-footer'>"+
	            "<button type='button' class='btn btn-primary' data-dismiss='modal'>我知道了</button></div>");
		$("body").append(box);
	}
	
	//打开
	box.modal("show");
};

/**
 * 刷新对话框
 * 
 * @param title
 * @param body
 * @param size 小号：sm 中号：md 大号：lg 全屏:auto
 */
plus.rfhDlg = function(title, body, size) {
	var box = null;
	// 如果确认框已存在
	if($("#msg-modal-box").length>0){
		box = $("#msg-modal-box");
		box.attr("class","modal fade "+size);
		box.find("h4.modal-title").html(title);
		box.find("div.modal-body").html(body);
	}else{
		box = $("<div id='msg-modal-box' class='modal fade "+size+"'>"+
				"<div class='modal-dialog'><div class='modal-content'>"+
				"<div class='modal-header'>" +
				"<span class='close' data-dismiss='modal' aria-hidden='true'></span>" +
				"<h4 class='modal-title'>"+title+"</h4></div>"+
				"<div class='modal-body'>"+body+"</div><div class='modal-footer'>"+
	            "<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='window.location.reload()'>我知道了</button></div>");
		$("body").append(box);
	}
	
	//打开
	box.modal("show");
};


/**
 * 消息对话框
 * 
 * @param title
 * @param body
 * @param size 小号：sm 中号：md 大号：lg 全屏:auto
 * @param prepFunc
 * @param dealFunc
 */
plus.formDlg = function(title, url, size, prepFunc, dealFunc) {
	$.ajax({
 		url : url,
 		type : "GET",
 		dataType : "html",
 		success : function(data) {
 			var box = null;
 			
 			// 如果表单框已存在
 			if($("#form-modal-box").length>0){
 				box = $("#form-modal-box");
 				box.attr("class","modal fade "+size);
 				box.find("h4.modal-title").html(title);
 				box.find("div.modal-body").html(data);
 			}else{
 				box = $("<div id='form-modal-box' class='modal fade "+size+"'>"+
 						"<div class='modal-dialog'><div class='modal-content'>"+
 						"<div class='modal-header'>" +
 						"<span class='close' data-dismiss='modal' aria-hidden='true'></span>" +
 						"<h4 class='modal-title'>"+title+"</h4></div>"+
 						"<div class='modal-body'>"+data+"</div><div class='modal-footer'>"+
 						"<button type='button' class='btn btn-primary cfrm' data-dismiss='modal' onclick='"+dealFunc+"'>提交</button>"+
 						"<button type='button' class='btn btn-gray cancel' data-dismiss='modal'>取消</button></div>");
 				$("body").append(box);
 			}
 			
 			// 执行准备动作
 			eval(prepFunc);
 			
 			//打开
 			box.modal("show");
 		}
 	});
};