package com.signin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.signin.model.vo.User;

public class UserDAO {

	public int siginin(Connection conn, User user) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getMemberId());
			pstmt.setString(2, user.getMemberPwd());
			pstmt.setString(3, user.getMemberName());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getMemberId());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
