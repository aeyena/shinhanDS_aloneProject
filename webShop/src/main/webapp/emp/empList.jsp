<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<EmpVO> emplist = (List<EmpVO>) request.getAttribute("emplist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=”viewport” content=”width=device-width, initial-scale=1”>

<title>Insert title here</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);

* {
	font-family: 'Hanna', sans-serif;
	margin: 0 auto;
}

table {
	border-collapse: collapse;
}

h1 {
	text-align: center;
	margin: 20px auto;
}

.title {
	background: Pink;
}

th {
	font-size: 20px;
	height: 25px;
	width: 100px;
}
/*
td{
	text-align: center;
	height: 20px;
}
*/
table td, th {
	padding: 10px;
}

table tr:hover td {
	background-color: #FFFFD7;
}

table tr td:hover {
	background-color: #FFFF9B;
}

/*직원이름이 'D'로 시작하면 글씨색을 red로*/
td[fname^='D'] {
	color: red;
}

/*tr의 seq속성의 값이 5로 끝나면 스타일 바꾸기*/
tr[seq$='5'] {
	background-color: lightgray;
}

/*data중에 짝수번째 row의 border스타일 변경*/
tbody tr:nth-child(even) {
	border: 2px dotted green;
}

tbody tr:nth-child(2n+1) {
	border: 2px dotted hotpink;
}

tbody tr:first-child, tbody tr:last-child {
	background-color: auqa;
}

p:only-child {
	font-size: 30px;
}

p:only-of-type {
	font-size: 30px;
}

#container h1::after {
	content: "***";
}

#container h1::before {
	content: "***";
}

tbody {
	counter-reset: mycount;
}

.aa::before {
	counter-increment: mycount;
	content: "[" counter(mycount) "]"
}

.hotpink {
	background-color: hotpink;
}

.yellow {
	background-color: yellow;
}

.white {
	background-color: white;
}
</style>
<script>
	window.onload = call;
	function call() {
		//onclick: 이벤트 속성
		//f1: 이벤트 핸들러, 이벤트 리스너
		document.querySelector("#search1").onclick = f1;
		document.querySelector("#search2").onclick = f2;
		document.querySelector("#search3").onclick = f3;
		document.querySelector("#reload").onclick = function() {
			location.reload();
		};
	}

	function f1() {
		var fname = document.querySelector("#fname").value.toLowerCase();
		var nodeList = document.querySelectorAll("tr td:nth-child(3)")
		nodeList.forEach(function(elt, index) {

			if (elt.textContent.toLowerCase().startsWith(fname)) {
				//console.log(elt, index);
				elt.className = "hotpink";
			} else {
				//elt.className = "white";
				elt.classList.remove("hotpink");

				//자리를 차지하지 않음
				//elt.parentNode.style.display = "none";

				//자리를 차지함
				elt.parentNode.style.visibility = "hidden";
			}
		});
	}

	function f2(event) {
		var event = event || window.event;
		for ( let prop in event) {
			console.log(prop, event[prop]);
		}

		var salary = document.querySelector("#salary").value;
		var nodeList = document.querySelectorAll("tr td:nth-child(7)");
		nodeList.forEach(function(elt, index) {
			if (Number(elt.textContent) >= salary) {
				elt.className = "yellow";
			} else {
				//elt.className = "white";
				elt.classList.remove("yellow");
			}
		});
	}

	function f3() {
		document.querySelector("#search2").onclick();
	}
</script>
</head>
<body>
	<a href="../auth/logout.do">로그아웃</a>
	<div>
		<input id="fname">
		<button id="search1">시작하는 이름찾기</button>
		<br> <input id="salary">
		<button id="search2">&gt;=급여찾기</button>
		<button id="search3">&gt;=급여찾기2</button>
		<br>
		<button id="reload">reset</button>
		<p>${empInfo.first_name}님환영합니다</p>
	</div>
	<!--  	
	<div>
		<h1>p가 1개인 경우</h1>
		<p>only</p>
	</div>
	-->
	<button onclick="location.href='empInsert.do';">신규직원등록</button>
	<div id="container">
		<h1>직원목록.....${sessionScope.company}</h1>
		<table border="1">
			<thead>
				<tr class="title">
					<th>순서</th>
					<th>직원번호</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>email</th>
					<th>phoneNumber</th>
					<th>salary</th>
					<th>job</th>
					<th>dept</th>
					<th>manager</th>
					<th>commission</th>
					<th>hiredate</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (EmpVO emp : emplist) {
					i++;
				%>

				<tr seq="<%=i%>">
					<td class="aa"><%=i%></td>
					<td><a href="empDetail.do?empid=<%=emp.getEmployee_id()%>">
							<%=emp.getEmployee_id()%>
					</a></td>
					<td fname="<%=emp.getFirst_name()%>"><%=emp.getFirst_name()%></td>
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getPhone_number()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getJob_id()%></td>
					<td><%=emp.getDepartment_id()%></td>
					<td><%=emp.getManager_id()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getHire_date()%></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>