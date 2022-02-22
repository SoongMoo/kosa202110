package kosaShoppingMall.service.goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsReviewListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum ,Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		model.addAttribute("authInfoId" , authInfo.getUserId());
		List<ReviewDTO> list =  goodsMapper.goodsReviewList(goodsNum);
		
		model.addAttribute("list" , list);
	}
	
}
