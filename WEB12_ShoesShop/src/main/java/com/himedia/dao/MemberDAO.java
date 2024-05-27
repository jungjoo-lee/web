package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.himedia.dto.MemberDTO;
import com.himedia.properties.Env;
import com.himedia.util.DBConn;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() { return dao; }
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDTO getMember(String userid) {
		MemberDTO memberDTO = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getMember());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberDTO = MemberDTO.builder()
						.userid(rs.getString(1))
						.pwd(rs.getString(2))
						.name(rs.getString(3))
						.phone(rs.getString(4))
						.email(rs.getString(5))
						.zip_num(rs.getString(6))
						.address1(rs.getString(7))
						.address2(rs.getString(8))
						.indate(rs.getTimestamp(9))
						.useyn(rs.getString(10).charAt(0))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return memberDTO;
	}
	
	public void join(MemberDTO dto) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.join());
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getZip_num());
			pstmt.setString(7, dto.getAddress1());
			pstmt.setString(8, dto.getAddress2());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
}
