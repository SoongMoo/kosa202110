package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class DeliveryActionService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(DeliveryCommand deliveryCommand) {
		Integer i = goodsMapper.deliveryInsert(deliveryCommand);
		if(i >= 1) {
			/// 상품대기중 ===> 배송완료
			goodsMapper.deliveryStatus(deliveryCommand.getPurchaseNum());
		}
	}

}
