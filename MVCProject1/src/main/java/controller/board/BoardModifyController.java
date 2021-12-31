package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardModifyController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		BoardDTO  dto = new BoardDTO();
		dto.setBoardContent(request.getParameter("boardContent"));
		dto.setBoardNum( //문자열을 숫자로 변환
				Integer.parseInt(request.getParameter("boardNum")));
		dto.setBoardSubject(request.getParameter("boardSubject"));
		dto.setBoardWriter(request.getParameter("boardWriter"));
		
		BoardDAO dao = new BoardDAO();
		dao.boardUpdate(dto);		
	}
}
