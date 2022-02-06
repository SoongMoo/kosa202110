package kosaShoppingMall.service.empMyPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmployeePwCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpMyPagePwService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(EmployeePwCommand employeePwCommand ,BindingResult result , HttpSession session ) {
		String path = "";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(result.hasErrors()) {
			path="thymeleaf/employeesShip/empPwChange";
		}else if(!passwordEncoder.matches(employeePwCommand.getEmpPw(), authInfo.getUserPw())) {
			result.rejectValue("empPw","pwErr");
			path="thymeleaf/employeesShip/empPwChange";
		}else if(!employeePwCommand.getNewEmpPw().equals(employeePwCommand.getNewEmpPwCon())) {
			result.rejectValue("newEmpPw","empErr");
			path="thymeleaf/employeesShip/empPwChange";
		}else {
			String newEmpPw = passwordEncoder.encode(employeePwCommand.getNewEmpPw());
			authInfo.setUserPw(newEmpPw);
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpPw(newEmpPw);
			dto.setEmpId(authInfo.getUserId());
			employeeMapper.employeePwChange(dto);
			path = "redirect:empDetail";
		}
		
		return path;
	}
	
}
