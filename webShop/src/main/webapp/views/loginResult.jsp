<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	background-color: skyblue;
}
</style>
</head>
<body>
	<h1>Login결과: ${message}</h1>
	<h2>이메일:${param.email}</h2>
	<h2>이메일:<%=request.getParameter("email") %></h2>
	<h2>EL표기법: emp => ${empInfo}</h2>
	<h2>emp => <%=request.getAttribute("empInfo") %></h2>
		

</body>
</html>