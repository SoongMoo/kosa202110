package spring.dependencyTest5.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependencyTest5.DTO.MemberDTO;
import spring.dependencyTest5.DTO.MemberDao;
import spring.dependencyTest5.DTO.RegisterRequest;



public class MemberRegisterService {
	// 의존 객체(dependency object)
	@Autowired
	MemberDao memberDao;
	// 의존 객체 주입
	public void execute(RegisterRequest request) {
		MemberDTO dto = memberDao.selectByEmail(request.getEmail());
		if(dto== null) {		
			dto = new MemberDTO();
			dto.setEmail(request.getEmail());
			dto.setName(request.getName());
			dto.setPassword(request.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료되었습니다.");
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
}
