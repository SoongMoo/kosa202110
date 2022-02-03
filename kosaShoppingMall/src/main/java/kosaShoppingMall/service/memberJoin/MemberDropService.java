package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberShipMapper;
@Component
@Service
public class MemberDropService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String memId) {
		memberShipMapper.memberDrop(memId);
	}
}
