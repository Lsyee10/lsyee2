<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="charset=utf-8" />
<title>操作提示</title>
</head>
	<body>
		<section class="container sm">
	        <div class="msg-box">
	            <div class="left">
	                <img src="image/icon-success.png">
	            </div>
	            <div class="right">
	                <h1>恭喜，提交成功！</h1>
	                <a href="<s:property value='#request.url'/>" class="btn btn-primary">返回首页</a>
	            </div>
	        </div>
	    </section>
	</body>
</html>
