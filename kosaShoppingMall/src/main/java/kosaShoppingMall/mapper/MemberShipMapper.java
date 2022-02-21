package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.GoodsCartDTO;
import kosaShoppingMall.domain.GoodsReviewDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.domain.PaymentDTO;
import kosaShoppingMall.domain.PaymentPurchaseGoodsDTO;
import kosaShoppingMall.domain.PurchaseDTO;
import kosaShoppingMall.domain.PurchaseListDTO;
import kosaShoppingMall.domain.ReviewDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public MemberDTO selectOne(String memid);
	public Integer memberInsert(MemberDTO dto);
	public Integer memberUpdate(MemberDTO dto);
	public Integer updatePassword(MemberDTO dto);
	public Integer memberDrop(String memId);
	public List<GoodsCartDTO> cartList(String memberNum);
	public Integer goodsCartQtyDown(CartDTO dto);
	public List<GoodsCartDTO> goodsOrder(GoodsBuy goodsBuy);
	// 성호
	public Integer goodsCartDels(GoodsBuy goodsBuy);
	// 
	public Integer purchase(PurchaseDTO dto);
	public Integer purchaseList(PurchaseListDTO purchaseListDTO);
	public Integer cartGoodsDel(GoodsBuy goodsBuy);
	public List<PaymentPurchaseGoodsDTO> orderList(String memberNum);
	public Integer payment(PaymentDTO paymentDTO);
	public Integer purchaseStatus(String purchaseNum);
	public List<OrderListDTO> purchaseDetail(String purchaseNum);
	//성호
	public Integer paymentDelete(String purchaseNum);
	public Integer purchaseStatusBack(String purchaseNum);
	public Integer puchaseDelete(String purchaseNum);
	public GoodsReviewDTO reviewSelect(ReviewDTO reviewDTO);
	
}