<%@page import="com.shinhan.dto.CrowdFundItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신한DS CrowdFunding</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/home.css" rel="stylesheet"></link>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
		<div class="container-fluid">
			<a href="../index.jsp" class="navbar-brand">신한DS CF</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="true"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse show" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active"
						href="businessmanPage.do">상품조회</a></li>
					<li class="nav-item"><a class="nav-link"
						href="businessmanInsert.do">상품등록</a></li>
				</ul>
				<a class="nav-link" id="logout-a" href="businessmanLogout.do"> <img
					src="../images/logout.png" /> 로그아웃
				</a>
			</div>
		</div>
	</nav>
	<div id="page-div1">
		<div id="page-div2">상품조회</div>
		<table class="table table-hover">
			<thead>
				<tr class="table-info">
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
				<c:forEach items="${ilist}" var="item">
					<tr>
						<td>${item.itemID}</td>
						<td id="itemNameB">${item.itemName}</td>
						<td id="itemInfoB">${item.itemInfo}</td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.targetAmount}" /></td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.collectedAmount}" /></td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.percentage}" type="percent" /></td>
						<td><button class="btn btn-info"
								onclick="location.href='businessmanUpdate.do?itemid=${item.itemID}';">수정</button></td>
						<td><button class="btn btn-info"
								onclick="location.href='businessmanDelete.do?itemid=${item.itemID}';">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>