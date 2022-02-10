package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.memberJoin.MemberDropService;
import kosaShoppingMall.service.memberJoin.MemberInfoService;
import kosaShoppingMall.service.memberJoin.MemberJoinService;
import kosaShoppingMall.service.memberJoin.MemberPasswordService;
import kosaShoppingMall.service.memberJoin.MemberUpdateService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@Autowired
	MemberJoinService  memberJoinService ;
	
	@ModelAttribute
	MemberCommand getMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/membership/agree";
	}
	@RequestMapping(value = "regist" , method = RequestMethod.GET)
	public String agree1() {
		return "thymeleaf/membership/agree";
	}
	@RequestMapping(value = "regist" , method = RequestMethod.POST)
	public String regist(@RequestParam(value = "agree", 
			defaultValue = "false" ) Boolean agree) {
		System.out.println(agree);
		if(agree == false) {
			return "thymeleaf/membership/agree";
		}
		return "thymeleaf/membership/memberJoinForm";
	}
	@RequestMapping(value = "memberJoinAction", method = RequestMethod.GET )
	public String memberJoinAction() {
		return "redirect:/register/agree";
	}
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService ;
	
	@RequestMapping(value = "memberJoinAction", method = RequestMethod.POST )
	public String memberJoinAction1(
			@Validated MemberCommand memberCommand, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "thymeleaf/membership/memberJoinForm";
		}
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPw", "memberCommand.memberPw", 
					"비밀번호 확인이 다릅니다.");
			return "thymeleaf/membership/memberJoinForm";
		}
		Integer i = idcheckService.execute(memberCommand.getMemberId());
		if(i == 1) {
			result.rejectValue("memberId", "memberCommand.memberId", 
					"중복 아이디입니다.");
			return "thymeleaf/membership/memberJoinForm";
		}
		i = emailCheckService.execute(memberCommand.getMemberEmail());
		if(i == 1) {
			result.rejectValue("memberEmail", "memberCommand.memberEmail", 
					"중복 Email입니다.");
			return "thymeleaf/membership/memberJoinForm";
		}
		memberJoinService.execute(memberCommand,model);
		return "thymeleaf/membership/welcome";
	}
}





