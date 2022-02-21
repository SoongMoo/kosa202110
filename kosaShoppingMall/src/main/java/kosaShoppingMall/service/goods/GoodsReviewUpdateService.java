package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsReviewDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsReviewUpdateService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum, String goodsNum, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectOne(authInfo.getUserId());
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setGoodsNum(goodsNum);
		reviewDTO.setMemberNum(memberDTO.getMemberNum());
		reviewDTO.setPurchaseNum(purchaseNum);
		GoodsReviewDTO dto = memberShipMapper.reviewSelect(reviewDTO);
		model.addAttribute("goodsReviewDTO", dto);
	}
	public void execute(String purchaseNum, String goodsNum, String reviewContent) {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setGoodsNum(goodsNum);
		reviewDTO.setPurchaseNum(purchaseNum);
		reviewDTO.setReviewContent(reviewContent);
		memberShipMapper.reviewUpdate(reviewDTO);
	}
}










