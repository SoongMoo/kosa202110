package springBootTest2.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("emplibdto")
public class EmpLibraryDTO {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String empNum;
	String ipAddr;
	String libPw;
	String originalFileName;
	String storeFileName;
	String fileSize;
}





