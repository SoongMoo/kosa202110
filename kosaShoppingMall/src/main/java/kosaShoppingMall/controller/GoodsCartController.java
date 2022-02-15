package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kosaShoppingMall.service.memberJoin.GoodsCartListService;

@Controller
public class GoodsCartController {
	@Autowired
	GoodsCartListService goodsCartListService;
	@RequestMapping(value="/cart/goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.execute(session, model);
		return "thymeleaf/membership/cartList";
	}
}







