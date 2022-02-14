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
	Integer deliveryCost;
	Integer vistCount;
	
	String goodsImages; //content 이미지에 대한 storeFileName 
	String goodsOriginal; // content 이미지에 대한 originalFileName 
	
	String goodsMain;  // 대문이미지에 대한 storeFileName 
	String goodsMainOrg; // 대문이미지에 대한 originalFileName 

	
	
	GoodsIpgoDTO goodsIpgoDTO;
}







