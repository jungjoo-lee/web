package JDBC02;

import java.util.Scanner;

public class Book_Delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int result = 0;
		
		System.out.print("삭제할 도서의 도서번호를 입력하세요 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		
		BookDAOImpl bookDAO = new BookDAOImpl();
		BookDTO bookDTO = bookDAO.getBook(bookNum);
		
		if(bookDTO == null) {
			System.out.println("입력한 도서번호의 도서가 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("제목 : " + bookDTO.getSubject());
		System.out.print("삭제하시겠습니까?(1. yes, 2. no) : ");
		select = Integer.parseInt(sc.nextLine());
		
		if(select == 1)
			result = bookDAO.deleteBookDTO(bookNum);
		
		if (result == 1)
			System.out.println("레코드 삭제 성공");
		else
			System.out.println("레코드 삭제 실패");
	}
}
