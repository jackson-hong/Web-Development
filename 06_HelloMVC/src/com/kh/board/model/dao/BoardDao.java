package com.kh.board.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import static com.kh.common.JDBCTemplate.close;

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
	
	public List<Board> boardList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("boardList");
		List<Board> boardList = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("Board_NO"));
				b.setBoardTitle(rs.getString("Board_TITLE"));
				b.setBoardWriter(rs.getString("Board_WRITER"));
				b.setBoardContent(rs.getString("Board_CONTENT"));
				b.setBoardOriginalFilename(rs.getString("Board_ORIGINAL_FILENAME"));
				b.setBoardRenamedFilename(rs.getString("Board_RENAME_FILENAME"));
				b.setBoardDate(rs.getDate("Board_DATE"));
				b.setBoardReadcount(rs.getInt("Board_READCOUNT"));
				boardList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return boardList;
	}
}
