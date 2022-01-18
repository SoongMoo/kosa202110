package springBootTest2.service.membership;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberShipMapper;
@Component
@Service
public class MemberUpdateService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public String execute(MemberCommand memberCommand,HttpSession session) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo.getUserPw().equals(memberCommand.getMemPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setMemAddr(memberCommand.getMemAddr());
			dto.setMemBirth(memberCommand.getMemBirth());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemGender(memberCommand.getMemGender());
			dto.setMemName(memberCommand.getMemName());
			dto.setMemNum(memberCommand.getMemNum());
			dto.setMemPhone1(memberCommand.getMemPhone1());
			dto.setMemPhone2(memberCommand.getMemPhone2());
			Integer i = memberShipMapper.memberUpdate(dto);
			System.out.println(i + "개 행이(가) 수정되었습니다.");
			path = "redirect:memInfo";
			session.removeAttribute("err_pw");
		}else {
			session.setAttribute("err_pw", "비밀번호가 틀렸습니다.");
			path = "redirect:memberInfoModify";
		}
		return path;
	}
}
