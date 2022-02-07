package kosaShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("goods")
@Controller
public class GoodsController {
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goods() {
		return "thymeleaf/goods/goodsForm";
	}
}
