package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsInquireDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String inquireNum, Model model) {
		GoodsInquireDTO dto = goodsMapper.goodsInquire(inquireNum);
		model.addAttribute("goodsInquireDTO", dto);
	}
}
