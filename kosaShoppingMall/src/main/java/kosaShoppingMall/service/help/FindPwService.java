package kosaShoppingMall.service.help;

import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;
import kosaShoppingMall.mapper.LoginMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class FindPwService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String  execute(FindPasswordCommand findPasswordCommand, BindingResult result) {
		String grade = loginMapper.findPw(findPasswordCommand);
		if(grade == null) {
			result.rejectValue("userId", "findPasswordCommand.userId", "정보가 부족합니다.");
			return "thymeleaf/help/findPw";
		}else {
			String tampPw = UUID.randomUUID().toString().substring(0, 7);
			String pw = passwordEncoder.encode(tampPw);
			System.out.println(tampPw);
			AuthInfo authInfo = new AuthInfo();
			authInfo.setUserId(findPasswordCommand.getUserId());
			authInfo.setUserPw(pw);
			if(grade.equals("mem")) {
				memberMapper.changPw(authInfo);
			}else if(grade.equals("emp")) {
				employeeMapper.changPw(authInfo);
			}
			
			
			// 메일링
			MimeMessage msg = mailSender.createMimeMessage();
			
			
			//
			return "thymeleaf/help/findPwOk";
		}
	}

}
