package kosaShoppingMall.service.memberJoin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsCartDelsService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String[] goodsNum , Model model, HttpSession session) {
			AuthInfo authInfo  = (AuthInfo)session.getAttribute("authInfo");
			MemberDTO memDTO = memberShipMapper.selectOne(authInfo.getUserId());
			String memberNum = memDTO.getMemberNum();
			GoodsBuy goodsBuy = new GoodsBuy() ;
			goodsBuy.setMemberNum(memberNum);
			goodsBuy.setGoodsNums(goodsNum);
			
			Integer i= memberShipMapper.goodsCartDels(goodsBuy);
			model.addAttribute("val" ,i);
			
	}
}
