package kosaShoppingMall.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.service.goods.GoodsListPageSerivce;
import kosaShoppingMall.service.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@Autowired
	GoodsListPageSerivce goodsListPageSerivce;

	@RequestMapping(value = "/login/loginPro", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	@RequestMapping(value = "/login/loginPro", method = RequestMethod.POST)
	public String loginPro(@Validated LoginCommand loginCommand ,
			BindingResult result, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		if(result.hasErrors()) {
	
			goodsListPageSerivce.execute(request); 
			
			return "thymeleaf/index";
		}
		String path = loginService.execute(loginCommand, result, request, session, response);
		return path;
	}
	@RequestMapping("/login/logout")
	public String logout(HttpSession session , HttpServletResponse response) {
		Cookie cookie = new Cookie("autoLogin","");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		session.invalidate();
		return "redirect:/";
	}
}