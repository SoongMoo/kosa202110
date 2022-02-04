package kosaShoppingMall.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;
@Service
public class FindIdService {
	@Autowired
	LoginMapper loginMapper;
	public String execute(FindIdCommand findIdCommand,
			 Model model, BindingResult result) {
		AuthInfo authInfo  = loginMapper.findId(findIdCommand.getMemberEmail());
		if(authInfo == null) {
			result.rejectValue("memberEmail", "wrong");
			//result.rejectValue("memberEmail", "findIdCommand.memberEmail", "이메일이 틀렸습니다.");
			return "thymeleaf/help/findId";
		}else {
			if(authInfo.getPhone().equals(findIdCommand.getMemberPhone())) {
				model.addAttribute("userId", authInfo.getUserId());
				return "thymeleaf/help/findIdOk";
			}else {
				result.rejectValue("memberPhone","bad" );
				//result.rejectValue("memberPhone","findIdCommand.memberPhone","전화번호가 틀렸습니다." );
				return "thymeleaf/help/findId";
			}
		}
	}
}
