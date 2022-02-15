package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("wishDTO")
public class WishDTO {
	String goodsNum;
	String memberNum;
	Date wishDate;
}
