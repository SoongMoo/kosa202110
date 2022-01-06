package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberPassModifyController {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memId= (String)session.getAttribute("id");
		String memPw= request.getParameter("memPw");
		String newMemPw = request.getParameter("newMemPw");
		
		MemberDAO dao =  new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		
		if(!memPw.equals(dto.getMemPw())) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/memberPassCon.jsp");
			dispatcher.forward(request, response);
		}else {
			dao.memberPassUpdate(memId, newMemPw);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/");
		}
	}
}
