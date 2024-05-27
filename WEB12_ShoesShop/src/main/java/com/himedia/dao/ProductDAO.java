package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.himedia.dto.ProductDTO;
import com.himedia.properties.Env;
import com.himedia.util.DBConn;

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
			
			while(rs.next()) {
				bestList.add(ProductDTO.builder()
						.pseq(rs.getInt(1))
						.name(rs.getString(2))
						.price2(rs.getInt(3))
						.build());
			}
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
			
			while(rs.next()) {
				newList.add(ProductDTO.builder()
						.pseq(rs.getInt(1))
						.name(rs.getString(2))
						.price2(rs.getInt(3))
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return newList;
	}
	
	public List<ProductDTO> listByCategory(char kind) {
		List<ProductDTO> productList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getListByCategory());
			pstmt.setString(1, String.valueOf(kind));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productList.add(ProductDTO.builder()
						.pseq(rs.getInt(1))
						.name(rs.getString(2))
						.price2(rs.getInt(3))
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return productList;
	}
	
	public ProductDTO getProduct(int pseq) {
		ProductDTO dto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getProduct());
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = ProductDTO.builder()
						.pseq(rs.getInt(1))
						.name(rs.getString(2))
						.kind(rs.getString(3).charAt(0))
						.price1(rs.getInt(4))
						.price2(rs.getInt(5))
						.price3(rs.getInt(6))
						.content(rs.getString(7))
						.bestyn(rs.getString(8).charAt(0))
						.useyn(rs.getString(9).charAt(0))
						.indate(rs.getTimestamp(10))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	public ProductDTO getProductName(int pseq) {
		ProductDTO dto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getProductName());
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = ProductDTO.builder().name(rs.getString(1)).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return dto;
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
