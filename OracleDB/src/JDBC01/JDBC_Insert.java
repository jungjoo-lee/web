package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Insert {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1234");
			conn.setAutoCommit(false);

			System.out.print("번호를 입력하세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.print("이름을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.print("이메일을 입력하세요 : ");
			String email = sc.nextLine();
			System.out.print("전화번호를 입력하세요 : ");
			String phone = sc.nextLine();
			
//			pstmt = conn.prepareStatement("insert into customer values (" + num + ", '" + name + "', '" + email + "', '" + phone + "'" + ")");
			pstmt = conn.prepareStatement("insert into customer values (?, ?, ?, ?)");
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("레코드 추가 성공");
				conn.commit();
			} else {
				System.out.println("레코드 추가 실패");
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
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
