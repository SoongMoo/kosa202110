package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberMailService {
	@Autowired
	MemberMapper memberMapper;
	public Integer execute(String memberOk, String reciver, String userId) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberOk(memberOk);
		dto.setMemberEmail(reciver);
		dto.setMemberId(userId);
		return memberMapper.joinOkUpdate(dto);
	}

}
