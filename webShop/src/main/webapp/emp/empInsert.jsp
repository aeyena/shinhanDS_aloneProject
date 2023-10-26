<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원정보(DB저장할 예정)</h1>
	<p><%=request.getParameter("employee_id")%></p>
	<p><%=request.getParameter("first_name")%></p>
	<p><%=request.getParameter("last_name")%></p>
	<p><%=request.getParameter("email")%></p>
	<p><%=request.getParameter("phone_number")%></p>
	<p><%=request.getParameter("hire_date")%></p>
	<p><%=request.getParameter("job_id")%></p>
	<p><%=request.getParameter("salary")%></p>
	<p><%=request.getParameter("commission_pct")%></p>
	<p><%=request.getParameter("manager_id")%></p>
	<p><%=request.getParameter("department_id")%></p>
</body>
</html>