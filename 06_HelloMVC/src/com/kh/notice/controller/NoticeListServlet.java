package com.kh.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/noticeList")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage;
		try {
		cPage=Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage = 5;
		List<Notice> noticeList = new NoticeService().noticeList(cPage, numPerPage);
		
		int totalData = new NoticeService().noticeListCount();
		
		int totalPage = (int)(Math.ceil((double)totalData/numPerPage));
		
		int pageBarSize = 5;
		
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo + pageBarSize -1;
		String pageBar = "";
		
		if(pageNo == 1 ) {
			pageBar += "<span>[이전]</span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/admin/memberSearch?cPage=" + (pageNo-1) + "'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>" + pageNo + "</span>";
			}else {
				
			}
			pageNo++;
		}
		
		if(pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/admin/memberSearch?cPage=" + pageNo + "'>[이전]</a>";
		}
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
