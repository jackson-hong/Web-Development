package com.onebyn.member.conroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onebyn.member.model.vo.Member;
import com.onebyn.member.service.MemberService;

/**
 * Servlet implementation class LoginMemberServlet
 */
@WebServlet("/loginMember")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 로그인 서블릿
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member m = new MemberService().loginMember(userId, password);
		
		if(m!=null) {
		HttpSession session = request.getSession();
		session.setAttribute("member", m);
		request.getRequestDispatcher(request.getContextPath());
		} else {
			String msg = "아이디나 비밀번호가 틀립니다.";
			String loc = "/views/member/login.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
