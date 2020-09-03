package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginService
 */
@WebServlet(name="loginMember", urlPatterns="/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("userId");
		String pw = request.getParameter("password");
		
		//아이디 저장 로직 구성하기 -> cookie를 이용
		String saveId = request.getParameter("saveId");
		
		//value값을 설정하지 않았을 때 check을 하지 않으면 null 하면 on
		
//		if(saveId.equals("on")) {
		if(saveId!=null) {
			//현재 전달한 아이디를 쿠키에 저장
			//1. Cookie 생성
			Cookie c = new Cookie("saveId", id);
			c.setMaxAge(3*24*60*60);//3일간 저장
			//2.Cookie 저장 메소드 실행 -> response.addCookie(쿠키객체);
			response.addCookie(c);
		} else {
			Cookie c = new Cookie("saveId", "");
			c.setMaxAge(0);
			response.addCookie(c);
		}
		//로그인 로직 처리하기
		//클라이언트가 보내준 값이 DB의 Member 테이블에 일치하는 값이 있는지 확인
		//그 결과를 가져오는 것
		
		Member m = new MemberService().loginMember(id, pw);
		
		//m 이 null 이면 로그인 실패
		//m 이 null이 아니면 로그인 성공
		//페이지를 선택해서 전환해줌
		if(m!=null) {
			//로그인 성공
//			request.setAttribute("logginedMember", m);
			//로그인에 대한 정보는 개발자가 원하는 범위까지 보관할 수 있는
			//session 객체에 보관함
			HttpSession session = request.getSession();
			session.setAttribute("logginedMember", m);
			response.sendRedirect(request.getContextPath());
		}else {
			//로그인 실패
			//로그인 실패에 대한 에러메세지를 띄워주고 메인화면으로 이동
			//1. 에러메세지를 보여줄 페이지가 있어야함.
			//2. 에러 메세지 페이지에서 메인화면으로 전환!
			
			//에러메세지 페이지를 공용으로 사용하기 위해
			//에러메세지와 이동할 페이지를 data로 전송 이용
			//request객체를 이용
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다");
			request.setAttribute("loc", "/");
			//request 데이터를 유지해서 페이지를 넘겨려면 RequestDispatcher를 이용해서
			//페이지를 전환해야함
			RequestDispatcher rd =request.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request, response);
		}
//		RequestDispatcher rd = request.getRequestDispatcher("/");
//		rd.forward(request, response);
		
		//dispatcher로 보내면 새로고침 시에 계속 값이 보내지므로
		//로그인 후에는 sendRedirect로 보내기
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
