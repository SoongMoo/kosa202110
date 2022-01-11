package main.service;

import java.util.Collection;

import main.DTO.MemberDTO;
import main.DTO.MemberDao;

public class MemberListPrinter {
	MemberDao memberDao = new MemberDao();
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			System.out.printf("회원정보는 : 아이디 = %d , 이메일 = %s ,"
					+ " 이름 = %s , 등록일 = %tF \n",
					dto.getId(), dto.getEmail(), dto.getName(),
					dto.getRegisterDate());
		}
	}
}
