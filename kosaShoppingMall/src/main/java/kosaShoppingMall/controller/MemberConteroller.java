package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.MemEmailUpdateCkService;
import kosaShoppingMall.service.member.MemberDeleteService;
import kosaShoppingMall.service.member.MemberDelsService;
import kosaShoppingMall.service.member.MemberDetailService;
import kosaShoppingMall.service.member.MemberList1Service;
import kosaShoppingMall.service.member.MemberListService;
import kosaShoppingMall.service.member.MemberModifyService;
import kosaShoppingMall.service.member.MemberNumberService;
import kosaShoppingMall.service.member.MemberRegistService;

@Controller
@RequestMapping("mem")
public class MemberConteroller {
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberRegistService memberRegistService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService ;
	@Autowired
	MemberDeleteService memberDeleteService ;
	@Autowired
	MemberDelsService memberDelsService;
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	MemEmailUpdateCkService memEmailUpdateCkService;
	/*
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	*/
	
	@RequestMapping(value = "memberDels" , method = RequestMethod.POST)
	public String memberDels(@RequestParam(value = "memDels") String[] memDels) {
		memberDelsService.execute(memDels);
		return "redirect:memList";
	}
	
	@RequestMapping(value = "memberDelete")
	public String memberDelete(@RequestParam(value = "num") String memberNum,
			Model model) {
		memberDeleteService.execute(memberNum , model);
		return "thymeleaf/member/memberdel";
	//	return "member/memberdel";
	}
	@RequestMapping(value="memberModify" , method = RequestMethod.GET)
	public String memberModify(@RequestParam(value="memberNum") 
				String memberNum ,Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	//	return "member/memberUpdate";
	}
	@RequestMapping(value="memberModify" , method = RequestMethod.POST)
	public String memberUpdate(@Validated MemberCommand memberCommand, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberUpdate";
		//	return "member/memberUpdate";
		}
		Integer i = memEmailUpdateCkService.execute(memberCommand.getMemberEmail(),memberCommand.getMemberId());
		if(i == 1) {
			result.rejectValue("memberEmail", "memberCommand.memberEmail", "중복된 이메일입니다.");
			return "thymeleaf/member/memberUpdate";
		}
		memberModifyService.execute(memberCommand);
		return "redirect:memberDetail/"+memberCommand.getMemberNum();
	}
	@RequestMapping(value="memberDetail/{num}")
	public String memberDetail(@PathVariable(value = "num") String memberNum,
			Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	//	return "member/memberDetail";
	}
	@RequestMapping(value="memList1")
	public ModelAndView memList1(@RequestParam(value = "memberWord" ,required = false)String memberWord,
			@RequestParam(value="page", defaultValue = "1", required = false) Integer page, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");	
		memberListService.execute(model, page ,memberWord);
	    return mav;
	}
	@RequestMapping(value="memList")
	public String memList(
			@RequestParam(value = "memberWord" ,required = false)String memberWord,
			@RequestParam(value="page", defaultValue = "1", required = false) Integer page, Model model
			) {
		memberListService.execute(model, page ,memberWord);
		return "thymeleaf/member/memberList1";
		//return "thymeleaf/member/memberList";
		//return "member/memberList";
	}

	@RequestMapping(value="memberRegist" ,method = RequestMethod.GET)
	public String memberForm(MemberCommand memberCommand,Model model) {
		memberNumberService.execute(memberCommand,model);
		return "thymeleaf/member/memberForm";
		//return "member/memberForm";
	}
	@RequestMapping(value="memberRegist" ,method = RequestMethod.POST)
	public String memberFrom(@Validated MemberCommand memberCommand, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/member/memberForm";
			//return "member/memberForm";
		}
		
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPw", "memberCommand.memberPw", 
					"비밀번호 확인이 다릅니다.");
			return "thymeleaf/member/memberForm";
			//return "member/memberForm";
		}
		Integer i = emailCheckService.execute(memberCommand.getMemberEmail());
		if(i == 1) {
			result.rejectValue("memberEmail", "memberCommand.memberEmail", "사용중인 아이디입니다.");
			return "thymeleaf/member/memberForm";
		}	
		
		
		i = idcheckService.execute(memberCommand.getMemberId());
		if(i == 1) {
			result.rejectValue("memberId", "memberCommand.memberId", 
					"중복 아이디입니다.");
			return "thymeleaf/member/memberForm";
		}
		memberRegistService.execute(memberCommand);
		return "redirect:memList";
	}
}



