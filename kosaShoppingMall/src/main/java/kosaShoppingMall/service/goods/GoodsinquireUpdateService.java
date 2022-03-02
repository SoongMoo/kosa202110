package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsinquireUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsInquireCommand goodsInquireCommand) {
		GoodsInquireDTO dto = new GoodsInquireDTO();
		dto.setInquireNum(goodsInquireCommand.getInquireNum());
		dto.setInquireContent(goodsInquireCommand.getInquireContent());
		dto.setInquireKind(goodsInquireCommand.getHchkQueryType());
		dto.setAnswerEmail(goodsInquireCommand.getEmail1()+"@"+goodsInquireCommand.getEmail2());
		dto.setInquireSubject(goodsInquireCommand.getInquireSubject());
		
		goodsMapper.goodsInquireUpdate(dto);
		
	}

}
