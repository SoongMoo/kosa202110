package kosaShoppingMall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.service.goods.CheckoutService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsInquireDeletService;
import kosaShoppingMall.service.goods.GoodsInquireListService;
import kosaShoppingMall.service.goods.GoodsInquireWriteService;
import kosaShoppingMall.service.goods.GoodsReviewListService;
import kosaShoppingMall.service.goods.GoodsinquireModifyService;
import kosaShoppingMall.service.goods.GoodsinquireUpdateService;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsInquireWriteService goodsInquireWriteService;
	@Autowired 
	GoodsInquireListService goodsInquireListService;
	@Autowired
	GoodsReviewListService goodsReviewListService;
	@Autowired
	CheckoutService checkoutService ;
	@Autowired
	GoodsInquireDeletService goodsInquireDeletService; 
	@Autowired
	GoodsinquireModifyService goodsinquireModifyService;
	@Autowired
	GoodsinquireUpdateService goodsinquireUpdateService;
	
	@RequestMapping(value = "inquireUpdate" , method = RequestMethod.POST)
	public String inquireUpdate1(GoodsInquireCommand goodsInquireCommand , HttpServletResponse response) {
		goodsinquireUpdateService.execute(goodsInquireCommand);
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
			          +  " opener.parent.inquier();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "inquireUpdate" , method = RequestMethod.GET )
	public String inquireUpdate(@RequestParam (value="inquireNum")String inquireNum ,
			@RequestParam(value = "goodsNum")String goodsNum , Model model 
			 ) {
		goodsinquireModifyService.execute(inquireNum , goodsNum , model);
		return "thymeleaf/goods/inquireUpdate";
	}
		
	@RequestMapping("inquireDelte")
	public String inquireDelte(@RequestParam (value="unquireNum")String unquireNum ,
			@RequestParam(value = "goodsNum")String goodsNum , HttpServletResponse response) {
		goodsInquireDeletService.execute(unquireNum);
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
			          +  " opener.parent.inquier();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("checkout")
	public String checkout(@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="purchaseQty") Integer purchaseQty, HttpSession session) {
		checkoutService.execute(goodsNum,purchaseQty, session);
		return "redirect:/cart/goodsBuy?prodCk="+goodsNum;
	}

	
	@RequestMapping("reviewList")
	public String reviewList(@RequestParam(value = "goodsNum") String goodsNum , Model model , HttpSession session) {
		goodsReviewListService.execute(goodsNum ,model , session);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/goods/reviewList";
	}
	
	
	@RequestMapping("prodInfo")
	public String prodInfo(@RequestParam(value = "goodsNum") String goodsNum,Model model) {
		goodsDetailService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/goods/prodInfo";
	}
	@RequestMapping(value="inquireList" )
	public String  inquireList(@ModelAttribute(value = "goodsNum") String goodsNum, Model model ) {
		goodsInquireListService.execute(goodsNum ,model );
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/goods/inquireList";
	}
	@RequestMapping(value="inquireWrite" , method = RequestMethod.GET)
	public String inquireWrite(@RequestParam(value = "goodsNum") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum ,model );
		return "thymeleaf/goods/inquireWrite";
	}
	@RequestMapping(value="inquireWrite" , method = RequestMethod.POST)
	public String inquireWrite(GoodsInquireCommand goodsInquireCommand
		, HttpServletResponse response , HttpSession session) {
		goodsInquireWriteService.execute(goodsInquireCommand , session);
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
			          +  " opener.parent.inquier();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}