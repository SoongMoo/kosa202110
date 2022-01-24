package springBootTest2.service.empLibrary;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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
			String [] storeFileNames = null;
			if( dto.getStoreFileName() != null) {
				storeFileNames = dto.getStoreFileName().split("`");
			}
			
			String fileDir = session.getServletContext().getRealPath("/view/empLib");
			
			dto.setLibContent(empLibraryCommand.getLibContent());
			dto.setLibNum(Integer.parseInt(empLibraryCommand.getLibNum()));
			dto.setLibSubject(empLibraryCommand.getLibSubject());
			dto.setLibWriter(empLibraryCommand.getLibWriter());
			
			String originalTotal = "";
			String storeTotal = "";
			String fileSizeTotal = "";
			for(MultipartFile mf : empLibraryCommand.getReport()) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(
						originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString()
									   .replace("-", "");
				String storeFileName = storeName + extension;
				String fileSize = Long.toString(mf.getSize());
				
				File file = new File(fileDir + "/" + storeFileName);
				try{
					mf.transferTo(file);
				}catch(Exception e) {}
				originalTotal += originalFile + "`";
				storeTotal += storeFileName + "`";
				fileSizeTotal += fileSize +"`";
			}
			dto.setFileSize(fileSizeTotal);
			dto.setOriginalFileName(originalTotal);
			dto.setStoreFileName(storeTotal);
			
			Integer i = EmpLibraryMapper.libraryUpdate(dto);
			if(i >0 ) {
				for(String fileName : storeFileNames) {
					File file = new File(fileDir + "/" + fileName);
					if(file.exists())file.delete();
				}
			}
		}
		return path;
	}
}
