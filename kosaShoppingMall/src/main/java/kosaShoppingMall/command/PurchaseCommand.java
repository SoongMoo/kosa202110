package kosaShoppingMall.command;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data

public class PurchaseCommand {
	String recieveName;
	String purchaseAddr;
	String purchasePhone;
	String message;
	String goodsNums;
	Long goodsTotalPrice;
	Long goodsTotalDelivery;
	Long totalPrice;
}
