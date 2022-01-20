package springBootTest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite() {
		return "thymeleaf/goods/goodsForm";
	}
	
}



