package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Delete {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			conn.setAutoCommit(false);

			System.out.print("삭제할 회원의 번호를 입력하세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			String sql = "delete from customer where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("레코드 삭제 성공");
				conn.commit();
			} else {
				System.out.println("레코드 삭제 실패");
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			if(sc != null) sc.close();
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
