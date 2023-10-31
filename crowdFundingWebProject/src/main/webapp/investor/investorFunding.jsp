<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/funding.css" rel="stylesheet"></link>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>신한DS CrowdFunding</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
		<div class="container-fluid">
			<a href="../index.jsp" class="navbar-brand">신한DS CF</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">

					<li class="nav-item"><a class="nav-link"
						href="investorPage.do">상품조회</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="investorFunding.do">펀딩하기</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button" aria-haspopup="true" aria-expanded="false">마이페이지</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="investorMypage.do">나의펀딩상품조회</a> 
							<a class="dropdown-item" href="investorBalance.do">포인트</a>
						</div></li>
				</ul>
				<a class="nav-link" id="logout-a" href="investorLogout.do"> <img
					src="../images/logout.png" /> 로그아웃
				</a>
			</div>
		</div>
	</nav>

	<div id="page-div1">
		<div id="page-div2">상품목록</div>

		<button id="btn-div" type="button" class="btn btn-info"
			data-bs-toggle="modal" data-bs-target="#myModal">상품펀딩하기</button>
		<form class="d-flex" action="investorFunding.do" method="post">
			<input class="form-control me-sm-2" type="search" name="search"
				placeholder="상품이름으로 검색">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
		</form>

		<table class="table table-hover" id="page-table">
			<thead>
				<tr class="table-info">
					<th>상품번호</th>
					<th>상품이름</th>
					<th>상품정보</th>
					<th>목표금액</th>
					<th>모인금액</th>
					<th>퍼센트</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ilist}" var="item">
					<tr>
						<td>${item.itemID}</td>
						<td id="itemName">${item.itemName}</td>
						<td id="itemInfo">${item.itemInfo}</td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.targetAmount}" /></td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.collectedAmount}" /></td>
						<td><fmt:formatNumber groupingUsed="true"
								value="${item.percentage}" type="percent" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상품펀딩</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<form id="funding-form" action="itemFunding.do" method="post">
						<label>상품번호</label> <input type="number" name="itemID"
							class="form-control" id="funding-input1"> <label>펀딩금액</label>
						<input type="number" name="investmentAmount"
							class="form-control me-sm-2" id="funding-input2">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="funding-btn">펀딩</button>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	<script>
	var message = "${fundingResult}";
	if(message != "") alert(message);
	
	document.querySelector("#funding-btn").addEventListener("click",function(){
		document.querySelector("#funding-form").submit();
	})
	</script>
</body>
</html>