package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.service.memberJoin.GoodsCartListService;
import kosaShoppingMall.service.memberJoin.GoodsCartQtyDownService;

@Controller
public class GoodsCartController {
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@RequestMapping(value="/cart/goodsCartQtyDown")
	public String goodsCartQtyDown(
			@RequestParam(value = "goodsNum") String goodsNum,
			HttpSession session) {
		goodsCartQtyDownService.execute(goodsNum, session);
		return "redirect:/cart/goodsCartList";
	}
	@RequestMapping(value="/cart/goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.execute(session, model);
		return "thymeleaf/membership/cartList";
	}
}







