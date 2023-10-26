<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Bootstrap Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

	<div class="container mt-3">
		<h2>Stacked form</h2>
		<form action="loginCheck.do" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Email:</label>
				<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
			</div>
			<!-- type="hidden" : document에 보이지 않는다 -->
			<input type="hidden" name="address" value="서울시마포구">
			<input type="hidden" name="phone" value="010-1234-5678">
			<div class="form-check mb-3">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox" name="remember"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script>
	var message = "${loginResult}";
	if(message != "") alert(message);
	</script>

</body>

</html>