package kosaShoppingMall.service.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;
@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(LoginCommand loginCommand , HttpSession session,
			BindingResult result) {
		
		String aaa="thymeleaf/index";
		AuthInfo authInfo = loginMapper.loginSelect(loginCommand.getUserId());
		if(authInfo != null) {
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				aaa = "redirect:/";
			}else {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 틀렸습니다.");
			}
		}else {
			result.rejectValue("userId","loginCommand.userId","아이디가 존재하지 않습니다.");
		}
		return aaa;
	}
}
