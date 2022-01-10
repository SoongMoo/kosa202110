package springTest.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/hello")
	public String test() {
		return "thymeleaf/test/hello";
	}
}
