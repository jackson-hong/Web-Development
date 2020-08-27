package com.data.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginGet.do")
public class LoginGetMethod extends HttpServlet{
	
	public LoginGetMethod() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get메소드 호출");
		//클라이언트가 보낸 데이터 가져오기
		//HttpServletRequest 객체의 getParameter() 메소드를 이용해서 보낸 값을 가져옴
		//getParameter("key값") : key => html input 태그의 name 속성의 값
		String id = req.getParameter("id");
		System.out.println(id);
		//password 받아서 출력해보세요
		String pw = req.getParameter("password");
		System.out.println("pw : " + pw);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post메소드 호출");
		//클라이언트가 보낸 데이터 확인
		//post 방식 일 때는 한글이 깨짐
		//client가 보낸 문자(한글)가 깨지는 걸 방지하기 위해
		//문자 인코딩을 처리해야함
		//setCharaterEncoding("인코딩값");메소드 이용
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		System.out.println(id + " : " + pw);
		
	}
}
