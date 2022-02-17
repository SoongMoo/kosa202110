package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paymentDTO")
public class PaymentDTO {
	String purchaseNum;
	String paymentKind;
	String paymentPrice;
	Date paymentDate;
	String confirmNumber;
	String cardNumber;
}	
