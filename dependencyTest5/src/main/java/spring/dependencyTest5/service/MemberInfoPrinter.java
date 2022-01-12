package spring.dependencyTest5.service;


import org.springframework.beans.factory.annotation.Autowired;

import spring.dependencyTest5.DTO.MemberDTO;
import spring.dependencyTest5.DTO.MemberDao;

public class MemberInfoPrinter {
	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberPrinter print;
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		print.print(dto);
	}
}
