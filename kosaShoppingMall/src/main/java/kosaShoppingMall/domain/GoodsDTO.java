package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value="goodsDTO")

public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContent;
	String goodsImages;
	String goodsMain;
	Integer deliveryCost;
	Integer vistCount;
}
