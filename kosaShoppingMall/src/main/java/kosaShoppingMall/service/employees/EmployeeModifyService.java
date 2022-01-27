package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;
@Component
@Service
public class EmployeeModifyService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(String empId, String empPw , Model model) {
		EmployeeDTO dto = employeeMapper.selectOne(empId);
		model.addAttribute("employeeCommand", dto);
		if(passwordEncoder.matches(empPw, dto.getEmpPw())) {
			System.out.println("맞다.");
			return "thymeleaf/employee/empUpdate";
		}else {
			System.out.println("틀리다.");
			return "thymeleaf/employee/empInfo";
		}
	}
}
