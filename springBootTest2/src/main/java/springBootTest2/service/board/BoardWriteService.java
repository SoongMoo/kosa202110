package springBootTest2.service.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.BoardCommand;
import springBootTest2.domain.BoardDTO;
import springBootTest2.mapper.BoardMapper;

@Component
@Service
public class BoardWriteService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(BoardCommand boardCommand, 
			HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		dto.setWriterIp(request.getRemoteAddr());
		
		Integer i = boardMapper.boardInsert(dto);
		System.out.println(i +"개 행이(가) 삽입되었습니다.");
	}
}
