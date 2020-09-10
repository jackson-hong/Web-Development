package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardPageServlet
 */
@WebServlet("/board/boardPage")
public class BoardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//게시글 번호		
		String boardNo = request.getParameter("boardNo");
		
		//새로고침시 조회수가 증가하는 것 방지하기
		//쿠키에 조회한 내용을 기록(저장)관리하여 한번 조회하면 그 뒤에는 조회수가 올라가지 않게 설정
		//1. 쿠키에 조회한 이력이 있는지 조회
		Cookie[] cookies = request.getCookies();
		String boardHistory = "";//이력을 저장하는 변수
		boolean hasRead = false;//읽은 글이면 true, 안 읽었으면 false 표현 기준 !
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				//boardHistory인 쿠키값을 찾기
				if("boardHistory".equals(name)) {
					boardHistory = value;//현재 저정된 값 대입
					if(value.contains("|"+boardNo+"|")) {
						//읽은 게시글
						hasRead = true;
						break;
					}
				}
			}
		}
		
		//읽지 않은 게시글이면 cookie에 기록을 해야함.
		if(!hasRead) {
			Cookie c = new Cookie("boardHistory", boardHistory+"|" + boardNo + "|");
			c.setMaxAge(-1);//브라우저 종료시 삭제
			response.addCookie(c);
		}
		Board b = new BoardService().boardPage(boardNo, hasRead);
		request.setAttribute("board", b);
		request.getRequestDispatcher("/views/board/boardPage.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
