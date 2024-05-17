package JDBC03;

import java.util.List;

public interface MemberDAO {
	public List<MemberDTO> getMemberList();
	public int insertMember(MemberDTO member);
	public MemberDTO getMember(int memberNum);
	public int updateMember(MemberDTO member);
	public int deleteMember(int memberNum);
}
