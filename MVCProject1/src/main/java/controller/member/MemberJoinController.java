package controller.member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberJoinController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		
		String memName = request.getParameter("memName");
		String memId= request.getParameter("memId");
		String memPw= request.getParameter("memPw");
		String memPhone1= request.getParameter("memPhone1");
		String memPhone2= request.getParameter("memPhone2");
		String memAddr= request.getParameter("memAddr");
		String memEmail= request.getParameter("memEmail");
		String memGender= request.getParameter("memGender");
		switch(memGender) {
		case "1":
		case "3": 
		case "5": 
		case "7":
		case "9": memGender = "M"; break;
		case "2":
		case "4": 
		case "6":
		case "8":
		case "0": memGender = "F"; break;
		}
		
		String memBirth= request.getParameter("memBirth");
		SimpleDateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = asf.parse(memBirth);
		}catch(Exception e) {e.printStackTrace();}
		Timestamp birth = new Timestamp(date.getTime());
		
		MemberDTO dto = new MemberDTO();
		dto.setMemBirth(birth);
		dto.setMemGender(memGender);
		dto.setMemAddr(memAddr);
		dto.setMemEmail(memEmail);
		dto.setMemId(memId);
		dto.setMemName(memName);
		dto.setMemPhone1(memPhone1);
		dto.setMemPhone2(memPhone2);
		dto.setMemPw(memPw);
		
		MemberDAO dao = new MemberDAO();
		dao.memberJoin(dto);
		
		request.setAttribute("userName", memName);
	}
}
