package kosaShoppingMall.service.empMyPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpMyPageUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(EmployeeCommand employeeCommand, BindingResult result,  HttpSession  session) {
		String path = "redirect:empDetail";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(result.hasErrors()) {
			path = "thymeleaf/employeesShip/empUpdate";
		}else if(!passwordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			result.rejectValue("empPw","pwErr");
			path = "thymeleaf/employeesShip/empUpdate";
		}else {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpAddr(employeeCommand.getEmpAddr());
			dto.setEmpId(employeeCommand.getEmpId());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpPhone(employeeCommand.getEmpPhone());
			dto.setEmpEmail(employeeCommand.getEmpEmail());
			employeeMapper.employeeUpdate(dto);
		}
		return path;
	}
	
}
