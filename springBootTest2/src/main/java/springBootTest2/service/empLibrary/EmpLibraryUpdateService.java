package springBootTest2.service.empLibrary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.EmpLibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibraryDTO;
import springBootTest2.mapper.EmpLibraryMapper;
import springBootTest2.mapper.EmployeeMapper;
@Component
@Service
public class EmpLibraryUpdateService {
	@Autowired
	EmpLibraryMapper EmpLibraryMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	public String execute(EmpLibraryCommand empLibraryCommand,
			HttpSession session,Model model) {
		String path = "redirect:libInfo?num="+empLibraryCommand.getLibNum();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		
		EmpLibraryDTO dto = EmpLibraryMapper.selectOne(empLibraryCommand.getLibNum());
		if(!dto.getLibPw().equals(empLibraryCommand.getLibPw()) || 
				!dto.getEmpNum().equals(empNum)) {
			model.addAttribute("dto", dto);
			model.addAttribute("err_pw","비밀번호가 틀렸습니다.");
			path = "thymeleaf/emplib/empLibModify";
		}else {
			dto.setLibContent(empLibraryCommand.getLibContent());
			dto.setLibNum(Integer.parseInt(empLibraryCommand.getLibNum()));
			dto.setLibSubject(empLibraryCommand.getLibSubject());
			dto.setLibWriter(empLibraryCommand.getLibWriter());
			Integer i = EmpLibraryMapper.libraryUpdate(dto);
		}
		return path;
	}
}
