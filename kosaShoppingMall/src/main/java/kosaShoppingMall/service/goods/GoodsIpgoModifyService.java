package kosaShoppingMall.service.goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsIpgoModifyService {
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
		//GoodsIpgoGoodsDTO dto = goodsMapper.ipgoDetail(idto);
		GoodsDTO dto = goodsMapper.getGoodsIpgoInfo(idto);
		model.addAttribute("goodsIpgoGoodsCommand", dto);	
	}

}
