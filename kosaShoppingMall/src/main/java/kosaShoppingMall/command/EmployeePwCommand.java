package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeePwCommand {
	@NotBlank(message = "기존 비밀번호를 입력하세요")
	String empPw;
	@NotBlank(message = "변경하실 비밀번호를 입력하세요")
	String newEmpPw;
	@NotBlank(message = "변경하실 비밀번호확인를 입력하세요")
	String newEmpPwCon;
}
