package kosaShoppingMall.service.memberJoin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Component
@Service
public class MemberUpdateService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(MemberCommand memberCommand,HttpSession session,
			BindingResult result) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(passwordEncoder.matches(
				memberCommand.getMemberPw(), authInfo.getUserPw())){
			MemberDTO dto = new MemberDTO();
			dto.setMemberAddr(memberCommand.getMemberAddr());
			dto.setMemberBirth(memberCommand.getMemberBirth());
			dto.setMemberEmail(memberCommand.getMemberEmail());
			dto.setGender(memberCommand.getGender());
			dto.setMemberName(memberCommand.getMemberName());
			dto.setMemberNum(memberCommand.getMemberNum());
			dto.setMemberPhone(memberCommand.getMemberPhone());
			Integer i = memberShipMapper.memberUpdate(dto);
			System.out.println(i + "개 행이(가) 수정되었습니다.");
			path = "redirect:memberDetail";
			
		}else {
			result.rejectValue("memberPw", "memberCommand.memberPw", 
					"비밀번호가 틀렸습니다.");
			path = "thymeleaf/membership/memModify";
		}
		return path;
	}
}
