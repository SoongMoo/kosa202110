package springBootTest2.command;

import lombok.Data;

@Data
public class BoardCommand {
	String boardWriter;
	String boardSubject;
	String boardContent;
}
