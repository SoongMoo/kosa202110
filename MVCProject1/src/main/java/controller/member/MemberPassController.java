package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberPassController {
	public String execute(HttpServletRequest request) {
		String path = null;
		String memId = "highland2";
		String memPw = request.getParameter("memPw");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		
		if(!memPw.equals(dto.getMemPw())) {
			request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
			path = "/myPage/memberPass.jsp";
		}else {
			path = "/myPage/memberPassCon.jsp";
		}
		return path;
	}
}
