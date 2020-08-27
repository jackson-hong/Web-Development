package com.basictest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life.do")
public class LifeServlet extends HttpServlet{
	public LifeServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("서브릿 생성됨");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 메소드 실행");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 메소드 실행");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() : 방식이 post인지, get인지 확인 및 메소드 호출");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() 메소드 호출");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()메소드 실행");
	}
}
