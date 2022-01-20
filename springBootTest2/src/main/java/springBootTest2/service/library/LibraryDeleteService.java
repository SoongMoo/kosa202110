package springBootTest2.service.library;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.LibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;
@Component
@Service
public class LibraryDeleteService {
	@Autowired
	LibraryMapper libraryMapper;
	public String execute(LibraryCommand libraryCommand, HttpSession session,Model model) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		model.addAttribute("memId",authInfo.getUserId());
		LibraryDTO dto = libraryMapper.selectOne(libraryCommand.getLibNum());
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libraryCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libInfo";
		}else {
			Integer i = libraryMapper.libDelete(libraryCommand.getLibNum());
			if(i > 0) {
				String [] fileNames = dto.getStoreFileName().split("`");
				String filePath ="/view/lib";
				String fileDir = session.getServletContext()
						                .getRealPath(filePath);
				File file = null;
				try {
					for(String fileName : fileNames) {
						file = new File(fileDir + "/" + fileName);
						if(file.exists()) file.delete();
					}
				}catch(Exception e) {}
			}
			path = "redirect:libList";
		}
		return path;
	}
}