package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsQuestionService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		List<GoodsInquireDTO> list = goodsMapper.goodsInquire();
		model.addAttribute("list", list);
	}
}
