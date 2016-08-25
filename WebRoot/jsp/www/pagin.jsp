<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="pagination pagination-centered">
 	<s:if test="#totalPages > 1">
	 	<s:if test="#curPage == 1">
	 		<li class="disabled"><a href="javascript:void(0)">«</a></li>
			<li class="active"><a href="${param.pageLink}&curPage=1${param.anchor}">1</a></li>
		</s:if>
		<s:else>
			<li><a href="${param.pageLink}&curPage=${param.curPage - 1}${param.anchor}">«</a></li>
			<li><a href="${param.pageLink}&curPage=1${param.anchor}">1</a></li>
		</s:else>
	 	<s:if test="#totalPages <= 7">
			<c:forEach var="i" begin="2" end="${totalPages}">
				<li <c:if test="${curPage == i}"> class="active"</c:if> ><a href="${param.pageLink}&curPage=${i}${param.anchor}">${i}</a></li>
			</c:forEach>
		</s:if>
		<s:elseif test="#curPage < 6">
			<c:forEach var="i" begin="2" end="7">
				<li <c:if test="${curPage == i}"> class="active"</c:if> ><a href="${param.pageLink}&curPage=${i}${param.anchor}">${i}</a></li>
			</c:forEach>
			<li>...</li>
		</s:elseif>
		<s:elseif test="#curPage + 2 < #totalPages">
			<li>...</li>
			<c:forEach var="i" begin="${curPage - 2}" end="${curPage + 2}">
				<li <c:if test="${curPage == i}"> class="active"</c:if> ><a href="${param.pageLink}&curPage=${i}${param.anchor}">${i}</a></li>
			</c:forEach>
			<li>...</li>
		</s:elseif>
		<s:else>
			<li>...</li>
			<c:forEach var="i" begin="${totalPages - 5}" end="${totalPages}">
				<li <c:if test="${curPage == i}"> class="active"</c:if> ><a href="${param.pageLink}&curPage=${i}${param.anchor}">${i}</a></li>
			</c:forEach>
		</s:else>
			
		<s:if test="#curPage < #totalPages">
			<li><a href="${param.pageLink}&curPage=${param.curPage + 1}${param.anchor}">»</a></li>
		</s:if>
		<s:else>
			<li class="disabled"><a href="javascript:void(0)">»</a></li>
		</s:else>
	</s:if>	
</ul>