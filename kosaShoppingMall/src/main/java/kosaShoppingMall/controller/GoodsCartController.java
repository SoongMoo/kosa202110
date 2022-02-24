package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.PurchaseCommand;
import kosaShoppingMall.service.goods.GoodsReviewDeleteService;
import kosaShoppingMall.service.goods.GoodsReviewUpdateService;
import kosaShoppingMall.service.goods.ReviewWriteService;
import kosaShoppingMall.service.memberJoin.DoPaymentService;
import kosaShoppingMall.service.memberJoin.GoodsBuyService;
import kosaShoppingMall.service.memberJoin.GoodsCartDelsService;
import kosaShoppingMall.service.memberJoin.GoodsCartListService;
import kosaShoppingMall.service.memberJoin.GoodsCartQtyDownService;
import kosaShoppingMall.service.memberJoin.GoodsOrderService;
import kosaShoppingMall.service.memberJoin.OrderProcessListService;
import kosaShoppingMall.service.memberJoin.PaymentDelService;
import kosaShoppingMall.service.memberJoin.PuchaseDelService;
import kosaShoppingMall.service.memberJoin.PuchaseDetailService;

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
	@Autowired
	DoPaymentService doPaymentService;
	@Autowired
	PuchaseDetailService puchaseDetailService;
	@Autowired
	PaymentDelService paymentDelService;
	@Autowired
	PuchaseDelService puchaseDelService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	GoodsReviewUpdateService goodsReviewUpdateService;
	@Autowired
	GoodsReviewDeleteService goodsReviewDeleteService;
	
	@RequestMapping(value = "/cart/goodsReviewDelete")
		public String goodsReviewDelete(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="goodsNum") String goodsNum) {
				goodsReviewDeleteService.execute(purchaseNum , goodsNum);
				return "redirect:/cart/orderList";
			
		}
		
	
	
	@RequestMapping(value="/cart/goodsReviewUpdate", method = RequestMethod.POST)
	public String reviewUpdate1(@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="reviewContent")String reviewContent) {
		goodsReviewUpdateService.execute(purchaseNum, goodsNum, reviewContent);
		return "redirect:/cart/orderList";
	}
	@RequestMapping(value="/cart/goodsReviewUpdate", method = RequestMethod.GET)
	public String reviewUpdate(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="goodsNum") String goodsNum,
			HttpSession session, Model  model) {
		goodsReviewUpdateService.execute(purchaseNum, goodsNum, session, model);
		return "thymeleaf/membership/goodsReviewUpdate";
	}
	
	@RequestMapping(value="/cart/reviewWrite", method = RequestMethod.POST)
	public String reviewWrite(@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="reviewContent") String reviewContent,
			@RequestParam(value="purchaseNum") String purchaseNum) {
		reviewWriteService.execute(goodsNum,reviewContent,purchaseNum  );
		return "redirect:/cart/orderList";
	}
	
	@RequestMapping("/cart/goodsReview")
	public String goodsReview(@ModelAttribute(value = "goodsNum") String goodsNum,
			@ModelAttribute(value="purchaseNum") String purchaseNum) {
		return "thymeleaf/membership/goodsReview";
	}
	
	@RequestMapping("/cart/paymentDel")
	public String paymentDel(@RequestParam(value = "purchaseNum")String purchaseNum) {
		puchaseDelService.execute(purchaseNum);
		return "redirect:/cart/orderList";
	}
	
	@RequestMapping("/cart/paymentCancel")
	public String paymentCancel(@RequestParam(value = "purchaseNum")String purchaseNum) {
		paymentDelService.execute(purchaseNum);
		return "redirect:/cart/orderList";
	}
	
	@RequestMapping("/cart/puchaseDetail")
	public String puchaseDetail(@RequestParam(value ="purchaseNum") String purchaseNum, Model model) {
		puchaseDetailService.execute(purchaseNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/membership/puchaseDetail";
	}
	@RequestMapping("/cart/doPayment")
	public String doPayment(@RequestParam(value ="purchaseNum") String purchaseNum,
			@RequestParam(value ="totalPrice") String totalPrice,
			@RequestParam(value ="cardNumber") String cardNumber, Model model) {
		doPaymentService.execute(purchaseNum, totalPrice,cardNumber, model );
		return "thymeleaf/membership/buyfinished";
	}
	
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
	public String paymentOk(@ModelAttribute(value="purchaseNum") String purchaseNum,
			@ModelAttribute(value = "totalPrice") String totalPrice) {
		return "thymeleaf/membership/payment";
	}
	
	@RequestMapping("/cart/cartdel")
	public  String cartdel(@RequestParam(value = "goodsNum[]")String[] goodsNum , Model model , HttpSession session) {
	//	String [] goodsNums = goodsNum.split("/");
	//	System.out.println(goodsNums[0]);
	
		goodsCartDelsService.execute(goodsNum , model ,session);
	
		return "thymeleaf/goods/delPage";
		 
	}
	@RequestMapping(value="/cart/goodsBuy")
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







