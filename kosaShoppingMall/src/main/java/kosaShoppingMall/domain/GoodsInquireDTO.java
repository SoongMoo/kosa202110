package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsInquireDTO")
public class GoodsInquireDTO {
	Integer inquireNum;
	String memberNum;
	String goodsNum;
	String inquireKind;
	String inquireSubject;
	String inquireContent;
	Date inquireDate;
	String answerEmail;
	String inquireAnswer;
	Date answerDate;
	
	GoodsDTO goodsDTO;
	MemberDTO memberDTO;
}
