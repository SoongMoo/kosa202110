package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberDeleteController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(num);
	}
}
