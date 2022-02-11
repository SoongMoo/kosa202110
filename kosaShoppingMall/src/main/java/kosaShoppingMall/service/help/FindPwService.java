package kosaShoppingMall.service.help;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;
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
			System.out.println("변경된 비밀번호 : " + tampPw);
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
			String content = "<html><body>"
					+ "안녕하세요 숭무쇼핑몰입니다. <br />'"
					+ findPasswordCommand.getUserId() + "'님의 "
					+ "임시 비밀번호는  <strong><b>["+ tampPw + "]</b></strong> 입니다. <br />"
					+ "반드시 로인인 후 비밀번호를 변경해 주세요. "
					+ "</body></html>";
			String subject = "임시비밀번호";
			try {
				msg.setHeader("content-type", "text/html; charset=UTF-8");
				// 내용을 담아서 보냄
				msg.setContent(content, "text/html; charset=UTF-8");
				msg.setSubject(subject);
				msg.setFrom(new InternetAddress("sender@gmail.com")); // 보내는 사람
				msg.setRecipient(MimeMessage.RecipientType.TO , 
						new InternetAddress(findPasswordCommand.getUserEmail())); // 받는 사람
				mailSender.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//
			return "thymeleaf/help/findPwOk";
		}
	}

}
