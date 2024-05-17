package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {
	public static void main(String[] args) {
		Connection conn = null;
		// SQL 명령을 담고 실행해서 결과를 얻어오는 클래스
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			
			// SQL 문을 String 형식으로 작성후 변수에 저장합니다.
			// String 변수 sql에 담긴 SQL 명령을 연결된 객체 conn과 함께 pstmt에 장착합니다.
			pstmt = conn.prepareStatement("select * from customer");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
