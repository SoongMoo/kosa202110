package springBootTest1.controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootTest1.command.EmployeeCommand;
import springBootTest1.service.employees.EmployeeWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	@RequestMapping("employeesList")
	public String empList() {
		return "thymeleaf/employees/empList";
	}
	@RequestMapping("employeesFrom")
	public String empForm() {
		return "thymeleaf/employees/empForm";
	}
	@RequestMapping("employeeWrite")
	// Model == HttpServletRequest
	public String empWrite(EmployeeCommand employeeCommand,
			Model model) {
		String path = employeeWriteService.execute(employeeCommand, model);
		return path;
	}
}






