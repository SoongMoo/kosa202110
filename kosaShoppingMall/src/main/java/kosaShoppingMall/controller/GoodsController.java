package kosaShoppingMall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.service.goods.GoodsAutoNum;
import kosaShoppingMall.service.goods.GoodsDeleteService;
import kosaShoppingMall.service.goods.GoodsDelsService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsIpgoDeleteService;
import kosaShoppingMall.service.goods.GoodsIpgoDelsService;
import kosaShoppingMall.service.goods.GoodsIpgoDetailService;
import kosaShoppingMall.service.goods.GoodsIpgoListService;
import kosaShoppingMall.service.goods.GoodsIpgoModifyService;
import kosaShoppingMall.service.goods.GoodsIpgoService;
import kosaShoppingMall.service.goods.GoodsIpgoUpdateService;
import kosaShoppingMall.service.goods.GoodsItemService;
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
	@Autowired
	GoodsItemService goodsItemService;
	@Autowired 
	GoodsIpgoService goodsIpgoService;
	@Autowired
	GoodsIpgoListService goodsIpgoListService;
	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;
	@Autowired
	GoodsIpgoModifyService goodsIpgoModifyService;
	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService; 
	@Autowired
	GoodsIpgoDeleteService goodsIpgoDeleteService;
	@Autowired
	GoodsIpgoDelsService goodsIpgoDelsService;
	@Autowired
	GoodsDelsService goodsDelsService;
	
	@RequestMapping("fileDel")
	public String fileDel() {
		return "thymeleaf/goods/delPage";
	}
	@RequestMapping(value="goodsDels", method = RequestMethod.POST)
	public String goodsDels(@RequestParam(value="delete") String [] deletes) {
		goodsDelsService.execute(deletes);
		return "redirect:goodsList";
	}
	@RequestMapping(value="goodsIpgodels" , method = RequestMethod.POST)
	public String goodsIpgodels(@RequestParam(value="delete") String [] deletes) {
		goodsIpgoDelsService.execute(deletes);
		return "redirect:goodsIpgoList";
	}
	
	@RequestMapping(value = "goodsIpgoDelete" , method = RequestMethod.GET)
	public String goodsIpgoDelete(GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoDeleteService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}

	@RequestMapping(value ="goodsIpgoModify" , method = RequestMethod.POST)
	public String goodsIpgoModify(GoodsIpgoCommand goodsIpgoCommand) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(goodsIpgoCommand.getIpgoDate());
		goodsIpgoUpdateService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoDetail?goodsNum="+goodsIpgoCommand.getGoodsNum()+
				"&ipgoDate="+date;
	}
	
	@RequestMapping(value="goodsIpgoModify" , method = RequestMethod.GET)
	public String goodsIpgoModify(@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value="ipgoDate") String ipgoDate, Model model) {
		goodsIpgoModifyService.execute(goodsNum,ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoUpdate";
	}
	
	
	@RequestMapping("goodsIpgoDetail")
	public String goodsIpgoDetail(@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value="ipgoDate") String ipgoDate, Model model) {
		goodsIpgoDetailService.execute(goodsNum,ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoDetail";
	}
	
	@RequestMapping(value="ipgoRegist", method = RequestMethod.GET)
	public String ipgoRegist1() {
		return "redirect:/";
	}
	@RequestMapping(value="ipgoRegist", method = RequestMethod.POST)
	public String ipgoRegist(@Validated GoodsIpgoCommand goodsIpgoCommand,
			BindingResult result ) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsIpgo";
		}
		goodsIpgoService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
	@RequestMapping(value="goodsItem", method = RequestMethod.GET)
	public String goodsItem() {
		return "thymeleaf/goods/goodsItem";
	}
	
	@RequestMapping(value="goodsItem", method = RequestMethod.POST)
	public String goodsItems(@RequestParam(value="goodsName") String goodsName, 
			Model model) {
		goodsItemService.execute(goodsName, model);
		return "thymeleaf/goods/goodsItem";
	}

	@RequestMapping("goodsIpgo")
	public String goodsIpgo( GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoCommand.setIpgoDate(new Date());
		return "thymeleaf/goods/goodsIpgo";
	}
	
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(Model model) {
		goodsIpgoListService.execute(model);
		return "thymeleaf/goods/goodsIpgoList";
	}
	
	
	@RequestMapping("goodsSearch")
	public String goodsSearch(@RequestParam(value = "goodsWord")String goodsWord , Model model){
		goodsSearchService.execute(goodsWord ,model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value = "goodsDelete/{goodsNum}",method = RequestMethod.GET)
	public String goodsDelete(@PathVariable(value="goodsNum")String goodsNum
			, HttpServletRequest request) {
		goodsDeleteService.execute(goodsNum, request);
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
	public String goodsRegist(@Validated GoodsCommand goodsCommand , BindingResult result,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		if(goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문이미지를 선택하여주세요.");
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand, request);
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
