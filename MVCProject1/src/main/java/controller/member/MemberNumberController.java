package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberNumberController {
	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		String memberNum = dao.numberGenerate();
		request.setAttribute("memberNum", memberNum);
	}
}
