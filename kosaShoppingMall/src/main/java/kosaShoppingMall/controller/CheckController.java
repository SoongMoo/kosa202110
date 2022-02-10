package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdcheckService;

@RestController
public class CheckController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService ;
	@RequestMapping(value="/register/emailCheck",method = RequestMethod.POST)
	public String emailCheck(@RequestParam(value="memberEmail") String memberEmail) {
		Integer i = emailCheckService.execute(memberEmail);
		if(i == 0) {
			return "사용가능한 email입니다.";
		}else {
			return "사용중인 email입니다.";
		}
	}
	@RequestMapping(value="/register/idCheck",method = RequestMethod.POST)
	public String idCheck(@RequestParam(value="memberId") String memberId) {
		Integer i = idcheckService.execute(memberId);
		if(i == 0) {
			return "사용가능한 id입니다.";
		}else {
			return "사용중인 id입니다.";
		}
	}
}
