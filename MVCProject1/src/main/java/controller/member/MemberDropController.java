package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDropController {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		String memId = "highland2"; //임의의 사용자 아이디
		String memPw = request.getParameter("memPw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		
		if(!memPw.equals(dto.getMemPw())) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			}catch(Exception e) {}
			out.print("<script>");
			out.print("alert('비밀번호가 틀립니다.');");
			out.print("location.href='memberDrop.mem'");
			out.print("</script>");
			out.close();
		}else {
			dao.memberDelete(dto.getMemNum());
			String contextPath = request.getContextPath();
			try {
				response.sendRedirect(contextPath + "/");
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
