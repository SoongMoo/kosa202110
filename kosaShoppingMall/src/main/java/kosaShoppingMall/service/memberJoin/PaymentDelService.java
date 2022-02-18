package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class PaymentDelService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum) {
		Integer i = memberShipMapper.paymentDelete(purchaseNum);
		if(i==1) {
			memberShipMapper.purchaseStatusBack(purchaseNum);
		}
		
	}
	
}
