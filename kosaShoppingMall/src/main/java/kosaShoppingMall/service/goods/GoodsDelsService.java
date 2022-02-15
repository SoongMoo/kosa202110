package kosaShoppingMall.service.goods;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsDelsService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String[] deletes, HttpServletRequest request) {
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
		
		List<GoodsDTO> list = goodsMapper.goodsSelect(condition);		
		goodsMapper.goodsRemove(condition);
		String fileDir = "/view/goods/upload";
		String filePath= request.getServletContext().getRealPath(fileDir);
		for(GoodsDTO dto : list) {
			GoodsDTO d = goodsMapper.goodsSelectOne(dto.getGoodsNum()); // 삭재되었는지 확인
			if( d == null) { // 삭제 된 상태
				if(dto.getGoodsImages() != null) {
					String [] fileNames =  dto.getGoodsImages().split("`");
					for(String fileName : fileNames) {
						File f = new File(filePath + "/" + fileName);
						if(f.exists()) f.delete();
					}
				}
				
				String file = dto.getGoodsMain();
				File f = new File(filePath + "/" + file);
				if(f.exists()) f.delete();
			}
		}
	}
}





























