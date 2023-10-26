<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Animated Login Form</title>
<link href="../css/login.css" rel="stylesheet"></link>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<img class="wave"
		src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
	<div class="container">
		<div class="img">
			<img
				src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
		</div>
		<div class="login-content">
			<form action="businessmanLogin.do" method="post">
				<img
					src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/avatar.svg">
				<h2 class="title">Welcome</h2>
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>Username</h5>
						<input type="text" class="input" name="businessmanID">
					</div>
				</div>
				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>Password</h5>
						<input type="password" class="input" name="businessmanPW">
					</div>
				</div>
				<a href="#">Forgot Password?</a> 
				<input type="submit" class="btn" value="Login">
			</form>
		</div>
	</div>
	<script src="../js/login.js"></script>
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<script>
	var message = "${loginResult}";
	if(message != "") alert(message);
	</script>
</body>

</html>