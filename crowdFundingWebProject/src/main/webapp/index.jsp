<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session.setAttribute("loginResult","");
%>
 
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Animated Login Form</title>
	<link href="css/role.css" rel="stylesheet"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<img class="wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
	<h1>Welcome</h1>
	<button id="businessman"><img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/avatar.svg">사업가</button>
	<button id="investor"><img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/avatar.svg">투자자</button>
	
	<script src="js/role.js"></script>
</body>

</html>