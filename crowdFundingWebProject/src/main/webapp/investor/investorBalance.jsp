<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/balance.css" rel="stylesheet"></link>
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
					<li class="nav-item"><a class="nav-link"
						href="investorFunding.do">펀딩하기</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle active" data-bs-toggle="dropdown"
						href="#" role="button" aria-haspopup="true" aria-expanded="false">마이페이지</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="investorMypage.do">나의펀딩상품조회</a> <a
								class="dropdown-item" href="investorBalance.do">포인트</a>
						</div></li>
				</ul>
				<a class="nav-link" id="logout-a" href="investorLogout.do"> <img
					src="../images/logout.png" /> 로그아웃
				</a>
			</div>
		</div>
	</nav>
	
	<div class="card border-info mb-3" id="balance-card">
		<div class="card-header" id="balance-div">ShinhanDS CF 포인트</div>
		<div class="card-body">
			<h4 class="card-title">${investor.investorName}님,</h4>
			<div id="balance-div2">
				<img id="balance-img" src="../images/point.png">
				<p class="card-text" id="balance-p">${investor.recharge}P</p>
			</div>
			<div id="balance-div3"><button type="button" class="btn btn-info"
			data-bs-toggle="modal" data-bs-target="#myModal">포인트 충전</button></div>
		</div>
	</div>
	
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">포인트 충전</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<form id="balance-form" action="investorBalance.do" method="post">
						<label>충전금액</label> <input type="number" name="recharge"
							class="form-control" id="balance-input"> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="balance-btn">충전</button>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
<script>
var message = "${balanceResult}";
if(message != "") alert(message);

document.querySelector("#balance-btn").addEventListener("click",function(){
	document.querySelector("#balance-form").submit();
})
</script>
</body>
</html>