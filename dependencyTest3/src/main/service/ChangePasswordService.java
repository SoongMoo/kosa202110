package main.service;

import main.DTO.MemberDTO;
import main.DTO.MemberDao;

public class ChangePasswordService {
	// 의존객체 
	MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void execute(String email, String oldPw, 
			String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
	}
}




