package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.himedia.dto.ProductImageDTO;
import com.himedia.properties.Env;
import com.himedia.util.DBConn;

public class ProductImageDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductImageDTO getProductImage(int pseq) {
		ProductImageDTO productImage = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getProductImage());
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productImage = new ProductImageDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getLong(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return productImage;
	}
	
	public void insertProductImages(ProductImageDTO dto) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(Env.getInsertProductImage());
			pstmt.setInt(1, dto.getPseq());
			pstmt.setString(2, dto.getOrgName());
			pstmt.setString(3, dto.getRealName());
			pstmt.setLong(4, dto.getFilesize());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
	}
}
