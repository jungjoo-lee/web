package JDBC;

import java.util.List;

public class RentList_Select {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RentDAOImpl rentDAO = RentDAOImpl.getInstance();
		List<RentDTO> rentList = rentDAO.getRentList();
		
		for (RentDTO rent : rentList) {
			System.out.println(rent.toString());
		}
	}
}
