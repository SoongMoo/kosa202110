package springBootTest2.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmpLibraryCommand {
	String libWriter; // input type="text"
	//Date libEnterDate; // inpy type="Date"
 	String libSubject; // input type="text"
	String libContent; // input type="text"
	// Integer readCount ; // input type="number"
	String libPw;
	String libNum;
	MultipartFile [] report; // input type="file"
}
