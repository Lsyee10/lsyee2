<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>最新上传-发现-快拍快拍</title>
</head>
<body>
    <section class="container">
        <header class="title">
            <h2>最新上传</h2>
            <nav class="sm">
                <a href="/works/photo/newest.action?scope=all">全部照片(<s:property value="#request.totalNum"/>)</a>
                <a href="/works/photo/newest.action?scope=today">今日上传(<s:property value="#request.todayNum"/>)</a>
            </nav>
        </header>
        <!-- 列表开始 -->
        <s:if test="null!=#request.photoPagin&&#request.photoPagin.totalRows>0">
	        <ul class="avg-sm-2 avg-md-4 avg-lg-4 thumbnails auto">
	        	<s:iterator value="#request.photoPagin.curPageList" status="st">
	        		<li>
		                <a href="/works/photo/detail.action?photoId=<s:property value='photoId'/>" target="_blank" class="img">
		                <img src="/img/www/grey.png" data-original="<s:property value='img4'/>">
		                </a>
		                <div class="caption">
		                    <p class="title">
		                    	<a href="/works/photo/detail.action?photoId=<s:property value='photoId'/>" target="_blank">
		                    		<s:property value='intro' escape="false"/>
		                    	</a><s:if test="null == intro||'' == intro">&nbsp;</s:if>
		                    </p>
		                    <p>
		                    	<a href="/user/his/works.action?userId=<s:property value='userId'/>" target="_blank">
		                    		@<s:property value='nickname'/>
		                    	</a>
		                    </p>
		                </div>
		            </li>
	      	  	</s:iterator>
	        </ul>
        </s:if>
        <!-- 列表结束 -->
    </section>
    <!-- 底部开始 -->
     <nav>
        <s:set value="#request.photoPagin.curPage" name="curPage"/>
   	  	<s:set value="#request.photoPagin.totalPages" name="totalPages"/>
      	<s:include value="/jsp/www/pagin.jsp">
      	<s:param name="pageLink">newest.action?scope=<s:property value='scope'/></s:param>
      	<s:param name="anchor"></s:param>
      	<s:param name="curPage"><s:property value='#curPage'/></s:param>
     	<s:param name="totalPages"><s:property value='#totalPages'/></s:param>
    	</s:include>
    </nav>
</body>
</html>
