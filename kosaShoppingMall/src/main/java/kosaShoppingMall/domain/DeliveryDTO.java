package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Alias("deliveryDTO")
public class DeliveryDTO {
	String purchaseNum;
	String deliveryCompany;
	String deliveryNumber;
}
