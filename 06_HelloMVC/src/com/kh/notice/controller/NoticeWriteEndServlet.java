package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeWriteEndServlet
 */
@WebServlet("/notice/noticeWriteEnd")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//파일에 대한 전송이 있을 경우 multipart/formdata 타입으로 httprequest가 전송됨
		//1. type multipart/formdata 방식으로 왔는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			//잘못된 요청이기 때문에 중단
			request.setAttribute("msg", "공지사항 작성오류[form:enctype 관리자에게 문의하세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		//2. 파일업로드 처리하기 -> 서버에 클라이언트가 보내준 파일을 저장
		// 1) 저장할 경로를 path 가져온다.
		// context객체를 이용해서 현재프로젝트(어플리케이션이 저장된 위치)를 확인할 수 있음
		System.out.println(getServletContext().getRealPath("/")); //최상위 디렉토리에서 web이 있는 폴더까지 나옴
		// 저장경로는 반드시 생성되어 있어야함. -> 없다고 생성하지 않음!
		String path = getServletContext().getRealPath("/")+"upload/notice";//업로드 절대경로
		// 2) 저장할 파일의 최대크기를 설정
		// 지정된 용량보다 더 크면 예외발생시킴
		int maxSize=1024*1024*10;//10mb
		// 3) 문자에 대한 인코딩값 설정
		String encode = "UTF-8";
		// 4) 업로드된 파일에 대한 rename 처리
		// 		* 불특정 다수에게 전달되어 오는 파일은 중복되는 명칭이 있을 가능성이 있다
		//		rename 처리 객체를 이용해서 처리함. DefaultFileRenamePolicy 
		//		-> cos에서 제공하는 기본 리네임 처리 객체
		//		우리가 rename 처리 객체를 만들 수도 있음.
		
		//request로 전달한 데이터를 cos.jar에서 제공하는 MultipartRequest객체가 처리
		// MultipartRequest객체를 생성 -> 생성자를 이용해서 생성
		// 첫번째 매개변수 : HttpServletRequest
		// 두번째 매개변수 : 파일경로
		// 네번째 매개변수 : 파일사이즈
		// 세번째 매개변수 : 인코딩값
		// 다섯번째 매개변수 : rename규칙 객체
		
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, new DefaultFileRenamePolicy());
		
		//MultipartRequest 객체를 생성해서 처리할때는 더 이상 request를 쓰지 않고
		//mr을 써야함
		
		Notice n = new Notice();
		n.setNoticeTitle(mr.getParameter("title"));
		n.setNoticeWriter(mr.getParameter("writer"));
		n.setNoticeContent(mr.getParameter("content"));
		//파일에 대한 정보를 가져올때
		String filePath = mr.getFilesystemName("upfile");
		n.setFilepath(mr.getParameter("file"));
		int result = new NoticeService().noticeWrite(n);
		
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
