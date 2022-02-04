package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberPwCommand {
	@NotBlank(message = "현재 비밀번호를 입력하세요.")
	String oldPw;
	@NotBlank(message = "새로운 비밀번호를 입력하세요.")
	String memberPw;
	@NotBlank(message = "새로운 비밀번호확인을 입력하세요.")
	String memberPwCon;
	
	public Boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
