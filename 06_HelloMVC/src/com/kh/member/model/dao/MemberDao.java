package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		// 프로퍼티파일 가져오기
		try {
			String fileName = MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(prop.getProperty("selectMember"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}

	public int insertMember(Connection conn, Member m) {

		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;

		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectMemberOne"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = inputData(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public Member inputData(ResultSet rs) {
		Member m = null;
		try {
			m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateMember"));
//			pstmt.setString(1, m.getPassword());
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getGender());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getHobby());
			pstmt.setString(8, m.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e	) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updatePassword(Connection conn, String userId, String password) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePassword"));
			pstmt.setString(1, password);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
