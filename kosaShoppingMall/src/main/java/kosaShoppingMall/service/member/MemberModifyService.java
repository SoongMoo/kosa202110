package kosaShoppingMall.service.member;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberModifyService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberRegist(Timestamp.valueOf(memberCommand.getMemberRegist()));
		dto.setMemberNum(memberCommand.getMemberNum());
		memberMapper.memberUpdate(dto);
	}
}
