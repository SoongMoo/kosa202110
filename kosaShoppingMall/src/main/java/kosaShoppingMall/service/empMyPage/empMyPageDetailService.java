package kosaShoppingMall.service.empMyPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class empMyPageDetailService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		EmployeeDTO dto = employeeMapper.selectOne(authInfo.getUserId());
		model.addAttribute("employeeCommand", dto);

	}

}
