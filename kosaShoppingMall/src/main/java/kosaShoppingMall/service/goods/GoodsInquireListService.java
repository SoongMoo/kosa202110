package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsInquireListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		
		List<GoodsInquireDTO> list =  goodsMapper.goodsInquireList(goodsNum);
		model.addAttribute("list" ,  list);
				
	}
	
}
