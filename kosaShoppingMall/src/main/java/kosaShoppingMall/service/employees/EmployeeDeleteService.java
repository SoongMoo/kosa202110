package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.repository.EmployeeRepository;
@Component
@Service
public class EmployeeDeleteService {
	@Autowired
	//EmployeeMapper employeeMapper;
	EmployeeRepository employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(EmployeeCommand employeeCommand, Model model) {
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), 
				dto.getEmpPw())) {
			Integer i = employeeMapper.employeeDelete(employeeCommand.getEmpId());
			model.addAttribute("num",i );
		}else {
			model.addAttribute("num",0 );
		}
	}
}
