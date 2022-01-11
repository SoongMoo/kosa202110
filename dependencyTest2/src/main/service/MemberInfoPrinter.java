package main.service;

import main.DTO.MemberDTO;
import main.DTO.MemberDao;

public class MemberInfoPrinter {
	MemberDao memberDao;
	MemberPrinter print= new MemberPrinter();
	public MemberInfoPrinter(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		print.print(dto);
	}
}
