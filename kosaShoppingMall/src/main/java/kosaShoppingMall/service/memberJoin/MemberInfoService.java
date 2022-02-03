package kosaShoppingMall.service.memberJoin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Component
@Service
public class MemberInfoService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		MemberDTO dto = memberShipMapper.selectOne(memId);
		model.addAttribute("memberCommand", dto);
	}
}








