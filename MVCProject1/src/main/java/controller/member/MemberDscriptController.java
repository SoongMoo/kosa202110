package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDscriptController {
	public void execute(HttpServletRequest request) {
		// 로그인 사용자 아이디로 정보 확인
		String memId = "highland2"; // 임시로 임의의 사용자 아이디 사용
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		request.setAttribute("memberDTO", dto);
	}
}
