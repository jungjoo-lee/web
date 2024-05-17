package JDBC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RentDTO {
	private int numseq;
	private String rentdate;
	private int bnum;
	private String subject;
	private int mnum;
	private String name;
	private int rentprice;
	private int discount;
	private int amout;
	
	public RentDTO() {}
}
