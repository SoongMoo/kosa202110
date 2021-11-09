
public class Board {
	// 번호 , 제목,  글쓴이 , 내용, 글쓴의 ip주소, 방문자수
	// 멤버필드
	int num;
	String subject;
	String writer;
	String content;
	String ip;
	int readCount;
	// 생성자
	public Board() {}
	public Board(int num, String subject, String writer,
			String content, String ip, int readCount) {
		this.num = num;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.ip = ip;
		this.readCount = readCount;
	}
	// 메서드
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

}
