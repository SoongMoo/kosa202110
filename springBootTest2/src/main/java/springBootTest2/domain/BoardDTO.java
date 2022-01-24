package springBootTest2.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	Integer boardNum;         
	String boardWriter;   
	String boardSubject;
	Date boardDate;
	String boardContent; 
	String writerIp;   
	Integer visitCount;
}