package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.himedia.dto.ProductImageDTO;
import com.himedia.properties.Env;

public class ProductImageDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void insertProductImages(ProductImageDTO dto) {
		try {
			System.out.println(dto.toString());
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
