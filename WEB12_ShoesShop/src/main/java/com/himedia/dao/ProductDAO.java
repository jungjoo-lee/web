package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.himedia.dto.ProductDTO;
import com.himedia.properties.Env;

public class ProductDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<ProductDTO> bestList() {
		List<ProductDTO> bestList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getBestList());
			rs = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return bestList;
	}
	
	public List<ProductDTO> newList() {
		List<ProductDTO> newList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getNewList());
			rs = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return newList;
	}
	
	public int lastProductID() {
		int lastID = 0;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getLastProductID());
			rs = pstmt.executeQuery();
			rs.next();
			lastID = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return lastID;
	}
	
	public void insertProduct(ProductDTO product) {	
		try {
			System.out.println(product.toString());
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getInsertProduct());
			pstmt.setString(1, product.getName());
			pstmt.setString(2, String.valueOf(product.getKind()));
			pstmt.setInt(3, product.getPrice1());
			pstmt.setInt(4, product.getPrice2());
			pstmt.setInt(5, product.getPrice3());
			pstmt.setString(6, product.getContent());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
}
