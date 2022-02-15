package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.WishDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsWishService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberShipMapper memberShipMapper;
	public String execute(String goodsNum, HttpSession session) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		WishDTO dto = new WishDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberShipMapper.selectOne(userId).getMemberNum());
		goodsMapper.wishAdd(dto);
		return goodsMapper.wishCount(dto);
	}

}












