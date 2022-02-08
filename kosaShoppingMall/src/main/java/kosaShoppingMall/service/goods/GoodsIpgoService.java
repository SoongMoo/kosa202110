package kosaShoppingMall.service.goods;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.mapper.GoodsMapper;
@Service
public class GoodsIpgoService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand) {
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		dto.setMadeDate(
				Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		Integer i = goodsMapper.ipgoInsert(dto);
		System.out.println(i + "개행이(가) 삽입되었습니다.");
	}
}



