package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberMapper;
@Component
@Service
public class MemberModifyService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemNum(memberCommand.getMemNum());
		dto.setMemRegiDate(memberCommand.getMemRegiDate());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone1(memberCommand.getMemPhone1());
		dto.setMemPhone2(memberCommand.getMemPhone2());
		dto.setMemPw(memberCommand.getMemPw());
		memberMapper.memberUpdate(dto);
	}
}
