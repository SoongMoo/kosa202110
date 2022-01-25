package springBootTest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ajax")
public class AjaxController {
	@RequestMapping("ajax1")
	public String ajax() {
		return "thymeleaf/ajax/AjaxTest";
	}
	@RequestMapping("ajax2")
	public String ajax2(@RequestParam(value="num") String num,Model model) {
		model.addAttribute("aaa",num);
		return "thymeleaf/ajax/AjaxTest2";
	}
	@RequestMapping("ajax3")
	public String ajax3() {
		return "thymeleaf/ajax/AjaxTest1";
	}
}





