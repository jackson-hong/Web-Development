package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookieServlet
 */
@WebServlet("/deleteTest.do")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//생성된 쿠키 지우기
		//동일한 키값으로 유효기간을 0으로 해서 보내면 지워짐
		Cookie c = new Cookie("id","");
		c.setMaxAge(0);
		response.addCookie(c);
		
		String html = "<html>";
		html += "<body>";
		html += "<h1>현재 사이트에서 저장한 쿠키값</h1>";
		html += "<ul>";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie coo : cookies) {
				html += "<li>" + coo.getName() + " : " 
						+ coo.getValue() + "</li>";
			}
		}
		html += "</ul>";
		html += "</body>";
		html += "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
