package springBootTest2.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.BoardDTO;
import springBootTest2.mapper.BoardMapper;
@Component
@Service
public class BoardListService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(Model model) {
		List<BoardDTO> list = boardMapper.selectAll();
		model.addAttribute("list", list);
	}
}



