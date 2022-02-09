package kosaShoppingMall.service.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, HttpServletRequest request) {
		
		GoodsDTO dto = goodsMapper.goodsSelectOne(goodsNum);
		String fileDir = "/view/goods/upload";
		String filePath=request.getServletContext().getRealPath(fileDir);
		String [] fileNames =  dto.getGoodsImages().split("`");
		String file = dto.getGoodsMain();
		for(String fileName : fileNames) {
			File f = new File(filePath + "/" + fileName);
			if(f.exists()) f.delete();
		}
		File f = new File(filePath + "/" + file);
		if(f.exists()) f.delete();
		
		goodsMapper.goodsDelete(goodsNum);
	}
}
