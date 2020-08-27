package com.data.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/views/testPerson.do")
public class TestPersonServlet extends HttpServlet{

	public TestPersonServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String[] foods = req.getParameterValues("foods");
		String animal = req.getParameter("animals");
		
		System.out.println(name + " " + color + " " + foods + " " + animal);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
