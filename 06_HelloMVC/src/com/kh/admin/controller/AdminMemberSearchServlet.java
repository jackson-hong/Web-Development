package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.service.AdminService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberSearchServlet
 */
@WebServlet("/admin/memberSearch")
public class AdminMemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchkeyword");
		ArrayList<Member> list = new ArrayList<Member>();
		
		list = new AdminService().memberSearch(searchType,searchKeyword);
		request.setAttribute("members", list);
		
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
