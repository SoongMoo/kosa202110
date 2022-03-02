package kosaShoppingMall.command;

import lombok.Data;

@Data
public class GoodsInquireCommand {
	Integer inquireNum;
	String goodsNum;
	String hchkQueryType;
	String inquireSubject;
	String inquireContent;
	String email1;
	String email2;
}
