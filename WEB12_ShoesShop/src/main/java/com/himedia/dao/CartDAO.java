package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.himedia.dto.CartDTO;
import com.himedia.properties.Env;

public class CartDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<CartDTO> getCartList(String userid) {
		List<CartDTO> cartList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getCartList());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				cartList.add(CartDTO.builder()
						.cseq(rs.getInt(1))
						.userid(rs.getString(2))
						.pseq(rs.getInt(3))
						.name(rs.getString(4))
						.quantity(rs.getInt(5))
						.price(rs.getInt(6))
						.indate(rs.getTimestamp(7))
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return cartList;
	}
	
	public void addCart(CartDTO dto) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.addCart());
			pstmt.setString(1, dto.getUserid());
			pstmt.setInt(2, dto.getPseq());
			pstmt.setInt(3, dto.getQuantity());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
}
