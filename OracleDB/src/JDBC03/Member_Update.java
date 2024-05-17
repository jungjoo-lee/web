package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Member_Update {
	public static void main(String[] args) throws ParseException {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 회원의 회원번호를 입력하세요 : ");
		int memberNum = Integer.parseInt(sc.nextLine());
		
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		MemberDTO memberDTO = memberDAO.getMember(memberNum);
		
		if(memberDTO == null) {
			System.out.println("입력한 회원번호의 회원이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			
			return;
		}
		
		System.out.println("이름 : " + memberDTO.getName());
		System.out.print("수정할 이름을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String name = sc.nextLine();
		if(!name.equals(""))
			memberDTO.setName(name);
		
		System.out.println("전화번호 : " + memberDTO.getPhone());
		System.out.print("수정할 전화번호를 입력하세요(수정하지 않으려면 Enter입력) : ");
		String phone = sc.nextLine();
		if(!phone.equals(""))
			memberDTO.setPhone(phone);
		
		System.out.println("생년월일 : " + memberDTO.getBirth());
		System.out.print("수정할 생년월일을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String birth = sc.nextLine();
		if(!birth.equals("")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(birth);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			memberDTO.setBirth(sqlDate);
			
			Calendar today = Calendar.getInstance();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			
			memberDTO.setAge(today.get(Calendar.YEAR) - c.get(Calendar.YEAR));
		}
		
		System.out.println("bPoint : " + memberDTO.getBpoint());
		System.out.print("수정할 bPoint을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String bpoint = sc.nextLine();
		if(!bpoint.equals(""))
			memberDTO.setBpoint(Integer.parseInt(bpoint));
		
		System.out.println("성별 : " + memberDTO.getGender());
		System.out.print("수정할 성별을 입력하세요(수정하지 않으려면 Enter입력) : ");
		String gender = sc.nextLine();
		if(!gender.equals(""))
			memberDTO.setGender(gender);
		
		int result = memberDAO.updateMember(memberDTO);
		
		if (result == 1)
			System.out.println("레코드 수정 성공");
		else
			System.out.println("레코드 수정 실패");
	}
}
