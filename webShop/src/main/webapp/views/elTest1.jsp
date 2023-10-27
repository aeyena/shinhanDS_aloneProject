<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
pageContext.setAttribute("phone", "1234");
request.setAttribute("phone", "2222");
session.setAttribute("phone", "5555");
application.setAttribute("phone", "3333");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
<pre>
1. 정답은 ${1+2}입니다.
2. 문자랑 더하기 ${100 + "200"}
3. 비교연산자: ${10>20}
4. div: ${10 div 3}
5. mod: ${10 mod 3}
6. eq: ${10 == 3} 혹은 ${10 eq 100}
7. mod: ${10 mod 3}
8. pageScope: ${pageScope.phone}
9. requestScope: ${requestScope.phone}
10. sessionScope: ${sessionScope.phone}
11. applicationScope: ${applicationScope.phone}
12. 누굴까? pageScope>requestScope>sessionScope>applicationScope : ${phone}
<jsp:forward page="elTest2.jsp"></jsp:forward>
</pre>
</body>
</html>