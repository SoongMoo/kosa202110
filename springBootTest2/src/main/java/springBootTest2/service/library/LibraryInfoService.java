package springBootTest2.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;
@Component
@Service
public class LibraryInfoService {
	@Autowired
	LibraryMapper libraryMapper ;
	public void execute(String libNum,Model model) {
		LibraryDTO dto = libraryMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
	}
}
