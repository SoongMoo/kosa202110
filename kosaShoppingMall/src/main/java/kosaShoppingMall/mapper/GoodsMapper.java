package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.GoodsDTO;

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
	
}
