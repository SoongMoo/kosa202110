package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.MemberCommand;
import springBootTest2.service.member.MemberDeleteService;
import springBootTest2.service.member.MemberDetailService;
import springBootTest2.service.member.MemberListService;
import springBootTest2.service.member.MemberModifyService;
import springBootTest2.service.member.MemberNumberService;
import springBootTest2.service.member.MemberWriteService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService ;
	@RequestMapping("memberDelete")
	public String memberDelete(@RequestParam(value="num") String memNum) {
		memberDeleteService.execute(memNum);
		return "redirect:memberList";
	}
	@RequestMapping("memberUpdate")
	public String memberUpdate(MemberCommand memberCommand) {
		memberModifyService.execute(memberCommand);
		return "redirect:memberList";
	}
	@RequestMapping("memberModify")
	public String memberModify(@RequestParam(value="num") String memNum,
			Model model) {
		memberDetailService.execute(memNum,model);
		return "thymeleaf/member/memberUpdate";
	}
	@RequestMapping("memberDetail")
	public String memberDetail(@RequestParam(value="num") String memNum,
			Model model) {
		memberDetailService.execute(memNum,model);
		return "thymeleaf/member/memberInfo";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		memberWriteService.execute(memberCommand);
		return "redirect:memberList";
	}
	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	@RequestMapping("memberRegist")
	public String memberRegist(Model model) {
		memberNumberService.execute(model);
		return "thymeleaf/member/memberForm";
	}
}



