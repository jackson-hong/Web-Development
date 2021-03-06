package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<Member> list = new ArrayList<Member>();
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage=1;
		}
		int numPerPage = 5;
		list = new AdminService().memberSearch(searchType,searchKeyword,cPage,numPerPage);
		
		int pageBarSize = 5;
		int totalData = new AdminService().memberSearchCount(searchType,searchKeyword);
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo + pageBarSize -1;
		String pageBar = "";
		
		if(pageNo == 1 ) {
			pageBar += "<span>[이전]</span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/admin/memberSearch?cPage=" + (pageNo-1) +"&searchType="+searchType+ "&searchkeyword="+searchKeyword+"'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>" + pageNo + "</span>";
			}else {
				pageBar += "<a href='" + request.getContextPath() + "/admin/memberSearch?cPage="+pageNo+"&searchType="+searchType+ "&searchkeyword="+searchKeyword+"'>" + pageNo + "</a>";		
			}
			pageNo++;
		}
		
		if(pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/admin/memberSearch?cPage=" + pageNo + "&searchType="+searchType+ "&searchkeyword="+searchKeyword+"'>" + "[다음]</a>";
		}
		
		request.setAttribute("members", list);
		request.setAttribute("pageBar", pageBar);
		
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
