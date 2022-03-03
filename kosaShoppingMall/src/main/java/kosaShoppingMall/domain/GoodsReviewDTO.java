package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("goodsReviewDTO")
@NoArgsConstructor
@AllArgsConstructor
public class GoodsReviewDTO {
	GoodsDTO goodsDTO;
	ReviewDTO reviewDTO;
}
