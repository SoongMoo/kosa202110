package springBootTest2.service.empLibrary;

import java.io.File;

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
public class EmpLibraryDeleteService {
	@Autowired
	EmpLibraryMapper empLibraryMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	public String execute(EmpLibraryCommand empLibraryCommand, HttpSession session,Model model) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		model.addAttribute("empNum", empNum);
		EmpLibraryDTO dto = empLibraryMapper.selectOne(empLibraryCommand.getLibNum());

		
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(empLibraryCommand.getLibPw()) || 
				!dto.getEmpNum().equals(empNum)) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/emplib/empLibInfo";
		}else {
			Integer i = empLibraryMapper.libDelete(empLibraryCommand.getLibNum());
			if(i >0 ) {
				String storeFileNames[] = dto.getStoreFileName().split("`");
				String fileDir = 
						session.getServletContext().getRealPath("/view/empLib");
				for(String fileName : storeFileNames) {
					File file = new File(fileDir + "/" + fileName);
					if(file.exists())file.delete();
				}
			}
			path = "redirect:libList";
		}
		return path;
	}
}