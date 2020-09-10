package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRename;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/board/boardWriteEnd")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//파일에 대한 전송이 있음
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "시스템에서 [enctype] 관리자에게 문의하세요");
			request.setAttribute("loc", "/board/boardList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		//파일 저장 경로 불러오기
		String path = getServletContext().getRealPath("/upload/board");//기본경로
		
		int maxSize = 1024*1024*10;
		
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());
		
		Board b = new Board();
		b.setBoardTitle(mr.getParameter("title"));
		b.setBoardWriter(mr.getParameter("writer"));
		b.setBoardContent(mr.getParameter("content"));
		b.setBoardOriginalFilename(mr.getOriginalFileName("upfile"));
		b.setBoardRenamedFilename(mr.getFilesystemName("upfile"));
		
		int result = new BoardService().insertBoard(b);
		String msg = "";
		String loc = "/board/boardList";
		if(result > 0) {
			msg = "게시글 등록 성공";
		}else {
			msg = "게시글 등록 실패";
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
