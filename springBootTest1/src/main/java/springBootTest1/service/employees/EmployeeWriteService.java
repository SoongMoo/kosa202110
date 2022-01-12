package springBootTest1.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest1.command.EmployeeCommand;
import springBootTest1.domain.EmployeeDTO;
import springBootTest1.repository.EmployeeRepository;
@Component
@Service
public class EmployeeWriteService {
	@Autowired
	EmployeeRepository employeeRepository;
	public String execute(EmployeeCommand employeeCommand,
			Model model) {
		String path=null;

		if(!employeeCommand.isEmpPwEqualToEmpPwCon()
				|| employeeCommand.getEmpPw().isEmpty()) {
			
			model.addAttribute("err_pwcon","비밀번호가 일치하지 않습니다.");
			path = "thymeleaf/employees/empForm";
			return path;
		}
		System.out.println(employeeCommand.getEmpSalary());
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPw(employeeCommand.getEmpPw());
		dto.setEmpSalary(employeeCommand.getEmpSalary());
		employeeRepository.employeeInsert(dto);
		path= "redirect:employeesList";
		return path;
	}
}




