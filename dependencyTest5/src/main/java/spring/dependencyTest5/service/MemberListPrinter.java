package spring.dependencyTest5.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependencyTest5.DTO.MemberDTO;
import spring.dependencyTest5.DTO.MemberDao;

public class MemberListPrinter {
	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberPrinter print;
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			print.print(dto);
		}
	}
}
