package kosaShoppingMall.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paymentPurchaseGoodsDTO")
public class PaymentPurchaseGoodsDTO {
	PaymentDTO paymentDTO;
	PurchaseDTO purchaseDTO;
	List<GoodsDTO> goodsDTOs;
}
