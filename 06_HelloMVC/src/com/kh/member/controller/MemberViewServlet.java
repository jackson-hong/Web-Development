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
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 클라이언트가 보낸 데이터를 받아서
		// 그 데이터(userId)와 일치하는 회원을 페이지에 전달해줌
		String userId = request.getParameter("userId");
		Member m = new MemberService().selectMember(userId);
		
		String email = m.getEmail();
		String phone = m.getPhone();
		try {
			m.setEmail(AESCrypto.decrypt(email));
			m.setPhone(AESCrypto.decrypt(phone));
		} catch (Exception e) {
			m.setEmail(email);
			m.setPhone(phone);
		}
		
		request.setAttribute("member", m);
		
		request.getRequestDispatcher("/views/member/memberView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
