package com.onebyn.member.dao;

import static com.onebyn.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.onebyn.member.model.vo.Member;

//OnebyN
public class MemberDao {
	
	Properties prop = new Properties();
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
		try {
			String fileName = MemberDao.class.getResource("/member/member.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		String sql = prop.getProperty("loginMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) m = setMember(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int enrollMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result;
		try {
			String sql = prop.getProperty("enrollMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setDate(4, m.getBirthDate());
			//util date -> sql date
			pstmt.setString(1, m.getUserId());
			pstmt.setString(1, m.getUserId());
			pstmt.setString(1, m.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Member setMember(ResultSet rs) {
		Member m = new Member();
		try {
			m.setUserId(rs.getString("USERID"));
			m.setPassword(rs.getString("PASSWORD"));
			m.setUserName(rs.getString("USERNAME"));
			m.setBirthDate(rs.getDate("BIRTHDATE"));
			m.setGender(rs.getString("GENDER"));
			m.setPhone(rs.getString("PHONE"));
			m.setEnrollDate(rs.getDate("ENROLLDATE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
}
