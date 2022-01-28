package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "memDTO")
public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberAddr;
	Date memberRegist;
	String gender;
	String memberPhone;
	Date memberBirth;
	String memberEmail;
}
