package kosaShoppingMall.command;

import lombok.Data;

@Data
public class GoodsInquireCommand {
	String goodsNum;
	String hchkQueryType;
	String inquireSubject;
	String inquireContent;
	String email1;
	String email2;
}
