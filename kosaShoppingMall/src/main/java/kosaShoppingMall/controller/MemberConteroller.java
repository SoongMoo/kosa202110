package kosaShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mem")
public class MemberConteroller {
	@RequestMapping("memList")
	public String memList() {
		return "thymeleaf/member/memberList";
	}
	@RequestMapping(value="memberRegist" ,method = RequestMethod.GET)
	public String memberForm() {
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value="memberRegist" ,method = RequestMethod.POST)
	public String memberFrom() {
		return null;
	}
	
}






