package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberListController {
	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		request.setAttribute("MemberList", list);
	}
}
