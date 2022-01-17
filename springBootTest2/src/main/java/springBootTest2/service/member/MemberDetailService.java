package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberMapper;
@Component
@Service
public class MemberDetailService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memNum,Model model) {
		MemberDTO dto = memberMapper.selectOne(memNum);
		model.addAttribute("memberDTO", dto);
	}
}
