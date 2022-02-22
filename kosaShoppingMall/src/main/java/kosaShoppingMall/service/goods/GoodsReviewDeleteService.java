package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.MemberMapper;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsReviewDeleteService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum, String goodsNum) {
		ReviewDTO dto = new ReviewDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setGoodsNum(goodsNum);
		memberShipMapper.reviewDelete(dto);
	}
	
}
