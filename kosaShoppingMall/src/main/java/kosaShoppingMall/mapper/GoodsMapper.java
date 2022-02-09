package kosaShoppingMall.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;

@Component
@Repository(value="kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	public String goodsAutoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsList();
	public GoodsDTO goodsSelectOne(String goodsNum);
	public void goodsVisitCnt(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDelete(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);
	public List<GoodsDTO> goodsItems(String goodsName);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect();
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
}















