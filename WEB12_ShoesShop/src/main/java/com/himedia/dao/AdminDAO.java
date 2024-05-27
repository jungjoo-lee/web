package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.himedia.dto.MemberDTO;
import com.himedia.properties.Env;
import com.himedia.util.DBConn;

public class AdminDAO {
	private AdminDAO() {}
	private static AdminDAO dao = new AdminDAO();
	public static AdminDAO getInstance() { return dao; }
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<MemberDTO> getMemberList(int amount, int page) {
		List<MemberDTO> memberList = new ArrayList<>();
		int offset = (page - 1) * amount;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getMemberList());
			pstmt.setInt(1, amount);
			pstmt.setInt(2, offset);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberList.add(MemberDTO.builder()
						.userid(rs.getString(1))
						.name(rs.getString(3))
						.phone(rs.getString(4))
						.email(rs.getString(5))
						.zip_num(rs.getString(6))
						.address1(rs.getString(7))
						.address2(rs.getString(8))
						.indate(rs.getTimestamp(9))
						.useyn(rs.getInt(10))
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return memberList;
	}

	public int getTotalMember() {
		int total = 0;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getTotalMember());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return total;
	}
	
	public void useynMemberToggle(List<String> useridList) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.useynMemberToggle());
			
			for (int i = 0; i < useridList.size(); i++) {
				pstmt.setString(1, useridList.get(i));
				pstmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
	
	public void deleteForce(List<String> useridList) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.deleteForce());
			
			for (int i = 0; i < useridList.size(); i++) {
				pstmt.setString(1, useridList.get(i));
				pstmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
	
	public List<String> keyword(String kind, String keyword) {
		List<String> resultList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();

			if (kind.equals("userid")) {
				pstmt = conn.prepareStatement(Env.useridKeyword());
			} else {
				pstmt = conn.prepareStatement(Env.nameKeyword());
			}
			
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				resultList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return resultList;
	}
}
