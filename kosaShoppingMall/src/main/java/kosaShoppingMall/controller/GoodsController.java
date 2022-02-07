package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.service.goods.GoodsAutoNum;
import kosaShoppingMall.service.goods.GoodsDeleteService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsListService;
import kosaShoppingMall.service.goods.GoodsModifyService;
import kosaShoppingMall.service.goods.GoodsSearchService;
import kosaShoppingMall.service.goods.GoodsUpdateService;
import kosaShoppingMall.service.goods.GoodsWriteService;

@RequestMapping("goods")
@Controller
public class GoodsController {
	@Autowired
	GoodsAutoNum goodsAutoNum; 
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsModifyService goodsModifyService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@Autowired
	GoodsSearchService goodsSearchService;
	
	@RequestMapping("goodsSearch")
	public String goodsSearch(@RequestParam(value = "goodsWord")String goodsWord , Model model){
		goodsSearchService.execute(goodsWord ,model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value = "goodsDelete/{goodsNum}",method = RequestMethod.GET)
	public String goodsDelete(@PathVariable(value="goodsNum")String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:../goodsList";
	}
		 
	
	@RequestMapping(value = "goodsUpdate" , method = RequestMethod.POST)
	public String goodsUpdate(@Validated GoodsCommand goodsCommand ,BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsUpdate";
		}
		goodsUpdateService.execute(goodsCommand);
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
		
	
	@RequestMapping(value = "goodsModify" , method = RequestMethod.GET)
	public String goodsNum(GoodsCommand goodsCommand ,Model model ) {
		goodsModifyService.execute(goodsCommand , model );
		return "thymeleaf/goods/goodsUpdate";
	}
	
	
	@RequestMapping(value="goodsDetail/{goodsNum}" , method = RequestMethod.GET)
	public String goodsDetail(@PathVariable(value = "goodsNum")String goodsNum ,Model model) {
		goodsDetailService.execute(goodsNum , model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@RequestMapping(value="goodsRegist" ,method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand , BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand);
		return "redirect:goodsList";
	}
	
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goods(GoodsCommand goodsCommand) {
		goodsAutoNum.execute(goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}

}
