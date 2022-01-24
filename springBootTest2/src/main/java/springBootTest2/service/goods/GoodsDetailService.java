package springBootTest2.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("dto", dto);
	}
}
