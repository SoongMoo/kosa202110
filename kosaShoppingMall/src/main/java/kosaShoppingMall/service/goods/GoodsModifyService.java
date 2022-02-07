package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsModifyService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, Model model) {
		GoodsDTO dto = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());
		model.addAttribute("goodsCommand" , dto);
		
	}

}
