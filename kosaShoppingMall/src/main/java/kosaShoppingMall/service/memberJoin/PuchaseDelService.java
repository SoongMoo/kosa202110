package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class PuchaseDelService {
	@Autowired
	MemberShipMapper memberShipMapper;
	
	public void execute (String puchaseDelService) {
		Integer i = memberShipMapper.puchaseDelete(puchaseDelService);
	}
}
