package kosaShoppingMall.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias(value = "goodsIpgoDTO")
public class GoodsIpgoDTO {
	Date ipgoDate;
	String goodsNum;
	Integer ipgoQty;
	Timestamp madeDate;
}
