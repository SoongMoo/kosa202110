package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.EmpEmailUpdatecheckService;
import kosaShoppingMall.service.IdcheckService;
import kosaShoppingMall.service.MemEmailUpdateCkService;
import kosaShoppingMall.service.goods.DeliveryUpdateService;
import kosaShoppingMall.service.goods.GoodsCartService;
import kosaShoppingMall.service.goods.GoodsWishService;

@RestController
public class CheckController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService ;
	@Autowired 
	EmpEmailUpdatecheckService empEmailUpdatecheckService;
	@Autowired
	MemEmailUpdateCkService memEmailUpdateCkService;
	@Autowired
	GoodsWishService goodsWishService;
	@Autowired
	GoodsCartService goodsCartService;
	@Autowired
	DeliveryUpdateService deliveryUpdateService;
	
	
	@RequestMapping("/goods/deliveryUpdatePro")
	public String deliveryUpdatePro(DeliveryCommand deliveryCommand) {
		Integer i = deliveryUpdateService.execute(deliveryCommand);
		return i.toString();
	}
	@RequestMapping(value = "/cart/goodsCartAdd")
	public String goodsCartAdd(@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value = "goodsQty") Integer goodsQty,HttpSession session) {
		return goodsCartService.execute(goodsNum, goodsQty, session);
	}
	
	
	@RequestMapping(value="/cart/goodsWishAdd")
	public String goodsWishAdd(@RequestParam(value = "goodsNum") String goodsNum, HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	
	// member 업데이트
	@RequestMapping(value = "/mypage/memMyEmailCk", method = RequestMethod.POST)
	public String memMyEmailCk(@RequestParam(value = "memberEmail")String memberEmail ,
			@RequestParam(value = "memberId")String memberId) {
		Integer i = memEmailUpdateCkService.execute(memberEmail , memberId);
		if(i==0) {
			return "사용 가능 이메일입니다.";
		}else {
			return "사용중인 이메일 입니다.";
		}
	}
	
	@RequestMapping(value = "/mem/memEmailCk" , method = RequestMethod.POST)
	public String memEmailCk(@RequestParam(value = "memberEmail")String memberEmail ,
			@RequestParam(value = "memberId")String memberId) {
		Integer i = memEmailUpdateCkService.execute(memberEmail , memberId);
		if(i==0) {
			return "사용 가능 이메일입니다.";
		}else {
			return "사용중인 이메일 입니다.";
		}
	}
	
	// emp 마이 페이지 직원 업데이트
	@RequestMapping(value = "/empMypage/empEmailChecks",method = RequestMethod.POST)
	public String empMyEmailCheck(@RequestParam(value = "empEmail")String empEmail,
			@RequestParam(value = "empId")String empId) {
		Integer i = empEmailUpdatecheckService.execute(empEmail, empId);
		if( i==0) {
			return "사용가능한 이메일 입니다.";
		}else {
			return "사용중인 이메일 입니다.";
		}
	}
	
	
	
	// emp 직원 업데이트
	@RequestMapping(value = "/emp/empEmailChecks",method = RequestMethod.POST)
	public String empEmailChecks(@RequestParam(value = "empEmail")String empEmail,
			@RequestParam(value = "empId")String empId) {
		Integer i = empEmailUpdatecheckService.execute(empEmail, empId);
		if( i==0) {
			return "사용가능한 이메일 입니다.";
		}else {
			return "사용중인 이메일 입니다.";
		}
	}
	
	//emp 직원 폼
	@RequestMapping(value="/emp/emailCheck", method = RequestMethod.POST)
	public String empEmailCheck(@RequestParam(value = "empEmail")String empEmail) {
		Integer i = emailCheckService.execute(empEmail);
		if(i==0) {
			return "사용가능한 이메일입니다.";
		}else {
			return "사용 중인 이메일입니다.";
		}
	}
	@RequestMapping(value="/emp/empIdCheck", method = RequestMethod.POST)
	public String empIdCheck(@RequestParam(value = "empId")String empId) {
		Integer i = idcheckService.execute(empId);
		if(i==0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 중인 아이디입니다.";
		}
	}
	
	// 멤버 폼
	@RequestMapping(value="/mem/emailCheck",method = RequestMethod.POST)
	public String memEmailCheck(@RequestParam(value = "memberEmail")String memberEmail) {
		Integer i = emailCheckService.execute(memberEmail);
		if(i==0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 중인 아이디입니다.";
		}
	}
	
	@RequestMapping(value="/mem/IdCheck",method = RequestMethod.POST)
	public String memIdCheck(@RequestParam(value="memberId") String memberId) {
		Integer i = idcheckService.execute(memberId);
		if(i == 0) {
			return "사용가능한 id입니다.";
		}else {
			return "사용중인 id입니다.";
		}
	}
	// 멤버 마이페이지
	@RequestMapping(value="/register/emailCheck",method = RequestMethod.POST)
	public String emailCheck(@RequestParam(value="memberEmail") String memberEmail) {
		Integer i = emailCheckService.execute(memberEmail);
		if(i == 0) {
			return "사용가능한 email입니다.";
		}else {
			return "사용중인 email입니다.";
		}
	}
	@RequestMapping(value="/register/idCheck",method = RequestMethod.POST)
	public String idCheck(@RequestParam(value="memberId") String memberId) {
		Integer i = idcheckService.execute(memberId);
		if(i == 0) {
			return "사용가능한 id입니다.";
		}else {
			return "사용중인 id입니다.";
		}
	}
}
