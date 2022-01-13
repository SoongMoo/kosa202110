package springBootTest2.controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootTest2.command.EmployeeCommand;
import springBootTest2.service.employees.EmployeeListService;
import springBootTest2.service.employees.EmployeeWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController  {
	@Autowired
	EmployeeWriteService  employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
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







