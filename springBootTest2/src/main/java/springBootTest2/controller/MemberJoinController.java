package springBootTest2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.service.membership.MemberDropService;
import springBootTest2.service.membership.MemberInfoService;
import springBootTest2.service.membership.MemberJoinService;
import springBootTest2.service.membership.MemberPasswordService;
import springBootTest2.service.membership.MemberUpdateService;

@Controller
@RequestMapping("membership")
public class MemberJoinController {
	@Autowired
	MemberJoinService  memberJoinService ;
	@Autowired
	MemberInfoService memberInfoService ;
	@Autowired
	MemberUpdateService memberUpdateService ;
	@Autowired
	MemberPasswordService memberPasswordService;
	@Autowired
	MemberDropService memberDropService;
	@RequestMapping(value="memberDropOk",method=RequestMethod.POST)
	public String memberDropOk(
			@RequestParam(value="memPw") String memPw,Model model,
			HttpSession session) {
		AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
		if(authInfo.getUserPw().equals(memPw)) {
			memberDropService.execute(authInfo.getUserId());
			return "redirect:/logout";
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberDrop";
		}
	}
	@RequestMapping("memberDrop")
	public String memberDrop() {
		return "thymeleaf/membership/memberDrop";
	}
	@RequestMapping(value="memberPassModify",method=RequestMethod.POST)
	public String memberPassModify(@RequestParam(value="memPw") String oldPw,
			@RequestParam(value="newMemPw") String newPw,
			@RequestParam(value="newMemPwCon") String newPwCon,
			HttpSession session,Model model ) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo.getUserPw().equals(oldPw)) {
			if(newPw.equals(newPwCon) && !newPw.isEmpty()) {
				memberPasswordService.execute(authInfo.getUserId(),newPw);
				authInfo.setUserPw(newPw);
				return "redirect:memInfo";
			}else {
				model.addAttribute("err_pwCon", "비밀번호확인이 다릅니다.");
				return "thymeleaf/membership/memberPassCon";
			}
		}else {
			model.addAttribute("err_pw", "비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberPassCon";
		}
	}
	@RequestMapping(value="memberPasswordPro",method=RequestMethod.POST)
	public String memberPasswordPro(@RequestParam(value="memPw") String pw,
			HttpSession session,Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo.getUserPw().equals(pw)) {
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
	public String memberInfoUpdate(MemberCommand memberCommand,
			HttpSession session) {
		String path = memberUpdateService.execute(memberCommand, session);
		return path;
	}
	@RequestMapping("memberInfoModify")
	public String memberInfoModify(Model model, HttpSession session) {
		memberInfoService.execute(model, session);
		return "thymeleaf/membership/memModify";
	}
	@RequestMapping("memInfo")
	public String memInfo(Model model, HttpSession session) {
		memberInfoService.execute(model, session);
		return "thymeleaf/membership/memInfo";
	}
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





