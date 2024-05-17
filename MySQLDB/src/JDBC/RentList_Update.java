package JDBC;

import java.util.Scanner;

public class RentList_Update {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RentDAOImpl rentDAO = RentDAOImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 대여기록의 대여번호를 입력하세요 : ");
		int rentNum = Integer.parseInt(sc.nextLine());
		
		RentDTO rentDTO = rentDAO.getRent(rentNum);
		
		if(rentDTO == null) {
			System.out.println("입력한 대여번호의 대여기록이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("대여날짜 : " + rentDTO.getRentdate());
		System.out.print("수정할 대여날짜 입력하세요(수정하지 않으려면 Enter입력) : ");
		String rentDate = sc.nextLine();
		if(!rentDate.equals(""))
			rentDTO.setRentdate(rentDate);
		
		int bNum;
		while (true) {
			System.out.println("도서번호 : " + rentDTO.getBnum());
			System.out.print("수정할 도서번호를 입력하세요 : ");
			bNum = Integer.parseInt(sc.nextLine());

			int result = rentDAO.bookOk(bNum);

			if (result == 0) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요.");
				continue;
			} else {
				rentDTO.setBnum(bNum);
				break;
			}
		}

		int mNum;
		while (true) {
			System.out.println("회원번호 : " + rentDTO.getMnum());
			System.out.print("수정할 회원번호를 입력하세요 : ");
			mNum = Integer.parseInt(sc.nextLine());

			int result = rentDAO.memberOk(mNum);
			
			if (result == 0) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요.");
				continue;
			} else {
				rentDTO.setMnum(mNum);
				break;
			}
		}
		
		System.out.println("할인금액 : " + rentDTO.getDiscount());
		System.out.print("수정할 할인금액을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String discount = sc.nextLine();
		if(!discount.equals(""))
			rentDTO.setDiscount(Integer.parseInt(discount));
		
		int result = rentDAO.updateRent(rentDTO);
		
		if (result == 1)
			System.out.println("수정 성공");
		else
			System.out.println("수정 실패");
	}
}
