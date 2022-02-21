package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class DeliveryDelService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String purchaseNum) {
		goodsMapper.statusUpdate(purchaseNum);
		goodsMapper.deliveryDelete(purchaseNum);
	}
}
