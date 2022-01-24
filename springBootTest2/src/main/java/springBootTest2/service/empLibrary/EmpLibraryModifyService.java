package springBootTest2.service.empLibrary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibraryDTO;
import springBootTest2.mapper.EmpLibraryMapper;
import springBootTest2.mapper.EmployeeMapper;
@Component
@Service
public class EmpLibraryModifyService {
	@Autowired
	EmpLibraryMapper empLibraryMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	public String execute(String libNum, String libPw, Model model,
			HttpSession session) {
		String path = "thymeleaf/emplib/empLibModify";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		model.addAttribute("empNum", empNum);
		EmpLibraryDTO dto = empLibraryMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libPw) || 
				!dto.getEmpNum().equals(empNum)) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/empLibInfo";
		}
		return path;
	}
}
