package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GoodsCommand {
	@NotBlank(message = "번호가 없어요")
	String goodsNum;
	@NotBlank(message = "상품 이름을 입력하세요")
	String goodsName;
	@NotNull(message = "상품 가격을 입력하세요")
	Integer goodsPrice;
	@NotBlank(message = "상품 설명을 입력하세요.")
	String goodsContent;
	@NotNull(message = "상품 배송비를 입력하세요.")
	Integer deliveryCost;
	
}
