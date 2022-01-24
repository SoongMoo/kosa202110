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
public class EmpLibraryInfoService {
	@Autowired
	EmpLibraryMapper empLibraryMapper ;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(String libNum,Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		EmpLibraryDTO dto = empLibraryMapper.selectOne(libNum);
		model.addAttribute("empNum", empNum);
		model.addAttribute("dto", dto);
	}
}
