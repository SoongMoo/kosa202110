package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Component
@Service
public class MemberPasswordService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String memId, String memPw) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memId);
		dto.setMemberPw(memPw);
		memberShipMapper.updatePassword(dto);
	}
}