package kosaShoppingMall.service.memberJoin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.command.MemberPwCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Component
@Service
public class MemberPasswordService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(MemberPwCommand memberPwCommand ,
			BindingResult result , HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(memberPwCommand.getOldPw(), authInfo.getUserPw())) {
			if(!memberPwCommand.isMemberPwEqualsMemberPwCon() ) {
				result.rejectValue("memberPw", "memberCommand.memberPw", 
						"비밀번호확인이 틀립니다.");
				return "thymeleaf/membership/memberPassCon";
			}
			String newPw = passwordEncoder.encode(memberPwCommand.getMemberPw());
			MemberDTO dto = new MemberDTO();
			dto.setMemberId(authInfo.getUserId());
			dto.setMemberPw(newPw);
			memberShipMapper.updatePassword(dto);
			authInfo.setUserPw(newPw);
			return "redirect:memberDetail";
		}else {
			result.rejectValue("oldPw", "memberCommand.oldPw", "현재 비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberPassCon";
		}
	}
}