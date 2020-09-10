package com.kh.notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
 * Servlet implementation class NoticeFileDownServlet
 */
@WebServlet("/notice/noticeFileDownload")
public class NoticeFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//사용자가 전달한 파일명과 동일한 파일을 클라이언트에게 보내줌
		
		//1. 전송할 파일에 대한 경로를 가져옴
		String path = getServletContext().getRealPath("/upload/notice/");
		String file = request.getParameter("fname");
		
		//파일입출력을 위한 스트림열기
		//1. hard에 있는 파일을 서버로 가져옴.
		File downFile = new File(path+"/"+file);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile));
		
		//클라이언트 스트림 열기
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		//브라우져에 따라 인코딩방식이 달라서 파일명에 대해 일코딩처리를 해줘야함.
		//IE vs other
		String fileRename = "";
		String header = request.getHeader("user-agent");
		
		boolean isMSIE = header.indexOf("MSIE")!=-1||header.indexOf("Trident") != -1;
		if(isMSIE) {
			fileRename=URLEncoder.encode(file,"UTF-8").replaceAll("\\+", "%20");
		}else {
			fileRename=new String(file.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		//응답메세지 작성
		//html x / file!!
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+fileRename);
		
		//파일 출력하기 -> 전송!
		int read = -1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
