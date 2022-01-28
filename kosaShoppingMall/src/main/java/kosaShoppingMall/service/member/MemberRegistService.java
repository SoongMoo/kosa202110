package kosaShoppingMall.service.member;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberRegistService {
	@Autowired
	MemberMapper memberMapper ;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand) {
		  MemberDTO dto = new MemberDTO();
		  dto.setGender(memberCommand.getGender());
		  dto.setMemberAddr(memberCommand.getMemberAddr());
		  dto.setMemberBirth(memberCommand.getMemberBirth());
		  dto.setMemberEmail(memberCommand.getMemberEmail());
		  dto.setMemberId(memberCommand.getMemberId());
		  dto.setMemberName(memberCommand.getMemberName());
		  dto.setMemberNum(memberCommand.getMemberNum());
		  dto.setMemberPhone(memberCommand.getMemberPhone());
		  dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		  dto.setMemberRegist(Timestamp.valueOf(memberCommand.getMemberRegist()));
		  Integer i = memberMapper.memberInsert(dto);
		  System.out.println(i + "개행이(가) 삽입되었습니다.");
	}
}
