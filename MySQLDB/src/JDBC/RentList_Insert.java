package JDBC;

import java.util.Scanner;

public class RentList_Insert {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		RentDAOImpl rentDAO = RentDAOImpl.getInstance();
		Scanner sc = new Scanner(System.in);

		int memberNum;
		while (true) {
			System.out.print("대여할 회원의 회원번호를 입력하세요 : ");
			memberNum = Integer.parseInt(sc.nextLine());

			int result = rentDAO.memberOk(memberNum);

			if (result == 0) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요.");
				continue;
			} else
				break;
		}
		
		int bookNum;
		while (true) {
			System.out.print("대여할 도서의 도서번호를 입력하세요 : ");
			bookNum = Integer.parseInt(sc.nextLine());

			int result = rentDAO.bookOk(bookNum);

			if (result == 0) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요.");
				continue;
			} else
				break;
		}
		
		System.out.print("할인금액을 입력하세요 : ");
		int discount = Integer.parseInt(sc.nextLine());
		
		int res = rentDAO.insertRent(RentDTO.builder().bnum(bookNum).mnum(memberNum).discount(discount).build());
		
		if (res == 1) System.out.println("추가 성공");
		else System.out.println("추가 실패");
	}
}
