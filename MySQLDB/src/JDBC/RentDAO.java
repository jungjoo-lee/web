package JDBC;

import java.util.List;

public interface RentDAO {
	public List<RentDTO> getRentList();
	public int memberOk(int memberNum);
	public int bookOk(int bookNum);
	public int insertRent(RentDTO rent);
	public RentDTO getRent(int rentNum);
	public int updateRent(RentDTO rent);
	public int deleteRent(int numSeq);
}
