package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.command.EmployeePwCommand;
import kosaShoppingMall.service.EmpEmailUpdatecheckService;
import kosaShoppingMall.service.empMyPage.EmpMyPageModifyService;
import kosaShoppingMall.service.empMyPage.EmpMyPagePwService;
import kosaShoppingMall.service.empMyPage.EmpMyPageUpdateService;
import kosaShoppingMall.service.empMyPage.empMyPageDetailService;

@Controller
@RequestMapping("empMypage")
public class EmpMyPageController {
	@Autowired
	empMyPageDetailService empMyPageDetailService;
	@Autowired
	EmpMyPageModifyService empMyPageModifyService;
	@Autowired
	EmpMyPageUpdateService empMyPageUpdateService;
	@Autowired
	EmpMyPagePwService empMyPagePwService;
	@Autowired
	EmpEmailUpdatecheckService empEmailUpdatecheckService;
	
	@RequestMapping(value ="empPwChangeCon" , method = RequestMethod.POST)
	public String empPwChangeCon(@Validated EmployeePwCommand employeePwCommand , BindingResult result , HttpSession session) {
		String path = empMyPagePwService.execute(employeePwCommand , result , session);
			return path;
	}
		
	@RequestMapping(value = "empPwChange" , method = RequestMethod.GET)
	public String empPwChange( EmployeePwCommand employeePwCommand) {
		return "thymeleaf/employeesShip/empPwChange";
	}
	
	
	@RequestMapping(value = "empUpdate", method = RequestMethod.POST)
	public String empUpdate(@Validated EmployeeCommand employeeCommand, BindingResult result, HttpSession  session) {
		Integer i = empEmailUpdatecheckService.execute(employeeCommand.getEmpEmail() , employeeCommand.getEmpId());
		if(i == 1) {
			result.rejectValue("empEmail","employeeCommand.empEmail" , "중복된 이메일 입니다.");
			return "thymeleaf/employeesShip/empUpdate";
		}
		String path = empMyPageUpdateService.execute(employeeCommand, result, session);
		return path;
	}

	@RequestMapping(value = "empModify", method = RequestMethod.POST)
	public String empModify(@Validated EmployeePwCommand employeePwCommand, BindingResult result, HttpSession session,
			EmployeeCommand employeeCommand, Model model) {
		String path = empMyPageModifyService.execute(employeePwCommand, result, session, employeeCommand, model);
		return path;
	}

	@RequestMapping(value = "empModifyBiforPw", method = RequestMethod.GET)
	public String empModifyBiforPw(EmployeePwCommand employeePwCommand) {

		return "thymeleaf/employeesShip/empModifyPw";
	}

	@RequestMapping(value = "empDetail", method = RequestMethod.GET)
	public String empDetail(HttpSession session, Model model) {
		empMyPageDetailService.execute(session, model);
		return "thymeleaf/employeesShip/empDetail";
	}

	///////////////// 다르게 오면 전부 태초마을로 ! ///////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "empPwChangeCon", method = RequestMethod.GET)
	public String homeBack6() {
		return "redirect:/";
	}
	@RequestMapping(value = "empPwChange", method = RequestMethod.POST)
	public String homeBack5() {
		return "redirect:/";
	}
	@RequestMapping(value = "empUpdate", method = RequestMethod.GET)
	public String homeBack4() {
		return "redirect:/";
	}

	@RequestMapping(value = "empModify", method = RequestMethod.GET)
	public String homeBack3() {
		return "redirect:/";
	}

	@RequestMapping(value = "empModifyBiforPw", method = RequestMethod.POST)
	public String homeBack2() {
		return "redirect:/";
	}

	@RequestMapping(value = "empDetail", method = RequestMethod.POST)
	public String homeBack() {
		return "redirect:/";
	}

}
