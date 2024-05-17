package JDBC02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDTO {
	private int booknum;
	private String subject;
	private int makeyear;
	private int inprice;
	private int rentprice;
	private String grade;
	
	public BookDTO() {}
}
