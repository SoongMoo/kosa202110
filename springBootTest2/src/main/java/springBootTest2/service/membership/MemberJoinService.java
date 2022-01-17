package springBootTest2.service.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberShipMapper;
@Component
@Service
public class MemberJoinService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone1(memberCommand.getMemPhone1());
		dto.setMemPhone2(memberCommand.getMemPhone2());
		dto.setMemPw(memberCommand.getMemPw());
		memberShipMapper.memberInsert(dto);
	}
}
