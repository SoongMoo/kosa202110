package kosaShoppingMall.service.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsDelsService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String[] deletes) {
		/*
		//배열을 이용한 방법
		goodsMapper.goodsDels(deletes);
		*/
		
		// 리스트를 전달 하는 방법
		List<String> cs  = new ArrayList<String>();		
		for(String num : deletes) {
			cs.add(num);
		}
		//goodsMapper.goodsDeletes(cs);
		
		HashMap<String, Object> condition = new HashMap<String, Object>();
		// 배열을 map에 저장하여 전달하는 방법
		//condition.put("goodsNums", deletes);
		// 리스트를 map에 저정하여 전달하는 방법
		condition.put("goodsNums", cs);
		goodsMapper.goodsRemove(condition);
	}
	
}
