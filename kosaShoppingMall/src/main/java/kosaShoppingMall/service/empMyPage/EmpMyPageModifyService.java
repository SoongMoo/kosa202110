package kosaShoppingMall.service.empMyPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.command.EmployeePwCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpMyPageModifyService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmployeeMapper employeeMapper;
	public String execute(EmployeePwCommand employeePwCommand, BindingResult result,
			HttpSession session, EmployeeCommand employeeCommand, Model model) {
		String path = "";
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if (result.hasErrors()) {
			path = "thymeleaf/employeesShip/empModifyPw";
		}else if (!passwordEncoder.matches(employeePwCommand.getEmpPw(), authInfo.getUserPw())) {
			result.rejectValue("empPw", "employeePwCommand.empPw", "비밀번호가 다릅니다.");
			path = "thymeleaf/employeesShip/empModifyPw";
		} else {
			EmployeeDTO dto = employeeMapper.selectOne(authInfo.getUserId());
			model.addAttribute("employeeCommand" , dto );
			
			path = "thymeleaf/employeesShip/empUpdate";
		}
		return path;
	}

}
