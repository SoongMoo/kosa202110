package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsCartListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memberNum = 
				memberShipMapper.selectOne(authInfo.getUserId()).getMemberNum();
		List<CartDTO> list = memberShipMapper.cartList(memberNum);
		model.addAttribute("lists", list);
	}
}







