<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="charset=utf-8" />
<title>操作提示</title>
<script type="text/javascript">
    $(function () {
        //如果存在进度条，就使用进度条方式自动跳转，其中speed=10/3中3代表3秒
        if ($(".progress").length > 0) {
            var speed = 10 / 2,
            speed_num, setI = setInterval(function () {
                speed_num = Number($('.progress-bar').data('inset')) + Number(speed);
                $(".progress-bar").data('inset', speed_num).width(speed_num + "%");
                if (speed_num > 100) {
                    clearTimeout(setI);
                    window.location.href = $('.go-url').attr('href')
                }
            }, 100);
        }
    });
</script>
</head>
	<body>
		<section class="container sm">
        <div class="msg-box">
            <div class="left">
                <img src="/img/www/icon-success.png">
            </div>
            <div class="right">
                <h1>恭喜，提交成功！</h1>
                <div class="progress"><span class="progress-bar" style="width:0%;" data-inset="0"></span></div>
                <p>请稍等，如果您的浏览器不支持跳转，请点<a href="<s:property value='#request.url'/>" class="go-url">这里</a></p>
                <p><a href="<s:property value='#request.url'/>" class="btn btn-primary m">返回</a></p>
            </div>
        </div>
    </section>
	</body>
</html>
