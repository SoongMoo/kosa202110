package kosaShoppingMall.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.service.help.FindIdService;
import kosaShoppingMall.service.help.FindPwService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	FindIdService findIdService;
	@Autowired
	FindPwService findPwService;
	@RequestMapping(value="findPassword", method = RequestMethod.POST )
	public String findPassword(@Validated FindPasswordCommand findPasswordCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findPw";
		}
		return findPwService.execute(findPasswordCommand, result);
	}
	@RequestMapping(value="findPassword", method = RequestMethod.GET )
	public String findPassword(FindPasswordCommand findPasswordCommand) {
		return "thymeleaf/help/findPw";
	}
	@RequestMapping(value="findId", method = RequestMethod.GET)
	public String findId(FindIdCommand findIdCommand) {
		return "thymeleaf/help/findId";
	}
	@RequestMapping(value="findId", method = RequestMethod.POST)
	public String findIdOk(@Validated FindIdCommand findIdCommand,
			BindingResult result, Model model ,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		// if ~ else
		String path = findIdService.execute(findIdCommand, model, result);
		return path;
	}
}
