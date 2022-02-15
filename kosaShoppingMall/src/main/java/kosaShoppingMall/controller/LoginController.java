package kosaShoppingMall.controller;

import javax.servlet.http.HttpServletRequest;
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
			BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
	
			goodsListPageSerivce.execute(model); /////
			
			return "thymeleaf/index";
		}
		String path = loginService.execute(loginCommand, result, model, session);
		return path;
	}
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}