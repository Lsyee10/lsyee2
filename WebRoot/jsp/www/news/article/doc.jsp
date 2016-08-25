<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="zh-CN">
<head>
<title><s:property value="#request.articleView.title" /> - 快拍快拍</title>
</head>
<body>
	<article class="container jumbotron content-main">
            <!-- 正文开始 -->
            <header class="m-b-5">
                <h1><s:property value="#request.articleView.title" /></h1>
            </header>
            <section class="content">
            	<s:property value="#request.articleView.content" escape="false"/>
            </section>
            <!-- 正文结束 -->
      </article>
</body>
</html>
