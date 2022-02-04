package kosaShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("empMypage")
public class EmpMyPageController {
	@RequestMapping("empDetail")
	public String empDetail() {
		return "thymeleaf/employeesShip/empDetail";
	}
	
}
