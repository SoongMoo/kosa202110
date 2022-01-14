package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.BoardCommand;
import springBootTest2.service.board.BoardDelService;
import springBootTest2.service.board.BoardDetailService;
import springBootTest2.service.board.BoardInfoService;
import springBootTest2.service.board.BoardListService;
import springBootTest2.service.board.BoardModifyService;
import springBootTest2.service.board.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	

	@Autowired 
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService ;
	@Autowired
	BoardDelService boardDelService;
	@Autowired
	BoardInfoService boardInfoService;
	@Autowired
	BoardModifyService boardModifyService;
	@RequestMapping(value = "boardModify" ,  method = RequestMethod.POST)
	public String  boardModify(BoardCommand boardCommand) {
		boardModifyService.execute(boardCommand);
		return "redirect:boardDetail?num="+boardCommand.getBoardNum();
	}
	@RequestMapping("boardUpdate")
	public String boardUpdate(HttpServletRequest request) {
		boardInfoService.execute(request);
		return "thymeleaf/board/boardDetail";
	}
	
	@RequestMapping(value = "boardDel", method = RequestMethod.GET)
	public String boardDel(@RequestParam(value="num") Integer boardNum) {
		boardDelService.execute(boardNum);
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "boardDetail" ,method = RequestMethod.GET)
	/*
	 * 	String num = request.getParameter("num");
		Integer boardNum = Integer.parseInt(num);
	 * 
	 *  @RequestParam(value = "num") Integer boardNum
	 */
	public String boardDetail(@RequestParam(value = "num") Integer boardNum,
			Model model) {
		boardDetailService.execute(model, boardNum);
		return "thymeleaf/board/boardInfo";
	}
	
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
	public String boardList(Model model) {	
		boardListService.execute(model);
		return "thymeleaf/board/boardList";
	}
}
