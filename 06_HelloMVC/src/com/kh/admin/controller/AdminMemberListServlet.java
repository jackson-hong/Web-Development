package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.service.AdminService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//관리자 페이지 권한처리하기
		//관리자 아닌 경우에는 페이지를 못 보게 처리하기
		HttpSession session = request.getSession(false); //얘를 한번에 처리하기 admin 이라는 주소값을 이용해서
		Member login = (Member)session.getAttribute("logginedMember");
		if(login==null || !login.getUserId().equals("admin")) {
			//msg.jsp로 메세지 출력 후 메인화면으로 전환!
			
			request.setAttribute("msg", "잘못된 접근입니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		//DB member 테이블에 있는 전체 row를 가져와서 페이지에 전달하는 기능
		//전체자료를 가져오는 로직을 구성하기
		//단 admin 패키지를 구성해서 작성할것.
		// - admin에 대한 service, dao 패키지를 별도 구성
		
		ArrayList<Member> memberList = new AdminService().memberList();
		
		//데이터를 페이지 전송!
		//1.DB에 가져온 데이터를 객체에 저장 -> request, session, servletcontext;
		request.setAttribute("members", memberList);
		
		//2.페이지 선택 전환
		request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
