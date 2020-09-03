package com.kh.member.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AESCrypto;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet(name = "enrollMember", urlPatterns="/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setPassword(request.getParameter("password"));
		m.setUserName(request.getParameter("userName"));
		m.setGender(request.getParameter("gender"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		try {
			m.setEmail(AESCrypto.encrypt(email));
			m.setPhone(AESCrypto.encrypt(phone));
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.setAddress(request.getParameter("address"));
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = String.join(",", hobbys);
		m.setHobby(hobby);
		int result = new MemberService().insertMember(m);

		//result 결과에 따라 가입 성공여부 메세지를 출력하고 메인화면으로 이동
		String msg="";
		String loc="/";
		if(result>0) {
			msg="회원가입성공!";
		}else {
			msg="회원가입실패!";
			loc="/enrollMember";
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

}
