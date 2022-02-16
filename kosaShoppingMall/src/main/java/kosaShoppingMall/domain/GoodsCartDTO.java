package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("GoodsCartDTO")
public class GoodsCartDTO {
	GoodsDTO goodsDTO;
	CartDTO cartDTO;
}
