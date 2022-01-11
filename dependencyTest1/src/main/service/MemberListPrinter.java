package main.service;

import java.util.Collection;

import main.DTO.MemberDTO;
import main.DTO.MemberDao;

public class MemberListPrinter {
	MemberDao memberDao = new MemberDao();
	MemberPrinter print= new MemberPrinter();
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			print.print(dto);
		}
	}
}
