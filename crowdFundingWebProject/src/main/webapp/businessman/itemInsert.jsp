<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="businessmanInsert.do" method="post">
		상품이름:<textarea name="itemName"></textarea><br> 
		상품정보:<textarea name="itemInfo"></textarea>	<br> 
		목표금액:<input type="number" name="targetAmount"><br>
		<input type="submit" value="상품정보등록">
	</form>
</body>
</html>