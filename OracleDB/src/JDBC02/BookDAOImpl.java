package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pwd = "1234";
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BookDTO> getBookList() {
		List<BookDTO> list = new ArrayList<>();
		conn = getConnection();
		
		String sql = "select * from booklist order by booknum desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new BookDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	@Override
	public int insertBookDTO(BookDTO bookDTO) {
		conn = getConnection();
		
		int result = 0;
		String sql = "insert into booklist values (book_seq.nextVal, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookDTO.getSubject());
			pstmt.setInt(2, bookDTO.getMakeyear());
			pstmt.setInt(3, bookDTO.getInprice());
			pstmt.setInt(4, bookDTO.getRentprice());
			pstmt.setString(5, bookDTO.getGrade());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public BookDTO getBook(int bookNum) {
		BookDTO bookDTO = null;
		
		conn = getConnection();
		
		String sql = "select * from booklist where booknum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bookDTO = new BookDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bookDTO;
	}

	@Override
	public int updateBookDTO(BookDTO bookDTO) {
		int result = 0;
		conn = getConnection();
		
		String sql = "update booklist set subject = ?, makeyear = ?, inprice = ?, rentprice = ?, grade = ? where booknum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookDTO.getSubject());
			pstmt.setInt(2, bookDTO.getMakeyear());
			pstmt.setInt(3, bookDTO.getInprice());
			pstmt.setInt(4, bookDTO.getRentprice());
			pstmt.setString(5, bookDTO.getGrade());
			pstmt.setInt(6, bookDTO.getBooknum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int deleteBookDTO(int bookNum) {
		int result = 0;
		conn = getConnection();
		
		String sql = "delete from booklist where booknum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
}
