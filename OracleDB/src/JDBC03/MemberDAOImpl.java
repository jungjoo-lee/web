package JDBC03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC02.BookDTO;

public class MemberDAOImpl implements MemberDAO {
	DataBaseManager dbm = new DataBaseManager();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = new ArrayList<>();
		conn = dbm.getConnection();

		String sql = "select * from memberlist";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberList.add(new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}

		return memberList;
	}

	@Override
	public int insertMember(MemberDTO member) {
		int result = 0;

		conn = dbm.getConnection();

		String sql = "insert into memberlist values(member_seq.nextVal, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setDate(3, member.getBirth());
			pstmt.setInt(4, member.getBpoint());
			pstmt.setString(5, member.getGender());
			pstmt.setInt(6, member.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	@Override
	public MemberDTO getMember(int memberNum) {
		MemberDTO member = null;
		
		conn = dbm.getConnection();
		
		String sql = "select * from memberlist where membernum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return member;
	}

	@Override
	public int updateMember(MemberDTO member) {
		int result = 0;
		conn = dbm.getConnection();
		
		String sql = "update memberlist set name = ?, phone = ?, birth = ?, bpoint = ?, gender = ?, age = ? where membernum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setDate(3, member.getBirth());
			pstmt.setInt(4, member.getBpoint());
			pstmt.setString(5, member.getGender());
			pstmt.setInt(6, member.getAge());
			pstmt.setInt(7, member.getMembernum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return result;
	}

	@Override
	public int deleteMember(int memberNum) {
		int result = 0;
		conn = dbm.getConnection();
		
		String sql = "delete from memberlist where membernum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
