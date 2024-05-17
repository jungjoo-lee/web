package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Update {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			conn.setAutoCommit(false);

			System.out.print("수정할 회원의 번호를 입력하세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			System.out.print("무엇을 수정할까요? (1. 이메일, 2. 전화번호) : ");
			int select = Integer.parseInt(sc.nextLine());
			
			String sql = "";
			String email = "";
			String phone = "";
			
			if (select == 1) {
				System.out.print("수정할 이메일을 입력하세요 : ");
				email = sc.nextLine();
				sql = "update customer set email = ? where num = ?";
			} else {
				System.out.print("수정할 전화번호를 입력하세요 : ");
				phone = sc.nextLine();
				sql = "update customer set tel = ? where num = ?";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			if (select == 1)
				pstmt.setString(1, email);
			else
				pstmt.setString(1, phone);
			
			pstmt.setInt(2, num);
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("레코드 수정 성공");
				conn.commit();
			} else {
				System.out.println("레코드 수정 실패");
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
