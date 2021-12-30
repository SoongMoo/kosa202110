package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DTO.BoardDTO;

public class BoardWriteController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writeIp = request.getRemoteAddr();
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardContent(boardContent);
		boardDTO.setBoardSubject(boardSubject);
		boardDTO.setBoardWriter(boardWriter);
		boardDTO.setWriterIp(writeIp);	
	}
}