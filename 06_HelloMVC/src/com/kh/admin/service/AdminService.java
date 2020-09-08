package com.kh.admin.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.dao.AdminDao;
import com.kh.member.model.vo.Member;

public class AdminService {
private AdminDao dao=new AdminDao();
	
	
	public List<Member> memberList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.memberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	
	public List<Member> memberSearch(String type, String keyword, int cPage, int numPerpage){
		Connection conn=getConnection();
		System.out.println(type);
		List<Member> list=dao.memberSearch(conn, type, keyword, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int memberCount() {
		Connection conn = getConnection();
		int count = dao.memberCount(conn);
		close(conn);
		return count;
	}
	
	public int memberSearchCount(String type, String keyword) {
		Connection conn = getConnection();
		int count = dao.memberSearchCount(conn, type, keyword);
		close(conn);
		return count;
	}
	
	public Member searchMember(String userId) {
		Connection conn = getConnection();
		Member m = dao.searchMember(conn, userId);
		close(conn);
		return m;
	}
}
