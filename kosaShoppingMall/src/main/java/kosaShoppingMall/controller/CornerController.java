package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.service.goods.GoodsDetailService;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("prodInfo")
	public String prodInfo(@RequestParam(value = "goodsNum") String goodsNum,Model model) {
		goodsDetailService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/goods/prodInfo";
	}
	@RequestMapping(value="inquireList" )
	public String  inquireList(@RequestParam(value = "goodsNum") String goodsNum,Model model) {
		return "thymeleaf/goods/inquireList";
	}
	@RequestMapping(value="inquireWrite")
	public String inquireWrite() {
		return "thymeleaf/goods/inquireWrite";
	}
}
