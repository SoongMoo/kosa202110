package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardWriteController {
	public void execute(HttpServletRequest request) {
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writerIP = request.getRemoteAddr();
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardSubject(boardSubject);
		dto.setBoardWriter(boardWriter);
		dto.setWriterIp(writerIP);
		
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
		
	}
}
