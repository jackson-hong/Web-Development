package com.data.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShareDataServlet
 */
@WebServlet("/shareData.do")
public class ShareDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//각 공유객체에 값 대입하기
		//1. request 객체에 값 대입하기
		request.setAttribute("request", "requestdata");
		
		//2. session 객체에 값 대입하기
		HttpSession session = request.getSession();
		session.setAttribute("session", "sessiondata");
		
		//3. context 객체에 값 대입하기
		ServletContext context = request.getServletContext();
		context.setAttribute("context", "contextdata");
		
		//각 데이터를 출력해주는 sevlet으로 이동하기
//		RequestDispatcher rd = request.getRequestDispatcher("userData.do");
//		rd.forward(request, response);
		
		//sendRedirect로 전환
		//contextroot -> request객체에서 받아올 수 있음
		//request.getContextPath
		response.sendRedirect(request.getContextPath()+"/userData.do");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
