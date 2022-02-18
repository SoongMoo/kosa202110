package kosaShoppingMall.command;

import lombok.Data;

@Data
public class DeliveryCommand {
	String purchaseNum;
	String deliveryCompany;
	String deliveryNumber;
}
