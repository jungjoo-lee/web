package JDBC02;

import java.util.List;

public class Book_Select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// DAO : Data Access Object
		BookDAOImpl bookDAO = new BookDAOImpl();
		
		// DTO : Data Transfer Object
		List<BookDTO> list = bookDAO.getBookList();
		
		for (BookDTO bookDTO : list) {
			System.out.println(bookDTO.toString());
		}
	}
}
