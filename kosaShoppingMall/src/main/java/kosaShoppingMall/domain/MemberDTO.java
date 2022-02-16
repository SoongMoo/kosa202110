package kosaShoppingMall.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias(value = "memDTO")
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	String memberAddr;
	Timestamp memberRegist;
	String gender;
	String memberPhone;
	Date memberBirth;
	String memberEmail;
	String memberOk;
}
