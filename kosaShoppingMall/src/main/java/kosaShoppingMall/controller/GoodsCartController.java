package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.PurchaseCommand;
import kosaShoppingMall.service.memberJoin.GoodsBuyService;
import kosaShoppingMall.service.memberJoin.GoodsCartDelsService;
import kosaShoppingMall.service.memberJoin.GoodsCartListService;
import kosaShoppingMall.service.memberJoin.GoodsCartQtyDownService;
import kosaShoppingMall.service.memberJoin.GoodsOrderService;
import kosaShoppingMall.service.memberJoin.OrderProcessListService;

@Controller
public class GoodsCartController {
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsCartDelsService goodsCartDelsService;
	@Autowired
	GoodsOrderService goodsOrderService;
	
	@Autowired
	OrderProcessListService orderProcessListService;
	
	@RequestMapping("/cart/orderList")
	public String orderList(HttpSession session, Model model) {
		orderProcessListService.execute(session, model);
		return "thymeleaf/membership/orderList";
	}
	
	@RequestMapping(value="/cart/goodsOrder", method = RequestMethod.POST)
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session) {
		// 주문 내역 저장
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session);
		// 결제 페이지로 이동
		return "redirect:paymentOk?purchaseNum="+purchaseNum + 
				"&totalPrice="+purchaseCommand.getTotalPrice();
	}
	@RequestMapping("/cart/paymentOk")
	public String paymentOk(@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value = "totalPrice") String totalPrice) {
		return "thymeleaf/membership/payment";
	}
	
	@RequestMapping("/cart/cartdel")
	public  String cartdel(@RequestParam(value = "goodsNum[]")String[] goodsNum , Model model) {
	//	String [] goodsNums = goodsNum.split("/");
	//	System.out.println(goodsNums[0]);
	
		goodsCartDelsService.execute(goodsNum , model);
	
		return "thymeleaf/goods/delPage";
		 
	}
	@RequestMapping(value="/cart/goodsBuy" , method = RequestMethod.POST)
	public String goodsBuy(@RequestParam(value = "prodCk") String [] goodsNums,
			HttpSession session, Model model) {
		goodsBuyService.execute(goodsNums, session, model);
		return "thymeleaf/membership/goodsOrder";
	}
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







