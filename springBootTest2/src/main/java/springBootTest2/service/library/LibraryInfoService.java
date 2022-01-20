package springBootTest2.service.library;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;
@Component
@Service
public class LibraryInfoService {
	@Autowired
	LibraryMapper libraryMapper ;
	public void execute(String libNum,Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibraryDTO dto = libraryMapper.selectOne(libNum);
		model.addAttribute("memId",authInfo.getUserId());
		model.addAttribute("dto", dto);
	}
}
