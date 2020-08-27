<%@ page import="java.util.Arrays"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%!
	String id, pw;
	%>
	
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	
	id : <%= id %> <br>
	pw : <%= pw %>
	
</body>
</html>