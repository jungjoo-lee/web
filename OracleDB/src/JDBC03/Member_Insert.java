package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Member_Insert {
	public static void main(String[] args) throws ParseException {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		MemberDAOImpl memberDAO = new MemberDAOImpl();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.print("전화번호를 입력하세요 : ");
		String phone = sc.nextLine();

		System.out.print("생년월일을 입력하세요(YYYY-MM-DD) : ");
		Date date = format.parse(sc.nextLine());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		System.out.print("성별을 입력하세요(M/F) : ");
		String gender = sc.nextLine();

		Calendar today = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
		
		int result = memberDAO.insertMember(new MemberDTO(0, name, phone, sqlDate, 0, gender, age));		
		
		if (result == 1)
			System.out.println("레코드 추가 성공");
		else
			System.out.println("레코드 추가 실패");
	}
}
