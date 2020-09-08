package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		// 리스트에 대한 페이징 처리하기

		// 현재 페이지의 초기값을 설정 : cPage ->현재 요청, 보고있는 페이지 의미
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		// 페이지당 데이터 수 : numPerPage -> 한개 페이지에서 보여줄 데이터 수
		int numPerPage = 5;
		if(request.getParameter("numPerPage")!=null) {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		System.out.println(numPerPage);
		// 1p : 1 ~ 5 rnum의 데이터
		// 2p : 6 ~ 10
		// 3p : 11 ~ 15
		// cPage, numPerPage로 계산이 가능함.
		// 시작 : (cPage-1)*numPerPage+1
		// 종료 : cPage*numPerPage

		// DB member테이블에 있는 전체 row를 가져와서 페이지에 전달하는 기능
		// 전체자료를 가져오는 로직을 구성하기
		// 단 admin패키지를 구성해서 작성할것.
		// - admin에 대한 service, dao 패키지를 별도 구성

		//List<Member> list=new AdminService().selectMemberList();
		List<Member> list = new AdminService().memberList(cPage, numPerPage);
		
		//pageBar 만들기!
		//1. pageBarsize : 페이지번호 출력 갯수 -> 개발자가 정함
		int pageBarSize = 5;
		//2. 총 페이지 수 : 총 페이지수 -> 전체 자료 수 / numPerPage
		int totalData = new AdminService().memberCount();
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		
		//3. 페이지바를 구성하는 번호 만들기
		//3. pageNo : 페이지 시작번호
		//3. PageEnd : 페이지 끝번호
		//cPage 1 -> 1이 되야함.
		//cPage 8 -> 6이 되어야 함.
		//cPage 14 -> 11이 되어야함
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar="";//페이지바를 구성한 html구문을 누적하는 변수
		if(pageNo == 1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/admin/memberList?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		//연결되는 페이지 번호 출력하기
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>" + pageNo + "</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/memberList?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		//다음
		if(pageNo>totalPage) {
			pageBar += "<span>[다음]</span>";
		}else {
			pageBar += "<a href='" + request.getContextPath() + "/admin/memberList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		//데이터를 다 넣기!

		// 데이터를 페이지 전송!
		// 1.DB에 가져온 데이터를 객체에 저장 -> request, session, servletcontext
		request.setAttribute("members", list);
		request.setAttribute("pageBar", pageBar);

		// 2.페이지선택 전환
		request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
