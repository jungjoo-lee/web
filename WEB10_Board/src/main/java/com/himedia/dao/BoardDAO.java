package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.himedia.dto.BoardDTO;
import com.himedia.properties.Env;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;
	private DBConn dc;
	
	public BoardDAO() {
		try {
			dc = new DBConn();
			dataFactory = dc.getDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = new ArrayList<>();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(Env.getBoardList());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				boardList.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getTimestamp(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dc.DBClose(conn, pstmt, rs);
		}
		
		return boardList;
	}
}
