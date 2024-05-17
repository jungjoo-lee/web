package JDBC;

import java.util.Scanner;

public class RentList_Delete {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RentDAOImpl rentDAO = RentDAOImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		int result = 0;
		
		System.out.print("삭제할 대여기록의 대여번호를 입력하세요 : ");
		int rentNum = Integer.parseInt(sc.nextLine());
		
		RentDTO rent = rentDAO.getRent(rentNum);
		
		if(rent == null) {
			System.out.println("입력한 대여번호의 대여기록이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("대여번호 : " + rent.getNumseq());
		System.out.print("삭제하시겠습니까?(1. yes, 2. no) : ");
		select = Integer.parseInt(sc.nextLine());
		
		if(select == 1)
			result = rentDAO.deleteRent(rentNum);
		
		if (result == 1)
			System.out.println("삭제 성공");
		else
			System.out.println("삭제 실패");
	}
}
