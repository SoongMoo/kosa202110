package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberShipMapper;
@Service
public class GoodsInquireWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(GoodsInquireCommand goodsInquireCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String memberId =(memberShipMapper.selectOne(authInfo.getUserId()).getMemberNum());
		GoodsInquireDTO dto = new GoodsInquireDTO();
		dto.setGoodsNum(goodsInquireCommand.getGoodsNum());
		dto.setInquireContent(goodsInquireCommand.getInquireContent());
		dto.setInquireKind(goodsInquireCommand.getHchkQueryType());
		dto.setInquireSubject(goodsInquireCommand.getInquireSubject());
		dto.setMemberNum(memberId);
		goodsMapper.goodsInquireWriteService(dto);
	}

}
