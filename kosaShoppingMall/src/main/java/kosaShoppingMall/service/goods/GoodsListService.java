package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, String goodsWord, int page) {
		int limit = 3; 
		int limitPage = 10 ;
		Long startRow = ((long)page - 1 ) * limit + 1 ;
		Long endRow = startRow + limit -1;		
		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		dto.setGoodsWord(goodsWord);
		
		int count = goodsMapper.count(goodsWord);
		List<GoodsDTO> list = goodsMapper.goodsList(dto);
		
		int maxPage = (int)((double)count / limit + 0.9);
		int startPage = ((int)((double)page / limitPage + 0.9 ) -1 ) * limitPage + 1 ;
	    int endPage = startPage + limitPage -1;
	    if(endPage > maxPage) endPage = maxPage;
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("goodsWord", goodsWord);

		model.addAttribute("list",list);
	}
	
}
