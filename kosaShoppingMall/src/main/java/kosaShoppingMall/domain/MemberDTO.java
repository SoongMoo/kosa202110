package kosaShoppingMall.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias(value = "memDTO")
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
	public MemberDTO() {}
	public MemberDTO(String memberNum, String memberId, String memberPw, String memberName, String memberAddr,
			Timestamp memberRegist, String gender, String memberPhone, Date memberBirth, String memberEmail,
			String memberOk) {
		super();
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberRegist = memberRegist;
		this.gender = gender;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberEmail = memberEmail;
		this.memberOk = memberOk;
	}
}
