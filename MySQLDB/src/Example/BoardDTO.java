package Example;

public class BoardDTO {
	private int boardNum;
	private String writer;
	private String name; // member 이름
	private String subject;
	private String content;
	private String email; // member 이메일
	private String writeDate;
	private int readCount;
	
	public BoardDTO() {}

	public BoardDTO(int boardNum, String writer, String name, String subject, String content, String email,
			String writeDate, int readCount) {
		this.boardNum = boardNum;
		this.writer = writer;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", writer=" + writer + ", name=" + name + ", subject=" + subject
				+ ", content=" + content + ", email=" + email + ", writeDate=" + writeDate + ", readCount=" + readCount
				+ "]";
	}
}
