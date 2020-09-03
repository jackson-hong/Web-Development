package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public Member loginMember(String id, String pw){
		Connection conn = getConnection();
		Member m = dao.loginMember(conn,id,pw);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = dao.insertMember(conn,m);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member m = dao.selectMember(conn, userId);
		close(conn);
		return m;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = dao.updateMember(conn,m);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result = dao.deleteMember(conn,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updatePassword(String id, String password) {
		Connection conn = getConnection();
		int result = dao.updatePassword(conn, id, password);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
