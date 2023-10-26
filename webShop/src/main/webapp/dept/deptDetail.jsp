<%@page import="com.shinhan.dto.DeptVO"%>
<%@page import="com.shinhan.dto.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
List<EmpVO> mlist = (List<EmpVO>)request.getAttribute("mlist");
DeptVO dept = (DeptVO)request.getAttribute("dept");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서정보</h1>
	<!-- ${dept.department_id}==((DeptVO)request.getAttribute("dept")).getdepartment_id() -->
	<form action="deptUpdate.do" method="post">
		부서번호: <input type="number" name="department_id" value="${dept.department_id}" readonly="readonly"><br>
		부서이름: <input type="text" name="department_name" value="${dept.department_name}"><br>
		매니저번호: 		
		<select name="manager_id" class="form-select">
					<%
					for (EmpVO emp : mlist) {
					%>
					<option 
					<%=dept.getManager_id() == emp.getEmployee_id()?"selected":"" %>
					value="<%=emp.getEmployee_id()%>">
						<%=emp.getEmployee_id()%>
						<%=emp.getFirst_name()%>
						<%=emp.getLast_name()%>
					</option>
					<%
					}
					%>
				</select>
		<br>
		지역번호: <input type="number" name="location_id" value="${dept.location_id}"><br>
		<input type="submit" value="부서정보수정">
	</form>
</body>
</html>