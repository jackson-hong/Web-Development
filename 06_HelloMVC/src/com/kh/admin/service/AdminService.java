package com.kh.admin.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.dao.AdminDao;
import com.kh.member.model.vo.Member;

public class AdminService {
	public ArrayList<Member> memberList(){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().memberList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> memberSearch(String searchType, String keyword){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().memberSearch(conn, searchType, keyword);
		close(conn);
		return list;
	}
	
}
