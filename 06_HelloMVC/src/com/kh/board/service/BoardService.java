package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class BoardService {

	BoardDao dao = new BoardDao();
	
	public List<Board> boardList() {
		Connection conn = getConnection();
		List<Board> boardList = dao.boardList(conn);
		close(conn);
		return boardList();
		
	}
}
