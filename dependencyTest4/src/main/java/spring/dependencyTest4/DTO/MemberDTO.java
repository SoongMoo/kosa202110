package spring.dependencyTest4.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private Long id;
	private String email;
	private String name;
	private String password;
	private Date registerDate;
	
	public void changePassword(String oldPw, String newPw) {
		if(password.equals(oldPw)) {
			password = newPw;
		}else {
			System.out.println("비밀번호가 틀립니다.");
		}
	}
	
}