package springBootTest2.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberMapper;
@Component
@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper; 
	public void execute(Model model) {
		List<MemberDTO> list = memberMapper.selectAll();
		model.addAttribute("list", list);
	}
}
