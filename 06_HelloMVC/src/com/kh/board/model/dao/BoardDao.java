package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;

public class BoardDao {

	Properties prop = new Properties();
	
	public BoardDao() {
		// TODO Auto-generated constructor stub
		String fileName = BoardDao.class.getResource("/sql/board/sql_board.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> boardList(Connection conn, int cPage, int numPerPage){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("boardList");
		List<Board> boList = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardWriter(rs.getString("BOARD_WRITER"));
				b.setBoardContent(rs.getString("BOARD_CONTENT"));
				b.setBoardOriginalFilename(rs.getString("BOARD_ORIGINAL_FILENAME"));
				b.setBoardRenamedFilename(rs.getString("BOARD_RENAMED_FILENAME"));
				b.setBoardDate(rs.getDate("BOARD_DATE"));
				b.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
				boList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return boList;
	}
	
	public int boardListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("boardListCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return result;
	}
	
	public Board boardPage(Connection conn, String boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("boardPage");
		Board b = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board();
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardWriter(rs.getString("BOARD_WRITER"));
				b.setBoardContent(rs.getString("BOARD_CONTENT"));
				b.setBoardOriginalFilename(rs.getString("BOARD_ORIGINAL_FILENAME"));
				b.setBoardRenamedFilename(rs.getString("BOARD_RENAMED_FILENAME"));
				b.setBoardDate(rs.getDate("BOARD_DATE"));
				b.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return b;
	}
	
	public int updateReadCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateReadCount"));
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardOriginalFilename());
			pstmt.setString(5, b.getBoardRenamedFilename());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
