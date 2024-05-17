package JDBC03;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberDTO {
	private int membernum;
	private String name;
	private String phone;
	private Date birth;
	private int bpoint;
	private String gender;
	private int age;
	
	public MemberDTO() {}
}
