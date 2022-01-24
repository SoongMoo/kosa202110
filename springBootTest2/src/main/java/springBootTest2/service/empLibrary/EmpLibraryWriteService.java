package springBootTest2.service.empLibrary;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.EmpLibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibraryDTO;
import springBootTest2.mapper.EmpLibraryMapper;
import springBootTest2.mapper.EmployeeMapper;
@Component
@Service
public class EmpLibraryWriteService {
	@Autowired
	EmpLibraryMapper empLibraryMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(EmpLibraryCommand empLibraryCommand,
			HttpServletRequest request)  {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		EmpLibraryDTO dto = new EmpLibraryDTO();
		dto.setEmpNum(empNum);
		dto.setLibContent(empLibraryCommand.getLibContent());
		dto.setLibPw(empLibraryCommand.getLibPw());
		dto.setLibSubject(empLibraryCommand.getLibSubject());
		dto.setLibWriter(empLibraryCommand.getLibWriter());
		dto.setIpAddr(request.getRemoteAddr());
		
		// 파일 정보를 입력하기 위한 변수 
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		String path = "/view/empLib";
		String fileDir = request.getServletContext().getRealPath(path);
		// String fileDir="C:\Users\A-13\eclipse-workspace\workspace\kosa202110\springBootTest2\src\main\webapp\view\empLib";
		System.out.println(fileDir);
		for(MultipartFile mf : empLibraryCommand.getReport()) {
			String original = mf.getOriginalFilename();
			String extension = 
					original.substring(original.lastIndexOf("."));
			// 중복 파일명이 있을 때 를 대비하여 유일한 이름의 파일명을 생성
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store+extension;
			File file = new File(fileDir + "/" + storeFileName);
			String fileSize = Long.toString(mf.getSize());
			try {
				mf.transferTo(file);
			}catch(Exception e) {e.printStackTrace();}
			originalTotal += original +"`";
			storeTotal += storeFileName +"`";
			fileSizeTotal += fileSize + "`";
		}
		dto.setOriginalFileName(originalTotal);
		dto.setStoreFileName(storeTotal);
		dto.setFileSize(fileSizeTotal);
		empLibraryMapper.libInsert(dto);
	}
}
