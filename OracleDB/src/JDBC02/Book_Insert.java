package JDBC02;

import java.util.Scanner;

public class Book_Insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDTO bookDTO = new BookDTO();
		
		System.out.print("제목을 입력하세요 : ");
		bookDTO.setSubject(sc.nextLine());
		
		System.out.print("출판년도를 입력하세요 : ");
		bookDTO.setMakeyear(Integer.parseInt(sc.nextLine()));
		
		System.out.print("입고가격을 입력하세요 : ");
		bookDTO.setInprice(Integer.parseInt(sc.nextLine()));
		
		System.out.print("대여가격을 입력하세요 : ");
		bookDTO.setRentprice(Integer.parseInt(sc.nextLine()));
		
		System.out.print("등급을 입력하세요 : ");
		bookDTO.setGrade(sc.nextLine());
		
		BookDAOImpl bookDAO = new BookDAOImpl();
		
		int result = bookDAO.insertBookDTO(bookDTO);
		
		if (result == 1)
			System.out.println("레코드 추가 성공");
		else
			System.out.println("레코드 추가 실패");
	}
}
