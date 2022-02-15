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
		Integer i = goodsMapper.goodsDelete(goodsNum);
		if(i > 0 ) {
			String fileDir = "/view/goods/upload";
			String filePath=request.getServletContext().getRealPath(fileDir);
			
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
