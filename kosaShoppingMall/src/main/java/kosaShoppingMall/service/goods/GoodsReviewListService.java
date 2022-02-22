package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsReviewListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum ,Model model) {
		List<ReviewDTO> list =  goodsMapper.goodsReviewList(goodsNum);
		model.addAttribute("list" , list);
	}
	
}
