package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.GoodsCommand;
import springBootTest2.service.goods.GoodsDeleteService;
import springBootTest2.service.goods.GoodsDetailService;
import springBootTest2.service.goods.GoodsListService;
import springBootTest2.service.goods.GoodsNumService;
import springBootTest2.service.goods.GoodsRegistService;
import springBootTest2.service.goods.GoodsUpdateService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsRegistService goodsRegistService;
	@Autowired
	GoodsNumService goodsNumService;
	@Autowired
	GoodsListService goodsListService ;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService ;
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite(Model model) {
		goodsNumService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping(value = "goodsRegist", method = RequestMethod.POST)
	public String goodsRegist(GoodsCommand goodsCommamnd,
			HttpServletRequest request ) {
		goodsRegistService.execute(goodsCommamnd,request);
		return "redirect:goodsList";
	}
	@RequestMapping("goodsInfo")
	public String goodsInfo(@RequestParam(value="num") String goodsNum,
			Model model) {
		model.addAttribute("newLineChar", '\n');
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	@RequestMapping("goodsModify")
	public String goodsModify(@RequestParam(value="num") String goodsNum,
			Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand, HttpSession session) {
		goodsUpdateService.execute(goodsCommand, session);
		return "redirect:goodsInfo?num="+goodsCommand.getGoodsNum();
	}
	@RequestMapping("goodsDelete")
	public String goodsDelete(@RequestParam(value="num") String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:goodsList";
	}
}