<%@page import="com.shinhan.dto.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<EmpVO> mlist = (List<EmpVO>)request.getAttribute("mlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서입력</h1>
	<form action="../views/beanTest.jsp" method="get">
		부서번호: <input type="number" name="department_id"><br>
		부서이름: <input type="text" name="department_name"><br>
		매니저번호: <input type="text" name="manager_id"><br>
		지역번호: <input type="number" name="location_id"><br>
		<input type="submit" value="부서정보입력">
	</form>
</body>
</html>