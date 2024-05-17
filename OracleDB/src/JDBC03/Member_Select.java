package JDBC03;

import java.util.List;

public class Member_Select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		
		List<MemberDTO> memberList = memberDAO.getMemberList();
		
		for (MemberDTO member : memberList) {
			System.out.println(member.toString());
		}
	}
}
