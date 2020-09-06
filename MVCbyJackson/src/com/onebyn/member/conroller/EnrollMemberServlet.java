package com.onebyn.member.conroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onebyn.member.model.vo.Member;
import com.onebyn.member.service.MemberService;

/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enrollMember")
public class EnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//회원가입 서블릿
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setPassword(request.getParameter("password"));
		m.setUserName(request.getParameter("userName"));
		m.setGender(request.getParameter("gender"));
		m.setPhone(request.getParameter("phone"));
		m.setBirthDate(toBirthDate(request.getParameter("birthYear"), 
				request.getParameter("birthMonth"), 
				request.getParameter("birthDate")));
		int result = new MemberService().enrollMember(m);
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "가입에 성공했습니다!";
			loc = "/";
			request.setAttribute("member", m);
		}else {
			msg = "가입에 실패했습니다.";
			loc = "/views/member/enrollMember.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//birthDate 만드는 메소드
	private Date toBirthDate(String bYear, String bMonth, String bDate) {
		Date date = null;
		String collected = bYear + "/" + bMonth + "/" + bDate;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(collected);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
