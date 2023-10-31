<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/join.css" rel="stylesheet"></link>
<title>신한DS CrowdFunding</title>
</head>
<body>
<div id="join-div">
		<form action="businessmanJoin.do" method="post">
			<fieldset>
				<legend id="join-legend">회원가입</legend>		
				<div class="form-group">
					<label class="form-label mt-4">아이디</label>
					<input type="text" name="businessmanID" class="form-control">
				</div>
				<div class="form-group">
					<label class="form-label mt-4">비밀번호</label>
					<input type="password" name="businessmanPW" class="form-control">
				</div>				
				<div class="form-group">
					<label class="form-label mt-4">이름</label> 
					<input type="text" name="businessmanName" class="form-control">
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