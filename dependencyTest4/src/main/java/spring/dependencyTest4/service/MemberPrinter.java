package spring.dependencyTest4.service;

import spring.dependencyTest4.DTO.MemberDTO;

public class MemberPrinter {
	public void print(MemberDTO dto) {
		System.out.printf("회원정보는 : 아이디 = %d , 이메일 = %s ,"
				+ " 이름 = %s , 등록일 = %tF \n",
				dto.getId(), dto.getEmail(), dto.getName(),
				dto.getRegisterDate());
	}
}
