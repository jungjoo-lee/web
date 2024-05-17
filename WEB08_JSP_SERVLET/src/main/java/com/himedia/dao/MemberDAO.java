package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.himedia.properties.Env;
import com.himedia.vo.MemberVO;

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
	
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.select());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberList.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public void insert(MemberVO member) {		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.insert());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
	}
}
