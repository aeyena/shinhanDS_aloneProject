<%@page import="com.shinhan.dto.CrowdFundItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
List<CrowdFundItem> ilist = (List<CrowdFundItem>)request.getAttribute("ilist");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animated Login Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<p>${businessman.businessmanName}님 환영합니다</p>
<button onclick="location.href='#'">상품등록하기</button>
<p>나의상품조회</p>
	<table border="1">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품정보</th>
				<th>목표금액</th>
				<th>모인금액</th>
				<th>퍼센트</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%
		int i=0;
		for(CrowdFundItem item:ilist){
			i++;
		%>
		<tr>
			<td><%=item.getItemID()%></td>
			<td><%=item.getItemName()%></td>
			<td><%=item.getItemInfo()%></td>
			<td><%=item.getTargetAmount()%></td>
			<td><%=item.getCollectedAmount()%></td>
			<td><%=item.getPercentage()%></td>
			<td><button onclick="location.href='businessmanUpdate.do?itemid=<%=item.getItemID()%>';">수정</button></td>
			<td><button onclick="location.href='businessmanDelete.do?itemid=<%=item.getItemID()%>';">삭제</button></td>
		</tr>
		<%
		}
		%>
		</tbody>
	</table>
	<button onclick="location.href='businessmanLogout.do'">로그아웃</button>
</body>
</html>