package springBootTest2.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("memberDTO")
public class MemberDTO {
	String memNum; 
	String memName;
	Date memRegiDate;
	String memId;
	String memPw;
	String memPhone1;
	String memPhone2;
	String memAddr;
	String memEmail;
	String memGender;
	Date memBirth;
}
