package controller.member;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberMyUpdateContoller {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {e.printStackTrace();}
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); // 로그인 사용자의 세션 
		
		String memPw = request.getParameter("memPw");
		String memName = request.getParameter("memName");
		String memPhone1= request.getParameter("memPhone1");
		String memPhone2= request.getParameter("memPhone2");
		String memAddr= request.getParameter("memAddr");
		String memEmail= request.getParameter("memEmail");
		String memGender= request.getParameter("memGender");
		
		String memBirth= request.getParameter("memBirth");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(memBirth);
		}catch(Exception e) {e.printStackTrace();}
		Timestamp birth = new Timestamp(date.getTime());
		
		MemberDAO dao = new MemberDAO();
		// 입력한 비밀번호와 디비에 있는 비밀번호가 서로 일치하는 지 확인
		// 일치하지 않는 경우  alert창을 출력
		MemberDTO dto = dao.selectUser(authInfo.getUserId());
		if(!dto.getMemPw().equals(memPw)) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			}catch(Exception e) {}
			out.print("<script>");
			out.print("alert('비밀번호가 일치하지 않습니다.');");
			out.print("location.href='memberInfoModify.mem'");
			out.print("</script>");
			out.close();
		}else {
			dto.setMemBirth(birth);
			dto.setMemAddr(memAddr);
			dto.setMemEmail(memEmail);
			dto.setMemGender(memGender);
			dto.setMemId(authInfo.getUserId());
			dto.setMemName(memName);
			dto.setMemPhone1(memPhone1);
			dto.setMemPhone2(memPhone2);
			dao.memberMyUpdate(dto);
			try {
				response.sendRedirect("memberDscript.mem");
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
