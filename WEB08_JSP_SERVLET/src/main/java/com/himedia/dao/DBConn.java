package com.himedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.himedia.properties.Env;

public class DBConn {
	DataSource dataFactory;
	
	public DBConn() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup(Env.getEnvContext());
			dataFactory = (DataSource) envContext.lookup(Env.getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DBClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DBRollBack(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DataSource getDataSource() {
		return dataFactory;
	}
}