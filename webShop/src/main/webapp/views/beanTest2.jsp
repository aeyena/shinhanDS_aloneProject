<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>두번째 페이지</h1>
	<jsp:useBean id="dept2" class="com.shinhan.dto.DeptVO" scope="request"></jsp:useBean>
	id: <jsp:getProperty property="department_id" name="dept2"/><br>
	name: <jsp:getProperty property="department_name" name="dept2"/><br>
	location_id: <jsp:getProperty property="location_id" name="dept2"/><br>
	manager_id: <jsp:getProperty property="manager_id" name="dept2"/><br>
	
</body>
</html>