package springBootTest2.service.empLibrary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmpLibraryDTO;
import springBootTest2.mapper.EmpLibraryMapper;
@Component
@Service
public class EmpLibraryListService {
	@Autowired
	EmpLibraryMapper empLibraryMapper;
	public void execute(Model model , HttpServletRequest request) {
		List<EmpLibraryDTO> list = empLibraryMapper.selectAll();
		model.addAttribute("list", list);
	}
}
