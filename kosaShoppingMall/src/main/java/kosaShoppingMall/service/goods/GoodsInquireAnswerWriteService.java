package kosaShoppingMall.service.goods;

import java.util.HashMap;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class GoodsInquireAnswerWriteService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	JavaMailSender mailSender;
	public void execute(String memberNum, Integer inquireNum, String inquireAnswer, String answerEmail,String inquireSubject) {
		GoodsInquireDTO goodsInquireDTO = new GoodsInquireDTO();
		goodsInquireDTO.setInquireNum(inquireNum);
		goodsInquireDTO.setInquireAnswer(inquireAnswer);
		goodsMapper.setInquireAnswer(goodsInquireDTO);
		MemberDTO memberDTO = memberMapper.selectDTO(memberNum);
		
		MimeMessage msg = mailSender.createMimeMessage();
		String content = "<html><body>"
				+ "안녕하세요. 숭무 쇼핑몰입니다. <BR />"
				+ memberDTO.getMemberName() + "님 문의하신 "+inquireSubject+"에 대한 답변이 등록 되었습니다.<br />"
				+ "</body></html>";
		String subject = "답변 안내";
		try {
			msg.setHeader("content-type", "text/html; charset=UTF-8");
			msg.setContent(content,"text/html; charset=UTF-8");
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress("sender@gmail.com")); // 보내는 사람
			msg.setRecipient(MimeMessage.RecipientType.TO , new InternetAddress(answerEmail)); // 받는 사람
			mailSender.send(msg); // 메일보내기
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		String api_key = "NCSW6VCZXODXGPOX";
		String api_secret = "UZMGJ9ADCK2LCTIEWQRITSVRXW3J0B3T";
		Message coolsms = new Message(api_key, api_secret);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", memberDTO.getMemberPhone());// 수신번호
		params.put("from", "01071461970");// 발신번호
		content = "안녕하세요. 숭무쇼핑몰입니다.\n" + memberDTO.getMemberName() 
		        + "님이 문의하신 '" + inquireSubject + "'에 대한 답변이 등록 되었습니다.";
		if(content.length() > 80) {
			params.put("type", "LMS");
		}else {
			params.put("type", "SMS");
		}
		params.put("text",content);
		params.put("app_version", "JAVA SDK v2.2");
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		}catch(CoolsmsException e) {
			e.printStackTrace();
		}
	}

}
