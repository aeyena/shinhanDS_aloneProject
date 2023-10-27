<%@page import="com.shinhan.dto.EmpVO"%>
<%@page import="com.shinhan.dto.JobVO"%>
<%@page import="com.shinhan.dto.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<DeptVO> dlist = (List<DeptVO>)request.getAttribute("dlist");
List<JobVO> jlist = (List<JobVO>)request.getAttribute("jlist");
List<EmpVO> mlist = (List<EmpVO>)request.getAttribute("mlist");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap: 세계적으로 가장 유명한 css framework -->
<!-- CDN(Content Delivery Network) -->

<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);

#container {
	border: 1px solid gray;
	width: 80%;
	margin: 0 auto;
	font-family: 'Hanna', sans-serif;
}

h1 {
	text-align: center;
}

fieldset{
	margin: 20px;
	border: 5px dotted green;
	padding: 6px;
	background: url("../html5-css3-master/07/images/bg1.png");
	background-size: contain;
	
}

legend{
	text-align: center;
}

</style>
</head>

<body>
<%@ include file="../auth/logout.jsp" %>
	<div id="container">
		<h1>직원등록</h1>
		<form action="empInsert.do" method="post">
			<fieldset>
				<legend>직원의 기본사항</legend>
				1.employee_id: <input type="number" name="employee_id" required><br> 
				2.first_name: <input type="text" name="first_name"><br>
				3.last_name: <input type="text" name="last_name" required><br>
			</fieldset>
			<fieldset>
				<legend>직원의 추가정보</legend>
				4.email: <input type="text" name="email" required><br>
				5.phone_number: <input type="tel" name="phone_number" pattern="[0-9]{3}.[0-9]{3}.[0-9]{4}" required><br>
				6.hire_date: <input type="date" name="hire_date"><br>
				7.job_id: <select name="job_id">
					<%
					for (JobVO job : jlist) {
					%>
					<option value="<%=job.getJob_id()%>">
						<%=job.getJob_title()%>
					</option>
					<%
					}
					%>
				</select><br> 
				8.salary: <input type="number" name="salary"><br>
				9.commission_pct: <input type="number" step="0.01" name="commission_pct"><br> 
				10.manager_id: <select name="manager_id" class="form-select">
					<%
					for (EmpVO emp : mlist) {
					%>
					<option value="<%=emp.getEmployee_id()%>">
						<%=emp.getFirst_name()%>
						<%=emp.getLast_name()%>
					</option>
					<%
					}
					%>
				</select><br> 
				11.department_id: <select name="department_id">
					<%
					for (DeptVO dept : dlist) {
					%>
					<option value="<%=dept.getDepartment_id()%>">
						<%=dept.getDepartment_name()%>
					</option>
					<%
					}
					%>
				</select><br>
			</fieldset>
			<input class="btn btn-success" type="submit" value="등록하기">
			<input type="reset" class="btn btn-success">
		</form>
	</div>
</body>

</html>