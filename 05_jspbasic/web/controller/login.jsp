<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* controller 책임이 jsp로도 가능함 */
	//파라미터 받아오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	System.out.println(id + " : " + pw);
	
	//로그인된 내용 세션에 저장하기
	session.setAttribute("id",id);
	
	//페이지 메인으로 전환하기
	response.sendRedirect("/05_jspbasic");
%>