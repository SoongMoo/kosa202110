package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;

public class BoardDelController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		dao.boardDel(num);
	}
}
