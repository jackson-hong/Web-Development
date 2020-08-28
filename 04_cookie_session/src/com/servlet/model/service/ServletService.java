package com.servlet.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.servlet.common.JDBCTemplate;
import com.servlet.model.dao.ServletDao;
import com.servlet.model.vo.Member;

public class ServletService {
	private ServletDao dao = new ServletDao();
	public Member login(String userId, String password) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.login(conn,password,userId);
		try {
			if(conn!= null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
