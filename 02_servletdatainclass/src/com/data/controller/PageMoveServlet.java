package com.data.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageMoveServlet
 */
@WebServlet("/pageMove.do")
public class PageMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public PageMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//특정데이터를 넣고 다른 서블릿으로 이동시키기
		//서버 내부에서 다른 서블릿을 호출하는 것!
		//RequestDispatcher 객체를 이용해서 처리를 함.
		//request.getRequestDispatcher(); 불러오고 -> 매개변수 : 특정서블릿, page
		//RequestDispatcher객체의 forward() 메소드를 이용해서 페이지, 서블릿 전환
		//forward() 메소드의 매개변수는 request, response대입
		System.out.println("pageMove 서블릿!");
		//다른 서블릿으로 전환하기 전에 전달할 데이터가 있으면
		//request객체를 이용해서 데이터를 넣어줄 수 있음
		//url 주소가 변경되지 않음!
		//url주소는 pageMove.do 지만
		//출력된 주소는 testPerson.do
		//Attribute -> setAttribute()/ getAttribute()
		//setAttribute()메소드를 이용해서 데이터를 넣을 수 있음
		//key:value방식으로!
		request.setCharacterEncoding("utf-8");
		request.setAttribute("msg", request.getParameter("name")+"님 우리 사이트를 이용해주셔서 감사합니다.");
		
		RequestDispatcher rd = request.getRequestDispatcher("testPerson.do");
		rd.forward(request, response); //페이지 이동!
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
