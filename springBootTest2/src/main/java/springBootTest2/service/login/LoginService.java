package springBootTest2.service.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.mapper.LoginMapper;
@Component
@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	public String execute(String id, String pw, HttpSession session,
			Model model) {
		
		String aaa="thymeleaf/index";
		
		AuthInfo authInfo = loginMapper.loginSelect(id);
		if(authInfo != null) {
			if(authInfo.getUserPw().equals(pw)) {
				session.setAttribute("authInfo", authInfo);
				aaa = "redirect:/";
			}else {
				model.addAttribute("err_pw", "비밀번호가 틀렸습니다.");
			}
		}else {
			model.addAttribute("err_id","아이디가 존재하지 않습니다.");
		}
		return aaa;
	}
}
