package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentDAOImpl implements RentDAO {
	private RentDAOImpl() {
	}

	private static RentDAOImpl itc = new RentDAOImpl();

	public static RentDAOImpl getInstance() {
		return itc;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<RentDTO> getRentList() {
		List<RentDTO> rentList = new ArrayList<>();
		conn = Dbman.getConnection();

		String sql = "select a.numseq, DATE_FORMAT(a.rentdate, '%Y-%m-%d %H:%i:%s'), a.bnum, c.subject, a.mnum, b.name, c.rentprice, a.discount, (c.rentprice - a.discount) "
				+ "from rentlist a, memberlist b, booklist c "
				+ "where a.mnum = b.membernum and a.bnum = c.booknum order by numseq desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rentList.add(new RentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return rentList;
	}

	@Override
	public int memberOk(int memberNum) {
		int result = 0;
		conn = Dbman.getConnection();

		String sql = "select * from memberlist where membernum = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return result;
	}

	@Override
	public int bookOk(int bookNum) {
		int result = 0;
		conn = Dbman.getConnection();

		String sql = "select * from booklist where booknum = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return result;
	}

	@Override
	public int insertRent(RentDTO rent) {
		int result = 0;
		conn = Dbman.getConnection();

		String sql = "insert into rentlist(bnum, mnum, discount) values (?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rent.getBnum());
			pstmt.setInt(2, rent.getMnum());
			pstmt.setInt(3, rent.getDiscount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return result;
	}

	@Override
	public RentDTO getRent(int rentNum) {
		RentDTO rent = null;
		conn = Dbman.getConnection();

		String sql = "select numseq, DATE_FORMAT(rentdate, '%Y-%m-%d %H:%i:%s'), bnum, mnum, discount from rentlist where numseq = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rentNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				rent = RentDTO.builder().numseq(rs.getInt(1)).rentdate(rs.getString(2)).bnum(rs.getInt(3)).mnum(rs.getInt(4)).discount(rs.getInt(5)).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return rent;
	}

	@Override
	public int updateRent(RentDTO rent) {
		int result = 0;
		conn = Dbman.getConnection();

		String sql = "update rentlist set rentdate = ?, bnum = ?, mnum = ?, discount = ? where numseq = ?";
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date date = format.parse(rent.getRentdate());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, sqlDate);
			pstmt.setInt(2, rent.getBnum());
			pstmt.setInt(3, rent.getMnum());
			pstmt.setInt(4, rent.getDiscount());
			pstmt.setInt(5, rent.getNumseq());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}

		return result;
	}

	@Override
	public int deleteRent(int numSeq) {
		int result = 0;
		conn = Dbman.getConnection();

		String sql = "delete from rentlist where numseq = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, numSeq);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
