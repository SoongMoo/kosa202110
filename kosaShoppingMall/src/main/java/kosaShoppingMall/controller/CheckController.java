package kosaShoppingMall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	@RequestMapping(value="idCheck", method = RequestMethod.POST)
	public String idCheck() {
		Integer i = 0;
		if(i == 0) {
			return "사용가능한 id입니다.";
		}else {
			return "사용중인 id입니다.";
		}
	}
}
