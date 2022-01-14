package springBootTest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qna")
public class QnAController {
	@RequestMapping("qnaWrite")
	public String qnaForm() {
		return "thymeleaf/qna/qnaForm";
	}
	@RequestMapping("qnaList")
	public String qnaHome() {
		return "thymeleaf/qna/qnaList";
	}
	
}
