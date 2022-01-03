package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoradListController {
	public void execute(HttpServletRequest request) {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.selectAll();
		request.setAttribute("list", list);
	}
	
}
