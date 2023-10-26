<%@page import="com.shinhan.dto.EmpVO"%>
<%@page import="com.shinhan.model.EmpDAO"%>
<%@page import="com.shinhan.dto.JobVO"%>
<%@page import="com.shinhan.model.JobDAO"%>
<%@page import="com.shinhan.dto.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.model.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 EmpVO empvo = (EmpVO)request.getAttribute("emp");
 List<DeptVO> dlist = ( List<DeptVO>)request.getAttribute("dlist");
 List<JobVO> jlist = (List<JobVO>)request.getAttribute("jlist");
 List<EmpVO> mlist = (List<EmpVO>)request.getAttribute("mlist");

 %>  
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- bootstrap : 세계적으로 가장 유명한 css framework -->
	<!-- CDN(Content Delivery Network) -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	<style>
	  @import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
	  #container{
	     border : 1px solid gray;
	     width : 80%;
	     margin: 0 auto;
	     background: url("../html5-css3-master/07/images/bg1.png");
	     background-repeat: repeat-x;
	     background-position: bottom;
	     font-family: 'Jeju Gothic', sans-serif;
	  }
	  h1 { text-align: center;}
	  input:focus { background-color: yellow;}
	   
	fieldset {
	  /* top right bottom left   */
	  margin: 20px;
	  border : 5px dotted green;
	  padding: 6px;
	}
	
	
	</style>
</head>

<body>
    <div id="container">
	<h1>~상세보기~</h1>
	<form name="empform" action="empDetail.do" method="post">
		<fieldset>
			<legend>직원의 기본사항</legend>
			1.EMPLOYEE_ID: 
			<input name="employee_id" type="number" 
			value="${emp.employee_id}"
			 autofocus /> <br><br>
			2.FIRST_NAME: 
			<input name="first_name" type="text" 
			value="${emp.first_name}" /> <br><br>
			3.LAST_NAME: 
			<input name="last_name" 
			value="${emp.last_name}"
			type="text"   /> <br><br>
		</fieldset>	
		<fieldset>
			<legend>직원의 추가정보</legend>	
			4.EMAIL: 
			<input name="email" type="text" 
			value="${emp.email}" /> <br><br>
			5.PHONE_NUMBER: <input name="phone_number" 
			type="tel" pattern="[0-9]{3}.[0-9]{3}.[0-9]{4}"
			value="${emp.phone_number }" /> <br><br>
			6.HIRE_DATE: 
			<input name="hire_date" 
			type="date"  value="${emp.hire_date}"/> <br><br>
			7.JOB_ID선택: <select name="job_id">
				<%for(JobVO job:jlist){
				%>
				  <option 
				   <%=empvo.getJob_id()==job.getJob_id()?"selected":"" %>
				  value="<%=job.getJob_id()%>">
				        <%=job.getJob_title() %>,
				        <%=job.getMax_salary() %>,
				        
				  </option>
				   
				<%} %>
			</select> <br><br>
			8.SALARY: <input name="salary" type="number" 
			value="${emp.salary}" /> 
			<br><br>
			9.COMMISSION_PCT: 
			<input name="commission_pct"
			 type="number" step="0.01" 
			 value="${emp.commission_pct}"
			 /> <br><br>
			10.MANAGER_ID:		
			<select name="manager_id" >
				<%for(EmpVO emp:mlist){
				%>
				  <option 
				  <%=empvo.getManager_id()==emp.getManager_id()?"selected":"" %>
				  value="<%=emp.getEmployee_id()%>">
				        <%=emp.getFirst_name() %>
				        <%=emp.getLast_name() %>
				        
				  </option>
				<%} %>
			</select>
			
			
			<br><br>
			11.DEPARTMENT_ID: <select name="department_id">
				<%for(DeptVO dept:dlist){
				%>
				  <option 
				  <%=empvo.getDepartment_id()==dept.getDepartment_id()?"selected":"" %>
				  value="<%=dept.getDepartment_id()%>">
				        <%=dept.getDepartment_name() %>
				  </option>
				<%} %>
			</select> <br><br>

			<input class="btn btn-success" type="submit" value="수정하기♥" />
			<input type="reset" class="btn btn-success" value="Reset Button">
		</fieldset>
	</form>
	</div>
</body>

</html>