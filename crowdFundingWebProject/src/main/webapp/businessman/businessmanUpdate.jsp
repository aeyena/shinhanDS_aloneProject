<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신한DS CrowdFunding</title>
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/bUpdate.css" rel="stylesheet"></link>
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
			<div class="navbar-collapse collapse show" id="navbarColor01"
				style="">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active"
						href="businessmanPage.do">상품조회</a></li>
					<li class="nav-item"><a class="nav-link"
						href="businessmanInsert.do">상품등록</a></li>
				</ul>
				<a class="nav-link" href="businessmanLogout.do" style="color:white;">
				<img src="../images/logout.png" style="width:25px;height:25px;"/> 로그아웃</a>	
			</div>
		</div>
	</nav>
	
	<div id="update-div">
		<form action="businessmanUpdate.do" method="post">
			<fieldset>
				<legend id="update-legend">상품수정</legend>
				<div class="form-group">
					<label class="form-label mt-4">상품번호</label> 
					<input type="number" class="form-control" name="itemID" value="${item.itemID}" readonly>
				</div>		
				<div class="form-group">
					<label class="form-label mt-4">상품이름</label>
					<textarea class="form-control" id="exampleTextarea" name="itemName">${item.itemName}</textarea>
				</div>
				<div class="form-group">
					<label class="form-label mt-4">상품정보</label>
					<textarea class="form-control" id="exampleTextarea" name="itemInfo">${item.itemInfo}</textarea>
				</div>				
				<div class="form-group">
					<label class="form-label mt-4">목표금액</label> 
					<input type="number" name="targetAmount" class="form-control" value="${item.targetAmount}" readonly>
				</div>
				<div class="form-group">
					<label class="form-label mt-4">모인금액</label> 
					 <input type="number" name="collectedAmount" class="form-control" value="${item.collectedAmount}" readonly>
				</div>
				<div class="form-group">
					<label class="form-label mt-4">퍼센트</label> 
					<input type="number" name="percentage" class="form-control" value="${item.percentage}" readonly>
				</div>
				<button class="btn btn-info" id="update-button">수정완료</button>
			</fieldset>
		</form>
	</div>

	<script>
		var message = "${updateResult}";
		if (message != "")
			alert(message);
	</script>
</body>
</html>
