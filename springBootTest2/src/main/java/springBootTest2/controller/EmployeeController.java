package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.EmployeeCommand;
import springBootTest2.service.employees.EmployeeDeleteService;
import springBootTest2.service.employees.EmployeeInfoService;
import springBootTest2.service.employees.EmployeeListService;
import springBootTest2.service.employees.EmployeeUpdateService;
import springBootTest2.service.employees.EmployeeWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController  {
	@Autowired
	EmployeeWriteService  employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@RequestMapping("employeeUpdate")
	public String empUpdateOk(EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeInfo?num="+employeeCommand.getEmpNum();
	}
	
	@RequestMapping("employeeModify")
	public String empUpdate(@RequestParam(value = "num") String empNum,
			Model model) {
		employeeInfoService.execute(empNum, model);
		return "thymeleaf/employee/empUpdate";
	}
	
	@RequestMapping("employeeDelete")
	public String empDelete(@RequestParam(value = "num") String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:employeeList";
	}
	
	@RequestMapping("employeeInfo")
	// String empNum = request.getParameter("num");
	public String empInfo(@RequestParam(value="num") String empNum ,
			Model model) {
		employeeInfoService.execute(empNum, model);
		return "thymeleaf/employee/empDetail";
	}
	@RequestMapping("employeeList")
	public String empList(Model model) {
		employeeListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	@RequestMapping("employeeRegist")
	public String empForm() {
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping("employeeWrite")
	public String empWrite(EmployeeCommand employeeCommand) {
		employeeWriteService.execute(employeeCommand);
		return "redirect:employeeList";
	}
	
	
}







