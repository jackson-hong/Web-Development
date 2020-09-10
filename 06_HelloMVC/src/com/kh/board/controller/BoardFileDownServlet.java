package com.kh.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFileDownServlet
 */
@WebServlet("/board/boardFileDown")
public class BoardFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = getServletContext().getRealPath("/upload/board");
		String oName = request.getParameter("oName");//원본이름
		String rName = request.getParameter("rName");//서버에 저장된 이름
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "/" +rName));
		
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		//한글인코딩처리
		String header = request.getHeader("user-agent");
		boolean isMS=header.indexOf("Trident")!=-1||header.indexOf("MSIE")!=-1;
		String reName = "";
		if(isMS) {
			reName = URLEncoder.encode(oName, "UTF-8");
			reName = reName.replaceAll("//+", "%20");
		}else {
			reName = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		response.setContentType("application/octet");
		response.setHeader("Content-Disposition", "attachment;filename=" + reName);
		
		int read = -1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bos.close();
		bos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
