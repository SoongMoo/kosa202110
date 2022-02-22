package kosaShoppingMall.service.login;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.LoginMapper;
@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	public String execute(LoginCommand loginCommand ,BindingResult result, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		
		List<GoodsDTO> list = goodsMapper.goodsList(new StartEndPageDTO());
		request.setAttribute("lists", list);
		
		
		String aaa="thymeleaf/index";
		AuthInfo authInfo = loginMapper.loginSelect(loginCommand.getUserId());
		
		if(authInfo != null) {
			
			if(authInfo.getMemberOk() == null && authInfo.getGrade().equals("mem")) {
				result.rejectValue("userId","loginCommand.userId","이메일을 확인해주세요.");
			}
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				if(loginCommand.getAutoLogin() != null && loginCommand.getAutoLogin()) {
					Cookie cookie = new Cookie("autoLogin",authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if(loginCommand.getIdStore() != null && loginCommand.getIdStore()) {
					// 쿠키는 문자열만 저장 가능
					Cookie cookie = new Cookie("idStore",authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("idStore","");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				return "redirect:/";
			}else {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 틀렸습니다.");
			}
		}else {
			result.rejectValue("userId","loginCommand.userId","아이디가 존재하지 않습니다.");
		}
		return aaa;
	}
}
