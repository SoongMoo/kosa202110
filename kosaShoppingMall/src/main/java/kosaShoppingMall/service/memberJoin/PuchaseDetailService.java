package kosaShoppingMall.service.memberJoin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.MemberShipMapper;

@Service
public class PuchaseDetailService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum, Model model) {
		List<OrderListDTO> list = memberShipMapper.purchaseDetail(purchaseNum);
		model.addAttribute("list", list);
	}

}
