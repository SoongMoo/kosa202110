package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
public class FindPasswordCommand {
	@NotBlank(message = "아이디를 입력해주세요.")
	String userId;
	@NotBlank(message = "연락처를 입력해주세요.")
	String userPhone;
	@NotBlank(message = "이메일을 입력해주세요.")
	String userEmail;
}
