package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticePageServlet
 */
@WebServlet("/notice/noticePage")
public class NoticePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Notice n = new NoticeService().noticePage(request.getParameter("noticeNo"));
		String view;
		if(n==null) {
			//선택한 자료가 없을 떄
			//자료가 없다는 메세지 출력 후 리스트 화면으로 이동
			request.setAttribute("msg", "조회된 공지사항이 없습니다");
			request.setAttribute("loc", "/notice/noticeList");
			view = "/views/common/msg.jsp";
		}else {
			request.setAttribute("notice", n);
			view = "/views/notice/noticePage.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
