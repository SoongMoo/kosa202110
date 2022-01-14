package springBootTest2.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.BoardDTO;
import springBootTest2.mapper.BoardMapper;

@Component
@Service
public class BoardDetailService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(Model model, Integer boardNum) {
		boardMapper.visitCount(boardNum);
		BoardDTO dto = boardMapper.selectOne(boardNum); // BoardDTO dto =  dto;
		model.addAttribute("dto", dto);
	}
}
