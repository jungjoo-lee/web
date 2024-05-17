package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.himedia.dto.MemberDTO;
import com.himedia.properties.Env;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;
	private DBConn dc;
	
	public MemberDAO() {
		try {
			dc = new DBConn();
			dataFactory = dc.getDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO getMember(String userid) {
		MemberDTO memberDTO = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.getMember());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberDTO = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
		
		return memberDTO;
	}
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = new ArrayList<>();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.select());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberList.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
		
		return memberList;
	}
	
	public void insertMember(MemberDTO member) {
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.insert());
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
	}
	
	public void deleteMember(String userid) {
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.delete());
			pstmt.setString(1, userid);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
	}
}
