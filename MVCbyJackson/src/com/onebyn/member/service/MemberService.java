package com.onebyn.member.service;

import static com.onebyn.common.JDBCTemplate.close;
import static com.onebyn.common.JDBCTemplate.commit;
import static com.onebyn.common.JDBCTemplate.rollback;
import static com.onebyn.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.onebyn.member.dao.MemberDao;
import com.onebyn.member.model.vo.Member;

public class MemberService {
	
	public Member loginMember(String userId, String password) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, password);
		close(conn);
		return m;
	}
	
	public int enrollMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().enrollMember(conn, m);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
