package com.kh.notice.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.close;

public class NoticeDao {

	Properties prop = new Properties();

	public NoticeDao() {
		// TODO Auto-generated constructor stub
		String fileName = NoticeDao.class.getResource("/sql/notice/notice_sql.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Notice> noticeList(Connection conn, int cPage, int numPerPage) {
		// TODO Auto-generated constructor stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		String sql = prop.getProperty("noticeList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next())  {
			Notice n = new Notice();
			n.setNoticeTitle(rs.getNString("NOTICE_TITLE"));
			n.setNoticeWriter(rs.getNString("NOTICE_WRITER"));
			n.setNoticeContent(rs.getNString("NOTICE_CONTENT"));
			n.setNoticeNo(rs.getInt("NOTICE_NO"));
			n.setNoticeDate(rs.getDate("NOTICE_DATE"));
			n.setFilepath(rs.getNString("FILEPATH"));
			n.setStatus(rs.getString("STATUS"));
			noticeList.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return noticeList;
	}
	
	public int noticeListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("noticeListCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
}
