package com.data.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestPersonServlet2
 */
@WebServlet("/testPerson.do")
public class TestPersonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPersonServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다양한 파라미터값 가져오기
		//파라미터로 넘어오는 값은 전부 다 String 자료형
		//단일 값은 getParameter()로 받고 다중값은 getParameterValues()
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String[] foods = request.getParameterValues("foods");
		String animal = request.getParameter("animals");
		System.out.println(name);
		
		//getParameterNames(); -> name의 값을 불러오는 메소드
		Enumeration<String> keys = request.getParameterNames();
		ArrayList<String[]> values = new ArrayList<String[]>();
		//iterator와 비슷하게 동작을 함.
		while(keys.hasMoreElements()) {
			values.add(request.getParameterValues(keys.nextElement()));
		}
		
		System.out.println(values);
		
		for(String[] val : values) {
			for(String v : val) {
				System.out.println(v);
			}
		}
		
		//getParameterMap() -> key값과 value값으로 받기
		Map<String, String[]> param = request.getParameterMap();
		Set<Map.Entry<String, String[]>> entry = param.entrySet();
		Iterator<Map.Entry<String, String[]>> it = entry.iterator();
		Iterator it2 = entry.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String[]> p = it.next();
			for(String v : p.getValue()) {
				System.out.println(p.getKey() + " : "+ v);
			}
		}
		
		//응답 메세지 작성
		//HttpServletResponse 객체를 이용
		//서버 -> 클라이언트 : 페이지(html) 소스코드를 전송! * 대부분!
		//1. 전송메세지 mimetype -> text/html
		response.setContentType("text/html; charset=utf-8");
		//메세지를 전송!
		//response.getWriter() / getOutputStream();
		
		//다른 서블릿에서 request에 넣은 값 가져오기
		//request.getAttribute()-datatype = object
		String msg = (String)request.getAttribute("msg");
		PrintWriter out = response.getWriter();
		String html = "<html>";
		html += "<body>";
		html += "<h1 style='color:skyblue;'>" + msg + "</h1>";
		html += "<h1>당신이 선택한 취향은</h1>";
		html += "<h3>당신의 이름은 " + name +  "이고 </h3>";
		html += "<p>당신이 좋아하는 색은 " + color + "이고, 좋아하는 음식은 </p>";
		html += "<ul>";
		for (String f : foods) html+="<li>" + f + "</li>";
		html += "</ul>";
		html += "<p>좋아하는 동물은 " + animal + "입니다. </p>";
		html += "</body>";
		html += "</html>";
		out.print(html);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
