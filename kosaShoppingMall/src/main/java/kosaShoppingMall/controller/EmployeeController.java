package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.command.EmployeePwCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.EmpEmailUpdatecheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.employees.EmployeeDeleteService;
import kosaShoppingMall.service.employees.EmployeeDelsService;
import kosaShoppingMall.service.employees.EmployeeInfoservice;
import kosaShoppingMall.service.employees.EmployeeModifyService;
import kosaShoppingMall.service.employees.EmployeeUpdateService;
import kosaShoppingMall.service.employees.EmployeesListService;
import kosaShoppingMall.service.employees.EmployeesWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeesWriteService employeesWriteService; 
	@Autowired
	EmployeesListService employeesListService;
	@Autowired
	EmployeeInfoservice employeeInfoservice;
	@Autowired
	EmployeeModifyService employeeModifyService; 
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService ;
	@Autowired
	EmployeeDelsService employeeDelsService;
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmpEmailUpdatecheckService empEmailUpdatecheckService;
	
	@ModelAttribute
	EmployeeCommand setEmployeeCommand() {
		return new EmployeeCommand();
	}
	
	
	
	@RequestMapping(value = "empDels" , method = RequestMethod.POST)
	public String empDels(@RequestParam(value = "delete") String [] delete) {
		employeeDelsService.execute(delete);
		return "redirect:empList";
	}
	
	
	@RequestMapping(value="empDelete", method = RequestMethod.POST)
	public String empDelete(EmployeeCommand employeeCommand,
		Model model) {
		employeeDeleteService.execute(employeeCommand,model);
		return "thymeleaf/employee/empdel";
	}
	@RequestMapping(value="empUpdate", method = RequestMethod.POST)
	public String empUpdate(EmployeeCommand employeeCommand,BindingResult result) {
		Integer i = empEmailUpdatecheckService.execute(employeeCommand.getEmpEmail() , employeeCommand.getEmpId());
		if(i == 1) {
			result.rejectValue("empEmail","employeeCommand.empEmail" , "중복된 이메일 입니다.");
			return "thymeleaf/employee/empUpdate";
		}
		String path = employeeUpdateService.execute(employeeCommand,result);
		return path;
	}
	@RequestMapping(value= "empModify" , method = RequestMethod.POST)
	public String empModify(@RequestParam(value="empPw") String empPw,
			@RequestParam(value="empId") String empId,
			Model model) {
		String path = employeeModifyService.execute(empId,empPw, model);
		return path;
	}
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value = "num") String empNum,
			Model model) {
		employeeInfoservice.execute(empNum,model );
		return "thymeleaf/employee/empInfo";
	}
	@RequestMapping("empList")
	public String empList(@RequestParam(value = "page" ,defaultValue = "1", required = false)Integer page , Model model) {
		
		employeesListService.execute(page , model);
		return "thymeleaf/employee/empList";
	}
	@RequestMapping("empJoin")
	public String empJoin(Model model) {
		//model.addAttribute("employeeCommand", new EmployeeCommand());
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping(value = "empWrite", method = RequestMethod.GET)
	public   String empWrite1() {
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping(value = "empWrite", method = RequestMethod.POST)
	public String empWrite(@Validated EmployeeCommand employeeCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/employee/empForm";
		}
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/empForm";
		}
		Integer i = emailCheckService.execute(employeeCommand.getEmpEmail());
		if(i == 1) {
			result.rejectValue("empEmail", "employeeCommand.empEmail", "사용중인 이메일 입니다아앙.");
			return "thymeleaf/employee/empForm";
		}
		i = idcheckService.execute(employeeCommand.getEmpId());
		if(i == 1) {
			result.rejectValue("empId", "memberCommand.empId", "중복 아이디입니다.");
			return "thymeleaf/employee/empForm";
		}
		
		employeesWriteService.execute(employeeCommand);
		return "redirect:/";
	}
}

