package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderListDTO")
public class OrderListDTO {
	String goodsNum;
	String goodsNun;
	String confirmNumber;
	String purchaseStatus;
	String goodsName;
	String goodsMain;
	String goodsContent;
	String goodsPrice;
	String deliveryCost;
	String purchaseNum;
	Date purchaseDate;
	String totalPrice;
	String purchaseAddr;
	String purchasePhone;
	String message;
	String recieveName;
	String purchaseQty;
	String purchasePrice;
	String paymentKind;
	String pymentPrice;
	Date paymentDate;
	String cardNumber;
	String deliveryNumber;
	String deliveryCompany;
	String reviewContent;
}
