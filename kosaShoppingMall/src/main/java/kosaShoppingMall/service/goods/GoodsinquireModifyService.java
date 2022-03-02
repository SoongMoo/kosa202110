package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsinquireModifyService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String inquireNum, String goodsNum, Model model) {
		GoodsDTO goodsDto = goodsMapper.goodsSelectOne(goodsNum);
		model.addAttribute("goodsCommand" , goodsDto);
		GoodsInquireDTO  goodsInquireDto =  goodsMapper.goodsInquireSelectOne(inquireNum);
		model.addAttribute("goodsInquireCommand" , goodsInquireDto);
		
	}
	
}
