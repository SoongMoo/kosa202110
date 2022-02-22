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
	String email1;
	String email2;
	String memberId;
	String inquireAnswer;
	Date answerDate;
}
