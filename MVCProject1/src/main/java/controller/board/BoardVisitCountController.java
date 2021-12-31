package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;

public class BoardVisitCountController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		dao.visitCount(num);
	}
}
