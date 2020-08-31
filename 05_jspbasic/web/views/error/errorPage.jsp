<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러처리페이지</title>
</head>
<body>
	<h3>에러 발생 페이지</h3>
	<p>시스템적인 에러가 발생했습니다</p>
	<p><%= exception.getMessage() %></p>
	<a href="/05_jspbasic">메인화면으로 돌아가기</a>
</body>
</html>