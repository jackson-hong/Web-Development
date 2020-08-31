<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jsp.model.vo.Person" %>
<!-- header 페이지 구성하기
	한페이지의 위쪽부분 코드만 작성함
-->

<%
	Person p = new Person("Jackson", 25, "jason@naver.com");

	//session에 있는 값을 기준으로 로그인처리하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nopenopenope</title>
</head>
<body>
	<header>
		<div align="center">
			<div id="headTitle">
				<h1>WelcometoJackson'spage</h1>
			</div>
		</div>
		<% if(session.getAttribute("id")==null) {%>
		<div id="login">
			<form action="controller/login.jsp" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" id="id" placeholder="아이디입력"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="pw" id="pw" placeholder="패스워드입력"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<% }else { %>
		<h1> <%= session.getAttribute("id") %>님 환영합니다</h1>
		<% }%>
		<hr>
		<div id="mainMenu">
			<ul>
				<li><a href="info.do">공지사항</a></li>
				<li><a href="board.do">게시판</a></li>
				<li><a href="centents.do">내용</a></li>
				<li><a href="etc.do">기타</a></li>
			</ul>
		</div>
	</header>