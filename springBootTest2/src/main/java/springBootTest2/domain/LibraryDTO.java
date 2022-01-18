package springBootTest2.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("libdto")
public class LibraryDTO {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String memId;
	String ipAddr;
	String libPw;
}
