<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품정보수정</h1>
<form action="businessmanUpdate.do" method="post">
	<fieldset>
		<legend>상품기본사항</legend>
		1.상품이름: <textarea name="itemName">${item.itemName}</textarea><br>
		2.상품정보: <textarea name="itemInfo">${item.itemInfo}</textarea><br>
		3.목표금액: <input type="number" name="targetAmount" value="${item.targetAmount}" readonly><br>
		4.모인금액: <input type="number" name="collectedAmount" value="${item.collectedAmount}" readonly><br>
		5.퍼센트: <input type="number" name="percentage" value="${item.percentage}" readonly>
	</fieldset>
	<input type="submit" value="수정완료">
</form>
</body>
</html>