package Example;

import java.util.List;

public class BoardSelect {
	public static void main(String[] args) {
		BoardDAOImpl boardDAO = BoardDAOImpl.getInstance();
		List<BoardDTO> boardList = boardDAO.getBoardList();
		
		if (boardList.size() < 1) {
			System.out.println("게시판에 게시물이 없습니다.");
			return;
		}
		
		for (BoardDTO board : boardList) {
			System.out.println(board.toString());
		}
	}
}
