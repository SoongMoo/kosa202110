package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsItemService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsName, Model model) {
		List<GoodsDTO> list = goodsMapper.goodsItems(goodsName);
		model.addAttribute("list", list);
	}
}
