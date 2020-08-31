<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.signin.controller.SigninController"%>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="com.signin.model.vo.User" scope="page"/>
<jsp:setProperty name="user" property="memberId"/>
<jsp:setProperty name="user" property="memberPwd"/>
<jsp:setProperty name="user" property="memberName"/>
<jsp:setProperty name="user" property="gender"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	action page!
	<%
		PrintWriter script = response.getWriter();
		if(user.getMemberId() == null || user.getMemberPwd() == null || user.getMemberName() == null || user.getGender() == null){
			script.println("<script>");
			script.println("alert('회원 정보를 다 입력해주세요.')");
			script.println("history.back()");
			script.println("</script>");
		}else {
			SigninController sc = new SigninController();
			request.setAttribute("user", user);
	%>
	<jsp:forward page="/SigninController"></jsp:forward>
		<% }%>
</body>
</html>