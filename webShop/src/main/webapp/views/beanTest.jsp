<%@page import="com.shinhan.dto.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
DeptVO dept = new DeptVO();
dept.setDepartment_id(100);
dept.setDepartment_name("개발부");
%>
</head>
<body>
<h1>JSP의 자바빈</h1>


	<jsp:useBean id="dept2" class="com.shinhan.dto.DeptVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="dept2"/>
	
	<%-- 
	<jsp:setProperty property="department_id" name="dept2" value="${param.department_id}" />
	<jsp:setProperty property="department_name" name="dept2" value="${param.department_name}" />
	<jsp:setProperty property="location_id" name="dept2" value="${param.location_id}" />
	<jsp:setProperty property="manager_id" name="dept2" value="${param.manager_id}" />
	--%>
	
	<jsp:forward page="beanTest2.jsp"></jsp:forward>
	
	<h1>자바코드</h1>
	<%=dept.getDepartment_id() %><br>
	<%=dept.getDepartment_name() %>
</body>
</html>