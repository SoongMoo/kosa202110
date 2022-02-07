package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsSearchService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsWord, Model model) {
		List<GoodsDTO> list = goodsMapper.searchGoods(goodsWord);
		model.addAttribute("list" ,list);
	}

}
