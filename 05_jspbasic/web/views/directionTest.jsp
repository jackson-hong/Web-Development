<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지시자 활용하기</title>
</head>
<%
	Date today = new Date();
	ArrayList list = new ArrayList();
	list.add("jackson");
	list.add("bs");
	list.add("hwan");
	list.add("patrick");
%>
<body>
		<h2>오늘 정보</h2>
		<p>오늘은 : <%= today %> 입니다</p>
		<h2>학생정보</h2>
		<ul>
			<% for(int i = 0; i < list.size(); i++){%>
				<li><%= list.get(i) %></li><%
			}%>
		</ul>
</body>
</html>