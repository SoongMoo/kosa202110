package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class PurchaseEmpDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String purchaseNum , Model model) {
	    List<OrderListDTO> list = goodsMapper.purchaseEmpDetail(purchaseNum);
	    goodsMapper.statusUpdate(purchaseNum);
	    model.addAttribute("list" , list);
	}
}
