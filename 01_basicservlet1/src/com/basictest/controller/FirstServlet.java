package com.basictest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//일반 클래스를 서블릿 클래스로 만들기
//서블릿 규약을 준수하면 된다
//1. HttpServlet 클래스를 상속받는다.(javax.servlet.http.HttpServlet)
//2. doGet(), doPost() 메소드를 재구현 
//-> 이 두개의 메소드는 ServletException 처리를 해준다.

//서버에서 서블릿이 실행 되려면??
//1. 서블릿을 작성한다.
//2. web.xml에 작성한 서블릿을 등록해줌.
//3. 등록한 서블릿에 url 주소를 맵핑해준다.
public class FirstServlet extends HttpServlet{
	//일반 클래스가 아닌 서블릿 클래스가 된 것
	//서버에서 사용자의 요청에 대한 응답을 처리하는 클래스
	//서블릿 클래스는 서버 설정에 따라 서버 container가 생성(new 클래스())해서 관리함
	
	public FirstServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청한 서비스를 응답할 로직을 구성해주면 됨!!
		
		PrintWriter pw = resp.getWriter();
		
		//응답페이지를 작성해서 보내면 브라우져가 띄워줌
		resp.setContentType("text/html; charset=uft-8");
		
		
		pw.println("<p>JACKSON</p>");
		
		System.out.println("JACKSONHONG");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("JACKSONHONG");
	}
}
