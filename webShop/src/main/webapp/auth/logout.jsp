<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="appPath" scope="application" value="${pageContext.request.servletContext.contextPath}"/>


<img src="${appPath}/static/image/mymelody.jpg" width=100 height=100/>
<br>
<a href="${appPath}/auth/logout.do">로그아웃</a>
<p>${empInfo==null?"손님":empInfo.first_name}님환영합니다</p>

<c:if test="${empInfo==null}">
	<p>고객님 로그인은 필수입니다.</p>
</c:if>
<c:if test="${empInfo!=null}">
	<p>${empInfo.first_name}님 반갑습니다</p>
</c:if>
<hr>

<!-- HTML주석 -->
<%-- JSP주석 ${안녕} --%>
<%
//자바주석
%>