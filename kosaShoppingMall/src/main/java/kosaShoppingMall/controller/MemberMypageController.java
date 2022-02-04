package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.service.memberJoin.MemberDropService;
import kosaShoppingMall.service.memberJoin.MemberInfoService;
import kosaShoppingMall.service.memberJoin.MemberPasswordService;
import kosaShoppingMall.service.memberJoin.MemberUpdateService;

@Controller
@RequestMapping("mypage")
public class MemberMypageController {
	@Autowired
	MemberInfoService memberInfoService ;
	@Autowired
	MemberUpdateService memberUpdateService ;
	@Autowired
	MemberPasswordService memberPasswordService;
	@Autowired
	MemberDropService memberDropService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public MemberCommand getMemberCommand() {
		return new MemberCommand();
	}
	
	
	@RequestMapping(value="memberDropOk",method=RequestMethod.POST)
	public String memberDropOk(MemberCommand memberCommand, BindingResult result
			,Model model, HttpSession session) {
		AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(memberCommand.getMemberPw(), authInfo.getUserPw())) {
			memberDropService.execute(authInfo.getUserId());
			return "redirect:/login/logout";
		}else {
			result.rejectValue("memberPw", "memberCommand.memberPw", "비밀번호가 틀렸습니다.");
			return "thymeleaf/membership/memberDrop";
		}
	}
	@RequestMapping("memberDrop")
	public String memberDrop(MemberCommand memberCommand) {
		return "thymeleaf/membership/memberDrop";
	}
	@RequestMapping(value="memberPassModify",method=RequestMethod.POST)
	public String memberPassModify(MemberCommand memberCommand, 
			BindingResult result , HttpSession session ) {
		String path = memberPasswordService.execute(memberCommand,result,session );
		return path;
	}
	@RequestMapping(value="memberPasswordPro",method=RequestMethod.POST)
	public String memberPasswordPro(@RequestParam(value="memPw") String pw,
			HttpSession session,Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(pw, authInfo.getUserPw())) {
			return "thymeleaf/membership/memberPassCon";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberPass";
		}
	}
	@RequestMapping("memberPass")
	public String memberPass() {
		return "thymeleaf/membership/memberPass";
	}
	@RequestMapping(value="memberInfoUpdate",method=RequestMethod.POST)
	public String memberInfoUpdate(MemberCommand memberCommand
			, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/membership/memModify";
		}
		String path = memberUpdateService.execute(memberCommand, session, result);
		return path;
	}
	@RequestMapping("memberInfoModify")
	public String memberInfoModify(Model model, HttpSession session) {
		memberInfoService.execute(model, session);
		return "thymeleaf/membership/memModify";
	}
	@RequestMapping("memberDetail")
	public String memInfo(Model model, HttpSession session) {
		memberInfoService.execute(model, session);
		return "thymeleaf/membership/memberInfo";
	}
}
