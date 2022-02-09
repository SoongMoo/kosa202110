package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosaShoppingMall.service.IdcheckService;

@RestController
@RequestMapping("register")
public class CheckController {
	@Autowired
	IdcheckService idcheckService;
	@RequestMapping(value="idCheck", method = RequestMethod.POST)
	public String idCheck(@RequestParam(value = "memberId") String memberId) {
		System.out.println(memberId);
		Integer i = idcheckService.execute(memberId);
		if(i == 0) {
			return "사용가능한 id입니다.";
		}else {
			return "사용중인 id입니다.";
		}
	}
}
