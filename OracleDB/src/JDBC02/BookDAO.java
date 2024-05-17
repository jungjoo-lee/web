package JDBC02;

import java.util.List;

public interface BookDAO {
	public List<BookDTO> getBookList();
	public int insertBookDTO(BookDTO bookDTO);
	public BookDTO getBook(int bookNum);
	public int updateBookDTO(BookDTO bookDTO);
	public int deleteBookDTO(int bookNum);
}
