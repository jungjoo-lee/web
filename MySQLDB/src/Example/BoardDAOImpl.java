package Example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {
	private BoardDAOImpl() {}

	private static BoardDAOImpl itc = new BoardDAOImpl();

	public static BoardDAOImpl getInstance() {
		return itc;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = new ArrayList<>();
		conn = DataBaseManager.getConnection();
		
		String sql = "select b.boardnum, b.writer, a.name, b.subject, b.content, a.email, DATE_FORMAT(b.writeDate, '%Y-%m-%d'), b.readCount "
				+ "from member a inner join board b on a.userid = b.writer";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardList.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseManager.close(conn, pstmt, rs);
		}
		
		return boardList;
	}

}
