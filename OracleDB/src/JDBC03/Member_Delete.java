package JDBC03;

import java.util.Scanner;

public class Member_Delete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int result = 0;
		
		System.out.print("삭제할 회원의 회원번호를 입력하세요 : ");
		int memberNum = Integer.parseInt(sc.nextLine());
		
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		MemberDTO member = memberDAO.getMember(memberNum);
		
		if(member == null) {
			System.out.println("입력한 회원번호의 회원이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("이름 : " + member.getName());
		System.out.print("삭제하시겠습니까?(1. yes, 2. no) : ");
		select = Integer.parseInt(sc.nextLine());
		
		if(select == 1)
			result = memberDAO.deleteMember(memberNum);
		
		if (result == 1)
			System.out.println("레코드 삭제 성공");
		else
			System.out.println("레코드 삭제 실패");
	}
}
