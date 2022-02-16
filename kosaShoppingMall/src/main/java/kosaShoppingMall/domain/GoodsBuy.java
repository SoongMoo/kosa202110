package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsBuy")
public class GoodsBuy {
	String [] goodsNums;
	String memberNum;
}