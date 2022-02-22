package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginCommand {
	@NotBlank(message = "아이디를 입력해주세요.")
	String userId;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	String userPw;
	
	Boolean idStore;
	Boolean autoLogin;
}
