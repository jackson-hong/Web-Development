package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePasswordEnd
 */
@WebServlet(name="updatePassword", urlPatterns="/updatePasswordEnd")
public class UpdatePasswordEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("userId") + request.getParameter("password"));
		int result = new MemberService().updatePassword(request.getParameter("userId"), request.getParameter("password"));
		String msg = "";
		String loc = "/";
		if(result > 0) {
			msg = "비밀번호 변경에 성공했습니다!";
		}else {
			msg = "비밀번호 변경에 실패했습니다.";
			loc = "/updatePassword";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.setAttribute("script", "self.close();");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
