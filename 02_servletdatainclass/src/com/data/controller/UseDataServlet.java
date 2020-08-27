package com.data.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/userData.do")
public class UseDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체 있는 데이터 확인하기
		String requestData = (String)request.getAttribute("request");
		HttpSession session = request.getSession();
		String sessionData = (String)session.getAttribute("session");
		ServletContext context = request.getServletContext();
		String contextData = (String)context.getAttribute("context");
		
		//응답페이지 만들기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String html = "<html>";
		html += "<body>";
		html += "<h1>공유객체 데이터 확인</h1>";
		html += "<ul>";
		html += "<li>request data : " + requestData + "</li>";
		html += "<li>sessionData : " + sessionData + "</li>";
		html += "<li>contextData : " + contextData + "</li>";
		html += "</ul>";
		html += "<button onclick='location.href=\"" + request.getContextPath()+"/logout.do\"'>로그아웃</button>";
		html += "</body>";
		html += "</html>";
		
		pw.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
