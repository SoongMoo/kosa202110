package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("StartEndPageDTO")
public class StartEndPageDTO {
	Long startRow;
	Long endRow;
	
	String goodsWord;
}
