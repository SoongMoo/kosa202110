package kosaShoppingMall.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.command.FileInfo;
import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.service.goods.DeliveryActionService;
import kosaShoppingMall.service.goods.DeliveryDelService;
import kosaShoppingMall.service.goods.DeliveryUpdateService;
import kosaShoppingMall.service.goods.FileDelService;
import kosaShoppingMall.service.goods.GoodsAutoNum;
import kosaShoppingMall.service.goods.GoodsDeleteService;
import kosaShoppingMall.service.goods.GoodsDelsService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsListService;
import kosaShoppingMall.service.goods.GoodsModifyService;
import kosaShoppingMall.service.goods.GoodsSearchService;
import kosaShoppingMall.service.goods.GoodsUpdateService;
import kosaShoppingMall.service.goods.GoodsWriteService;
import kosaShoppingMall.service.goods.PurchaseEmpDetailService;
import kosaShoppingMall.service.goods.PurchaseListService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoDeleteService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoDelsService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoDetailService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoListService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoModifyService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoService;
import kosaShoppingMall.service.goodsIpgo.GoodsIpgoUpdateService;
import kosaShoppingMall.service.goodsIpgo.GoodsItemService;

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
	@Autowired
	FileDelService fileDelService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	PurchaseEmpDetailService purchaseEmpDetailService;
	@Autowired
	DeliveryActionService deliveryActionService;
	@Autowired 
	DeliveryDelService DeliveryDelService;
	
	@RequestMapping("deliveryDel")
	public String deliveryDel(@RequestParam (value = "purchaseNum")String purchaseNum , HttpServletResponse response) {
		
			DeliveryDelService.execute(purchaseNum);
		
		
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
			          +  "opener.location.reload();"
			          + "				window.self.close();"
			          + "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
		
	@RequestMapping("deliveryUpdate")
	public String deliveryUpdate() {
		return "thymeleaf/goods/deliveryUpdate";
	}
	@RequestMapping(value="deliveryAction", method = RequestMethod.POST)
	public String deliveryAction(DeliveryCommand deliveryCommand) {
		deliveryActionService.execute(deliveryCommand);
		return "redirect:purchaseList";
	}
	
	@RequestMapping("puchaseDetail")
	public String puchaseDetail(@RequestParam(value = "purchaseNum")String purchaseNum , Model model) {
		purchaseEmpDetailService.execute(purchaseNum , model);
		model.addAttribute("newLineChar" , "\n");
		return "thymeleaf/goods/purchaseDetail";
	}
	
	@RequestMapping("purchaseList")
	public String purchaseList(Model model) {
		purchaseListService.execute(model);
		return "thymeleaf/goods/purchaseList";
	}
	
	@RequestMapping("fileDel")
	public String fileDel(FileInfo fileInfo, HttpSession session,Model model) {
		fileDelService.fileAdd(fileInfo,session,model );
		return "thymeleaf/goods/delPage";
	}
	@RequestMapping(value="goodsDels", method = RequestMethod.POST)
	public String goodsDels(@RequestParam(value="delete") String [] deletes, HttpServletRequest request) {
		goodsDelsService.execute(deletes, request);
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

	
	
	@RequestMapping(value="goodsItem")
	public String goodsItems(@RequestParam(value = "page" , defaultValue = "1" , required = false)Integer page,
			@RequestParam(value="goodsWord" , required = false) String goodsWord, 
			Model model) {
		goodsItemService.execute(page,goodsWord, model);
		return "thymeleaf/goods/goodsItem";
	}

	@RequestMapping("goodsIpgo")
	public String goodsIpgo( GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoCommand.setIpgoDate(new Date());
		return "thymeleaf/goods/goodsIpgo";
	}
	
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(@RequestParam(value = "page",required = false ,defaultValue = "1")Integer page , Model model) {
		goodsIpgoListService.execute(page ,model);
		return "thymeleaf/goods/goodsIpgoList";
	}
	//여기까지
	
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
	public String goodsUpdate(@Validated GoodsCommand goodsCommand ,BindingResult result, HttpSession session ) {
		if(result.hasErrors()) {
			return "redirect:goodsModify?goodsNum="+goodsCommand.getGoodsNum();
			//return "thymeleaf/goods/goodsUpdate";
		}
		goodsUpdateService.execute(goodsCommand, session);
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
		model.addAttribute("newLineChar", '\n'); 
		return "thymeleaf/goods/goodsDetail";
	}
	
	/*
	   @RequestParam(value="goodsMain") MultipartFile goodsMain
	   @RequestParam(value="goodsImages") MultipartFile [] goodsImages
	 */
	@RequestMapping(value="goodsRegist" ,method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand , BindingResult result,HttpServletRequest request) {
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
	public String goodsList(
			@RequestParam(value="page",defaultValue = "1" ,required = false ) int page,
			@RequestParam(value="goodsWord", required = false ) String goodsWord, Model model) {
		goodsListService.execute(model, goodsWord, page);
		return "thymeleaf/goods/goodsList";
	}

}






