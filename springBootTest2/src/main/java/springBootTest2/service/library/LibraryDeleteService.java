package springBootTest2.service.library;

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
		LibraryDTO dto = libraryMapper.selectOne(libraryCommand.getLibNum());
		model.addAttribute("dto", dto);
		if(!dto.getLibPw().equals(libraryCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libInfo";
		}else {
			libraryMapper.libDelete(libraryCommand.getLibNum());
			path = "redirect:libList";
		}
		return path;
	}
}