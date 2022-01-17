package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootTest2.command.MemberCommand;
import springBootTest2.service.membership.MemberJoinService;

@Controller
@RequestMapping("membership")
public class MemberJoinController {
	@Autowired
	MemberJoinService  memberJoinService ;
	@RequestMapping("memberAgree")
	public String memberAgree() {
		return "thymeleaf/membership/agree";
	}
	@RequestMapping("memberJoin")
	public String memberJoin() {
		return "thymeleaf/membership/membeForm";
	}
	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		memberJoinService.execute(memberCommand);
		return "thymeleaf/membership/welcome";
	}
}





