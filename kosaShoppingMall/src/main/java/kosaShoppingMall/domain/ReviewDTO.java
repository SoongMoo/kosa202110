package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("reviewDTO")
public class ReviewDTO {
	Long reviewNum;
	String goodsNum;
	Date reviewDate;
	Integer score;
	String reviewContent;
	String purchaseNum;
	
	String memberId;
	String memberNum;
}
