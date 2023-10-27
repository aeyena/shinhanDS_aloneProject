<%@page import="com.shinhan.model.DeptService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shinhan.dto.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
DeptVO dept = new DeptVO(10, "개발부", 100, 1700);
request.setAttribute("deptInfo", dept);

List<String> week = new ArrayList<>();
week.add("월요일");
week.add("화요일");
week.add("금요일");
week.add("토요일");
week.add("토요일");
pageContext.setAttribute("weekInfo", week);

DeptService dservice = new DeptService();
List<DeptVO> dlist = dservice.selectAll();
pageContext.setAttribute("dlistInfo", dlist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
8. pageScope: ${pageScope.phone}<br>
9. requestScope: ${requestScope.phone}<br>
10. sessionScope: ${sessionScope.phone}<br>
11. applicationScope: ${applicationScope.phone}<br>
12. 누굴까? pageScope>requestScope>sessionScope>applicationScope : ${phone}
</pre>
	<hr>
	<pre>
1.param: ${param.userid}
2.paramValues: ${paramValues.product[0]}
3.paramValues: ${paramValues.product[1]}
4.빈얻기 getAttribute()...toString()호출: ${deptInfo}
5.빈얻기 getAttribute()...getter()호출: ${deptInfo.department_name}
6.List정보얻기: 
	${weekInfo[0]}
	${weekInfo[1]}
	${weekInfo[2]}
	${weekInfo[3]}
	${weekInfo[4]}
	${weekInfo[5]}
	
</pre>
	<ul>
		<c:forEach items="${dlistInfo}" var="w">
			<li>${w}</li>
		</c:forEach>
	</ul>
</body>
</html>