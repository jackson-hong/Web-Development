package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;

public class BoardService {

	private BoardDao dao = new BoardDao();
	
	public List<Board> boardList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Board> boardList = dao.boardList(conn, cPage, numPerPage);
		close(conn);
		return boardList;
		//boardList()썼다가 무한포문 돌았다리
	}
	
	public int boardListCount() {
		Connection conn = getConnection();
		int count = dao.boardListCount(conn);
		close(conn);
		return count;
	}
	
	public Board boardPage(String boardNo, boolean hasRead) {
		Connection conn = getConnection();
		Board b = dao.boardPage(conn,boardNo);
		//게시글 조회수 증가 로직
		if(b!=null && !hasRead) {
			int result = dao.updateReadCount(conn, Integer.parseInt(boardNo));
			if(result > 0)commit(conn);
			else rollback(conn);
		}
		close(conn);
		return b;
	}
	
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = dao.insertBoard(conn, b);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
}
