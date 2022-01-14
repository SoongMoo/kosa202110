package springBootTest2.domain;

import lombok.Data;

@Data
public class BoardDTO {
	Integer boardNum;         
	String boardWriter;   
	String boardSubject;
	String boardContent; 
	String writerIp;   
	Integer visitCount;
}
