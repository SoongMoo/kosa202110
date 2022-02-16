package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsCartService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	GoodsMapper goodsMapper;
	
	public String execute(String goodsNum,Integer goodsQty, HttpSession session) {
		CartDTO cart = new CartDTO();
		cart.setCartQty(Long.valueOf(goodsQty));
		cart.setGoodsNum(goodsNum);
		cart.setMemberNum((memberShipMapper.selectOne(((AuthInfo)session.getAttribute("authInfo"))
																		.getUserId())).getMemberNum());
		return goodsMapper.cartAdd(cart).toString();
	}

}
