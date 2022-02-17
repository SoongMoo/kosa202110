package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class GoodsCartDelsService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String[] goodsNum , Model model) {
		
			Integer i= memberShipMapper.goodsCartDels(goodsNum);
			model.addAttribute("val" ,i);
			
	}
}
