package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.GoodsCartDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Service
public class GoodsBuyService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String[] goodsNums, HttpSession session, Model model) {
		AuthInfo authInfo =
				(AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectOne(authInfo.getUserId());
		GoodsBuy goodsBuy = new GoodsBuy();
		goodsBuy.setGoodsNums(goodsNums);
		goodsBuy.setMemberNum(memberDTO.getMemberNum());
		List<GoodsCartDTO> list =  memberShipMapper.goodsOrder(goodsBuy);
		Long goodsTotalPrice = 0L;
		for( GoodsCartDTO dto : list) {
			goodsTotalPrice += dto.getCartDTO().getTotalPrice();
		}
		Long goodsTotalDelivery = 0L;
		for( GoodsCartDTO dto : list) {
			goodsTotalDelivery += dto.getGoodsDTO().getDeliveryCost();
		}
		String goodsNum = "";
		for(GoodsCartDTO dto : list) {
			goodsNum += dto.getCartDTO().getGoodsNum() + "/";
		}
		
		model.addAttribute("goodsTotalDelivery", goodsTotalDelivery);
		model.addAttribute("goodsTotalPrice", goodsTotalPrice);
		model.addAttribute("goodsNums", goodsNum);
		model.addAttribute("list", list);
	}
}

