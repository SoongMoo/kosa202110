package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.service.goods.GoodsDetailService;

@Controller
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("/corner/prodInfo")
	public String prodInfo(@RequestParam(value = "goodsNum") String goodsNum,Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/prodInfo";
	}
}
