package com.basictest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//어노테이션 servlet등록 밑 매핑처리하기

//@WebServlet(name = "second", urlPatterns="/second.do")
@WebServlet("/second.do")
public class SecondServlet extends HttpServlet {
	
	public SecondServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<h3>우왓 내가 진짜 혼자 만들었어</h3>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
