package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.LibraryCommand;
import springBootTest2.service.library.LibraryDeleteService;
import springBootTest2.service.library.LibraryInfoService;
import springBootTest2.service.library.LibraryListService;
import springBootTest2.service.library.LibraryModifyService;
import springBootTest2.service.library.LibraryUpdateService;
import springBootTest2.service.library.LibraryWriteService;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibraryWriteService libraryWriteService;
	@Autowired
	LibraryListService libraryListService;
	@Autowired
	LibraryInfoService libraryInfoService;
	@Autowired
	LibraryModifyService libraryModifyService;
	@Autowired
	LibraryUpdateService  libraryUpdateService ;
	@Autowired
	LibraryDeleteService  libraryDeleteService ;
	@RequestMapping("libDetele")
	public String libDetele(LibraryCommand libraryCommand, 
			HttpSession session,Model model) {
		String path = libraryDeleteService.execute(libraryCommand,session,model);
		return path;
	}
	@RequestMapping(value="libUpdate",method=RequestMethod.POST)
	public String libUpdate(LibraryCommand libraryCommand,
			HttpSession session,Model model) {
		String path = libraryUpdateService.execute(libraryCommand, session, model);
		return path;
	}
	@RequestMapping("libModify")
	public String libModify(@RequestParam(value="libNum") String libNum,
			@RequestParam(value="libPw") String libPw, Model model,
			HttpSession session) {
		String path = libraryModifyService.execute(libNum,libPw,model,session);
		return path;
	}
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value="num") String libNum,
			Model model) {
		libraryInfoService.execute(libNum, model);
		return "thymeleaf/lib/libInfo";
	}
	@RequestMapping(value="libWrite" , method=RequestMethod.POST)
	public String libWrite(LibraryCommand libraryCommand,
			HttpServletRequest request) {
		libraryWriteService.execute(libraryCommand, request);
		return "libList";
	}
	@RequestMapping("libForm")
	public String libForm() {
		return "thymeleaf/lib/libForm";
	}
	@RequestMapping("libList")
	public String libList(Model model,HttpServletRequest request) {
		libraryListService.execute(model, request);
		return "thymeleaf/lib/libList";
	}
}
