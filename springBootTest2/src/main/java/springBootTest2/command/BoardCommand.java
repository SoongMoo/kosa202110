package springBootTest2.command;

import lombok.Data;

@Data
public class BoardCommand {
	Integer boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
}
