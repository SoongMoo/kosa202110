package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class PurchaseListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		List<OrderListDTO> list =  goodsMapper.purchaseList();
		model.addAttribute("list" , list);
	}
}
