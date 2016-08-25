<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="charset=utf-8" />
<title>错误提示</title>
</head>
	<body>
		<section class="container sm">
	        <div class="msg-box">
	            <div class="left">
	                <img src="/img/www/icon-error.png">
	            </div>
	            <div class="right">
	                <h1>对不起，出错了！</h1>
	                <p>你访问的页面可能不存在!</p>
	                <a href="/index.html" class="btn btn-primary">返回首页</a>
	            </div>
	        </div>
	    </section>
	</body>
</html>
