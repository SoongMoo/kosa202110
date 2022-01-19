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
public class LibraryUpdateService {
	@Autowired
	LibraryMapper libraryMapper;
	public String execute(LibraryCommand libraryCommand,
			HttpSession session,Model model) {
		String path = "redirect:libInfo?num="+libraryCommand.getLibNum();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibraryDTO dto = libraryMapper.selectOne(libraryCommand.getLibNum());
		if(!dto.getLibPw().equals(libraryCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			// 수정한 내용을 수정 페이지에 전달
			// selectOne으로 가져온 내용을 전달하면 이전 내용이 적용
			model.addAttribute("dto", libraryCommand);
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libModify";
		}else {
			dto.setLibContent(libraryCommand.getLibContent());
			dto.setLibNum(Integer.parseInt(libraryCommand.getLibNum()));
			dto.setLibSubject(libraryCommand.getLibSubject());
			dto.setLibWriter(libraryCommand.getLibWriter());
			libraryMapper.libraryUpdate(dto);
		}
		return path;
	}
}
