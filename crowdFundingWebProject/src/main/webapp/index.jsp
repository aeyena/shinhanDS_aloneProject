<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session.setAttribute("loginResult","");
%>
 
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>신한DS CrowdFunding</title>
	<link href="css/role1.css" rel="stylesheet"></link>
	<link href="css/role2.css" rel="stylesheet"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<img class="wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
	
	<h1>역할 선택</h1>
	<div id="div-btn">
	<button id="businessman"><img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/avatar.svg"><div>사업가</div></button>
	<button id="investor"><img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/avatar.svg"><div>투자자</div></button>
	</div>
	
	<script src="js/role.js"></script>
	
</body>

</html>