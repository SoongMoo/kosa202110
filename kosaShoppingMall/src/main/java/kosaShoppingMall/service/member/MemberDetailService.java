package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;
	public MemberDTO execute(String memberNum, Model model) {
		MemberDTO dto = memberMapper.selectDTO(memberNum);
		model.addAttribute("memberCommand", dto);
		return dto;
	}
}
