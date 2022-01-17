package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.mapper.MemberMapper;

@Component
@Service
public class MemberNumberService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model) {
		String memberNum = memberMapper.numberGenerate();
		model.addAttribute("memberNum",memberNum);
	}
}
