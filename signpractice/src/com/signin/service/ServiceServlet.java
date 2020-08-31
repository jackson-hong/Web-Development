package com.signin.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.signin.common.JDBCTemplate;
import com.signin.model.dao.UserDAO;
import com.signin.model.vo.User;

public class ServiceServlet {
	private UserDAO dao = new UserDAO();
	public int signin(User user) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.siginin(conn, user);
		try{
			if(conn!=null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
