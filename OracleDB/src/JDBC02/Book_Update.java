package JDBC02;

import java.util.Scanner;

public class Book_Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 도서의 도서번호를 입력하세요 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		
		BookDAOImpl bookDAO = new BookDAOImpl();
		BookDTO bookDTO = bookDAO.getBook(bookNum);
		
		if(bookDTO == null) {
			System.out.println("입력한 도서번호의 도서가 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("제목 : " + bookDTO.getSubject());
		System.out.print("수정할 제목을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String subject = sc.nextLine();
		if(!subject.equals(""))
			bookDTO.setSubject(subject);
		
		System.out.println("출판년도 : " + bookDTO.getMakeyear());
		System.out.print("수정할 출판년도을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String makeyear = sc.nextLine();
		if(!makeyear.equals(""))
			bookDTO.setMakeyear(Integer.parseInt(makeyear));
		
		System.out.println("입고가격 : " + bookDTO.getInprice());
		System.out.print("수정할 입고가격을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String inprice = sc.nextLine();
		if(!inprice.equals(""))
			bookDTO.setInprice(Integer.parseInt(inprice));
		
		System.out.println("대여가격 : " + bookDTO.getRentprice());
		System.out.print("수정할 대여가격을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String rentprice = sc.nextLine();
		if(!rentprice.equals(""))
			bookDTO.setRentprice(Integer.parseInt(rentprice));
		
		System.out.println("등급 : " + bookDTO.getGrade());
		System.out.print("수정할 등급을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String grade = sc.nextLine();
		if(!grade.equals(""))
			bookDTO.setGrade(grade);
		
		int result = bookDAO.updateBookDTO(bookDTO);
		
		if (result == 1)
			System.out.println("레코드 수정 성공");
		else
			System.out.println("레코드 수정 실패");
	}
}
