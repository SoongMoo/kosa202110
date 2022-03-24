package kosaShoppingMall.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.MemberMapper;
@Service
public class MemberList1Service {
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model) {
		StartEndPageDTO dto = new StartEndPageDTO();
		List<MemberDTO> lists = memberMapper.selectAll(dto);
		model.addAttribute("lists", lists);
	}
}
