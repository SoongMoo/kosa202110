package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.EmpLibraryCommand;
import springBootTest2.service.empLibrary.EmpLibraryDeleteService;
import springBootTest2.service.empLibrary.EmpLibraryInfoService;
import springBootTest2.service.empLibrary.EmpLibraryListService;
import springBootTest2.service.empLibrary.EmpLibraryModifyService;
import springBootTest2.service.empLibrary.EmpLibraryUpdateService;
import springBootTest2.service.empLibrary.EmpLibraryWriteService;
import springBootTest2.service.empLibrary.FileDownService;

@Controller
@RequestMapping("empLib")
public class EmpLibraryController {
	@Autowired
	EmpLibraryWriteService empLibraryWriteService;
	@Autowired
	EmpLibraryListService empLibraryListService;
	@Autowired
	EmpLibraryInfoService empLibraryInfoService;
	@Autowired
	EmpLibraryModifyService empLibraryModifyService;
	@Autowired
	EmpLibraryUpdateService  empLibraryUpdateService ;
	@Autowired
	EmpLibraryDeleteService  empLibraryDeleteService ;
	@Autowired
	FileDownService fileDownService;
	@RequestMapping("fileDown")
	public void fileDown(@RequestParam(value="sfile") String sfile,
			@RequestParam("ofile") String ofile,
			HttpServletRequest request, 
			HttpServletResponse response) {
		fileDownService.execute(sfile, ofile, request,response);
	}
	@RequestMapping("libDetele")
	public String libDetele(EmpLibraryCommand empLibraryCommand, 
			HttpSession session,Model model) {
		model.addAttribute("newLineChar", '\n');
		String path = empLibraryDeleteService.execute(empLibraryCommand,session,model);
		return path;
	}
	@RequestMapping(value="libUpdate",method=RequestMethod.POST)
	public String libUpdate(EmpLibraryCommand empLibraryCommand,
			HttpSession session,Model model) {
		String path = empLibraryUpdateService.execute(empLibraryCommand, session, model);
		return path;
	}
	@RequestMapping("libModify")
	public String libModify(@RequestParam(value="libNum") String libNum,
			@RequestParam(value="libPw") String libPw, Model model,
			HttpSession session) {
		model.addAttribute("newLineChar", '\n');
		String path = empLibraryModifyService.execute(libNum,libPw,model,session);
		return path;
	}
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value="num") String libNum,
			Model model,HttpSession session) {
		model.addAttribute("newLineChar", '\n');
		empLibraryInfoService.execute(libNum, model,session);
		return "thymeleaf/emplib/empLibInfo";
	}
	@RequestMapping(value="libWrite" , method=RequestMethod.POST)
	public String libWrite(EmpLibraryCommand empLibraryCommand,
			HttpServletRequest request) {
		empLibraryWriteService.execute(empLibraryCommand, request);
		return "redirect:libList";
	}
	@RequestMapping("libForm")
	public String libForm() {
		return "thymeleaf/emplib/empLibForm";
	}
	@RequestMapping("libList")
	public String libList(Model model,HttpServletRequest request) {
		empLibraryListService.execute(model, request);
		return "thymeleaf/emplib/empLibList";
	}
}
