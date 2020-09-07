package com.kh.notice.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> noticeList(int cPage, int numPerPage){
		Connection conn = getConnection();
		List<Notice> noticeList = dao.noticeList(conn, cPage, numPerPage);
		close(conn);
		return noticeList;
	}
	
	public int noticeListCount() {
		Connection conn = getConnection();
		int count  = dao.noticeListCount(conn);
		close(conn);
		return count;
	}
}
