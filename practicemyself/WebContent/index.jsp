<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="NewFile1.jsp">
		<jsp:param name="id" value="abcdef"/>
		<jsp:param name="pw" value="12345"/>
	</jsp:forward>	
</body>
</html>