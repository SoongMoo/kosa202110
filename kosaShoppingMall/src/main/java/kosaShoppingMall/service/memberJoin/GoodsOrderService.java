package kosaShoppingMall.service.memberJoin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.PurchaseCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.PurchaseDTO;
import kosaShoppingMall.domain.PurchaseListDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Service
public class GoodsOrderService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public String execute(PurchaseCommand purchaseCommand,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectOne(authInfo.getUserId());
		// 구매
		PurchaseDTO dto = new PurchaseDTO();
		dto.setMemberNum(memberDTO.getMemberNum());
		dto.setMessage(purchaseCommand.getMessage());
		dto.setPurchaseAddr(purchaseCommand.getPurchaseAddr());
		dto.setPurchasePhone(purchaseCommand.getPurchasePhone());
		dto.setPurchaseStatus("결제대기중");
		dto.setRecieveName(purchaseCommand.getRecieveName());
		dto.setTotalPrice(purchaseCommand.getTotalPrice());
		// 구매번호 
		SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
		String purchaseNum = df.format(new Date());
		dto.setPurchaseNum(purchaseNum);
		Integer i = memberShipMapper.purchase(dto);
		
		// 구매리스트 : 제품마다 insert를 해야 하므로 반복문을 사용해서 insert문을 실행
		if(i == 1) {
			// 구매 리스트에 정보 저장
				for(String goodsNum : purchaseCommand.getGoodsNums().split("/")) {
					PurchaseListDTO purchaseListDTO = new PurchaseListDTO();
					purchaseListDTO.setGoodsNum(goodsNum);
					purchaseListDTO.setPurchaseNum(purchaseNum);
					purchaseListDTO.setMemberNum(memberDTO.getMemberNum());
					memberShipMapper.purchaseList(purchaseListDTO);
				}
				// 장비구니에서 구매한 상품 제거
				GoodsBuy goodsBuy = new GoodsBuy();
				goodsBuy.setGoodsNums(purchaseCommand.getGoodsNums().split("/"));
				goodsBuy.setMemberNum(memberDTO.getMemberNum());
				memberShipMapper.cartGoodsDel(goodsBuy);
		}
		return purchaseNum;
	}

}
