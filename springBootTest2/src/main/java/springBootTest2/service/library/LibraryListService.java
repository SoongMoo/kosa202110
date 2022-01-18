package springBootTest2.service.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;
@Component
@Service
public class LibraryListService {
	@Autowired
	LibraryMapper libraryMapper;
	public void execute(Model model) {
		List<LibraryDTO> list = libraryMapper.selectAll();
		model.addAttribute("list", list);
	}
}
