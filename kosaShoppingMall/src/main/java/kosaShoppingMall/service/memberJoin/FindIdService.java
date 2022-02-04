package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;
@Service
public class FindIdService {
	@Autowired
	MemberMapper memberMapper;
	public String execute(FindIdCommand findIdCommand,
			 Model model, BindingResult result) {
		MemberDTO dto  = memberMapper.findId(findIdCommand.getMemberEmail());
		if(dto == null) {
			result.rejectValue("memberEmail", 
					"findIdCommand.memberEmail", "이메일이 틀렸습니다.");
			return "thymeleaf/help/findId";
		}else {
			if(dto.getMemberPhone().equals(findIdCommand.getMemberPhone())) {
				model.addAttribute("userId", dto.getMemberId());
				return "thymeleaf/help/findIdOk";
			}else {
				result.rejectValue("memberPhone", 
						"findIdCommand.memberPhone", "전화번호가 틀렸습니다.");
				return "thymeleaf/help/findId";
			}
		}
	}
}
