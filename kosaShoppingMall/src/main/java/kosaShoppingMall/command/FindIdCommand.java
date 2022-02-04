package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FindIdCommand {
	@NotBlank(message = "등록한 전화번호를 입력하세요.")
	String memberPhone;
	@NotBlank(message = "등록한 이메일을 입력하세요.")
	String memberEmail;
}
