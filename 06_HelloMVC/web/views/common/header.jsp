<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>
<%@ page import="com.kh.common.listener.LoginCheckListener"%>
<%
	/* request 객체에서 값 가져오기 */
Member logginedMember = (Member) session.getAttribute("logginedMember");
int connectCount = LoginCheckListener.getConnectCount();
//쿠키값 받아오기!
Cookie[] cookies = request.getCookies();
String saveId = null;
if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("saveId")) {
	saveId = c.getValue();
	break;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloMVC</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<header>
		<h1>Hello MVC</h1>
		<div class="login-container">
			<%
				if (logginedMember == null) {
			%>
			<form id="loginFrm" action="<%=request.getContextPath()%>/login"
				method="post">
				<table>
					<tr>
						<td><input type="text" name="userId" id="userId"
							placeholder="아이디" value="<%=saveId != null ? saveId : ""%>">
						</td>
						<td></td>
					</tr>
					<tr>
						<td><input type="password" name="password" id="password"
							placeholder="비밀번호"></td>
						<td><input type="submit" value="로그인"
							onclick="return fn_login_validate();"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="checkbox" name="saveId"
							id="saveId" <%=saveId != null ? "checked" : ""%>> <label
							for="saveId">아이디저장</label> <input type="button" value="회원가입"
							onclick="location.replace('<%=request.getContextPath()%>/enrollMember')">
						</td>
					</tr>
				</table>
			</form>
			<%
				} else {
			%>
			<table id="logged-in">
				<tr>
					<td colspan="2"><%=logginedMember.getUserName()%>님, 안녕하세요 <span><small>접속자수
								: <%=connectCount%></small></span></td>
				</tr>
				<tr>
					<td>
						<!-- 쿼리스트링방식으로 데이터를 전송하고 확인하기 --> <input type="button"
						value="내정보보기"
						onclick="location.href='<%=request.getContextPath()%>/memberView?userId=<%=logginedMember.getUserId()%>'">
					</td>
					<td><input type="button" value="로그아웃"
						<%-- onclick="location.replace('<%=request.getContextPath()%>/logout');"> --%>
						onclick="logout();">
					</td>
				</tr>
			</table>
			<%
				}
			%>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="#">Home</a></li>
				<li id="notice"><a href="<%=request.getContextPath()%>/notice/noticeList">공지사항</a></li>
				<li id="board"><a href="<%= request.getContextPath()%>/board/boardList">게시판</a></li>
				<!-- 관리자페이지에 대한 nab를 설정 -->
				<% if(logginedMember != null && logginedMember.getUserId().equals("admin")){ %>
				<li id="admin-member"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
				<% } %>
			</ul>
		</nav>
	</header>
	<script>
		function fn_login_validate() {
			let id = $("#userId").val();
			let password = $("#password").val();

			//아이다가 4글자 미만이면 재입력
			if (id.trim().length < 4) {
				alert("아이디는 4글자 이상 입력하세요");
				$("#userId").focus();
				return false;
			}
			//패스워드를 입력하지 않으면 안됨
			if (password.trim().length == 0) {
				alert("비밀번호를 입력하세요");
				$("#password").focus();
				return false;
			}
		}
		function logout(){
			location.replace("<%=request.getContextPath()%>/logout");
		}
	</script>