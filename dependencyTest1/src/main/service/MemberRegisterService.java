package main.service;

import java.util.Date;

import main.DTO.MemberDTO;
import main.DTO.MemberDao;
import main.DTO.RegisterRequest;

public class MemberRegisterService {
	// 의존 객체(dependency object)
	MemberDao memberDao = new MemberDao();
	public void execute(RegisterRequest request) {
		MemberDTO dto = new MemberDTO();
		dto.setEmail(request.getEmail());
		dto.setName(request.getName());
		dto.setPassword(request.getPassword());
		dto.setRegisterDate(new Date());
		memberDao.insert(dto);
	}
}
