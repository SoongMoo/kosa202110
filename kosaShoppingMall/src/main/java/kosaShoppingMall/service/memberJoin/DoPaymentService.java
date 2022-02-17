package kosaShoppingMall.service.memberJoin;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.PaymentDTO;
import kosaShoppingMall.mapper.MemberShipMapper;
@Service
public class DoPaymentService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum, String totalPrice, String cardNumber, Model model) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setCardNumber(cardNumber);
		paymentDTO.setPaymentKind("카드");
		paymentDTO.setPaymentPrice(totalPrice);
		paymentDTO.setPurchaseNum(purchaseNum);
		String confirmNumber = UUID.randomUUID().toString().substring(0, 10);
		paymentDTO.setConfirmNumber(confirmNumber);
		memberShipMapper.payment(paymentDTO);
		memberShipMapper.purchaseStatus(purchaseNum);
		model.addAttribute("price", totalPrice);
	}

}
