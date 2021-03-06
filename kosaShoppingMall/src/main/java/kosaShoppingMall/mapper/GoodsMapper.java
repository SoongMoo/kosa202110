package kosaShoppingMall.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.domain.DeliveryDTO;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.domain.WishDTO;

@Component
@Repository(value="kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	public String goodsAutoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsList(StartEndPageDTO dto);
	public GoodsDTO goodsSelectOne(String goodsNum);
	public void goodsVisitCnt(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDelete(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);
	public List<GoodsDTO> goodsItems(StartEndPageDTO dto);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect(StartEndPageDTO dto);
	/// 1 대 1 정보
	public GoodsIpgoGoodsDTO ipgoDetail(GoodsIpgoDTO idto);
	public GoodsDTO getGoodsIpgoInfo(GoodsIpgoDTO idto);
	
	public Integer goodsIpgoUpdate(GoodsIpgoDTO dto);
	public Integer goodsIpgoDelete(GoodsIpgoCommand goodsIpgoCommand);
	
	// 배열을 이용한 방법
	public Integer goodsDels(String[] deletes);
	// 리스트를 이용한 방법
	public Integer goodsDeletes(List<String> cs);
	// Map을 사용한 방법
	public Integer goodsRemove(Map<String, Object> condition);
	
	public Integer goodsIpgoDels(List<String[]> condition);
	public Integer count(String goodsWord);
	public Integer goodsCount();
	public Integer goodsItemCount(String goodsWord);
	public List<GoodsDTO> goodsSelect(HashMap<String, Object> condition);
	public Integer wishAdd(WishDTO dto);
	public String wishCount(WishDTO dto);
	public Integer cartAdd(CartDTO cart);
	
	//성호 
	public List<OrderListDTO> purchaseList();
	public List<OrderListDTO> purchaseEmpDetail(String purchaseNum );
	public Integer statusUpdate(String purchaseNum);
	
	//
	public Integer deliveryInsert(DeliveryCommand deliveryCommand);
	public Integer deliveryStatus(String purchaseNum);
	public Integer deliveryUpdate(DeliveryDTO dto);
	public Integer deliveryDelete(String purchaseNum);
	public Integer reviewWrite(ReviewDTO dto);
	public Integer goodsInquireWriteService(GoodsInquireDTO dto);
	public List<GoodsInquireDTO> goodsInquireList(String goodsNum);
	public List<ReviewDTO> goodsReviewList(String goodsNum);
	public List<GoodsInquireDTO> goodsInquire();
	public GoodsInquireDTO goodsInquire(String inquireNum);
	public Integer setInquireAnswer(GoodsInquireDTO goodsInquireDTO);
	public Integer goodsInquireDelete(String unquireNum);
	public GoodsInquireDTO goodsInquireSelectOne(String inquireNum);
	public Integer goodsInquireUpdate(GoodsInquireDTO dto);

}















