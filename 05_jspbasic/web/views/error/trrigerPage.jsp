<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		int num = 0;
		int num2 = 10;
	%>
	<h1>에러 발생 페이지</h1>
	<p>결과 : <%= num2/num %></p>
</body>
</html>