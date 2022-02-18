package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.PaymentPurchaseGoodsDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class OrderProcessListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectOne(authInfo.getUserId());
		List<PaymentPurchaseGoodsDTO> list = memberShipMapper.orderList(memberDTO.getMemberNum());
		model.addAttribute("list", list);
	}

}
