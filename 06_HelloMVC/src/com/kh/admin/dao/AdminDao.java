package com.kh.admin.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class AdminDao {

	private Properties prop = new Properties();

	public AdminDao() {
		// TODO Auto-generated constructor stub
		String fileName = AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Member> memberList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("memberList"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setUserId(rs.getString("userid"));
				m.setUserName(rs.getString("username"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> memberSearch(Connection conn, String searchType, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			String sql = prop.getProperty("searchMember");
			pstmt=conn.prepareStatement(sql.replace("$type", searchType));
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setUserId(rs.getString("userid"));
				m.setUserName(rs.getString("username"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
				list.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
