package kosaShoppingMall.service.goodsIpgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;
@Service
public class GoodsIpgoDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, String ipgoDate, Model model) {
		GoodsIpgoDTO idto = new GoodsIpgoDTO();
		idto.setGoodsNum(goodsNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			idto.setIpgoDate(sdf.parse(ipgoDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GoodsIpgoGoodsDTO dto = goodsMapper.ipgoDetail(idto);
		model.addAttribute("goodsIpgoGoodsCommand", dto);		
	}

}
