package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDetailController {
	public void execute(HttpServletRequest request) {
		String memNum = request.getParameter("num");
		MemberDAO dao =  new MemberDAO();
		MemberDTO dto = dao.selectOne(memNum);
		request.setAttribute("memberDTO", dto);
	}
}
