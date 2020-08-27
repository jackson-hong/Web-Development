package com.data.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageMoveServlet2
 */
@WebServlet("/sendredirect.do")
public class PageMoveServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageMoveServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 전환하는 두번째 방법
		//response객체의 sendRedirect메소드 이용하기
		//RequestDispatcher - request객체
		//sendRedirect는 url을 지정된 url로 변경시킴
		//null 포인트 에러가 난다 - parameter로 보낸 정보가 다 사라지기 때문
		response.sendRedirect("/02_servletdatainclass");
		//1. request 보낸 정보가 다 사라짐! 없어짐. parameter로 보낸 값이 사라짐
		//2. url주소를 변경시킴 -> request가 새로 만들어짐
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
