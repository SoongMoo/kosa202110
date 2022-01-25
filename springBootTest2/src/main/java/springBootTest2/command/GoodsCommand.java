package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date goodsDate;
	String goodsContent;
	Integer goodsQty;
	String goodsCompany;
	MultipartFile [] goodsImage; 
}


