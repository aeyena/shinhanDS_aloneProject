<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신한DS CrowdFunding</title>
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/join.css" rel="stylesheet"></link>
</head>
<body>
<div id="join-div">
		<form action="investorJoin.do" method="post">
			<fieldset>
				<legend id="join-legend">회원가입</legend>		
				<div class="form-group">
					<label class="form-label mt-4">아이디</label>
					<input type="text" name="investorID" class="form-control">
				</div>
				<div class="form-group">
					<label class="form-label mt-4">비밀번호</label>
					<input type="password" name="investorPW" class="form-control">
				</div>				
				<div class="form-group">
					<label class="form-label mt-4">이름</label> 
					<input type="text" name="investorName" class="form-control">
				</div>
				<button class="btn btn-info" id="join-button">회원가입하기</button>
			</fieldset>
		</form>
	</div>


	
	<script>
		var message = "${joinResult}";
		if (message != "")
			alert(message);
	</script>
</body>
</html>