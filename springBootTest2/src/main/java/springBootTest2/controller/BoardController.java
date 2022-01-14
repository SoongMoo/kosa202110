package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springBootTest2.command.BoardCommand;
import springBootTest2.service.board.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	

	@Autowired 
	BoardWriteService boardWriteService;
	  
	@RequestMapping(value="boardRegist" , method = RequestMethod.POST) 
	public String boardRegist(BoardCommand boardCommand,
			HttpServletRequest request) {
		 boardWriteService.execute(boardCommand, request); 
		 return "redirect:boardList"; 
	}

	 
	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	@RequestMapping("boardList")
	public String boardList() {				
		return "thymeleaf/board/boardList";
	}
}
