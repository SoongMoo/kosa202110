package kosaShoppingMall.service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
	////////////////////////////////////////////////////////////////////////////////////////
		String fileDir = "/view/goods/upload";
		String filePath = request.getServletContext().getRealPath(fileDir);

		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()){
			MultipartFile mf = goodsCommand.getGoodsMain();
			String originalFile = mf.getOriginalFilename();
			
			//.png
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			
			//7b2582aca35e4525b4a579d84e8b6c9d
			String storeName = UUID.randomUUID().toString().replace("-", "");
			
			String storeFileName=storeName + extension;
			
			File file = new File(filePath + "/" + storeFileName);
			try {
				mf.transferTo(file); // 파일을 저장
			}catch(Exception e) {e.printStackTrace();}
			dto.setGoodsMainOrg(originalFile);
			dto.setGoodsMain(storeFileName);
		}
		
		if(!goodsCommand.getGoodsImages()[0].getOriginalFilename().isEmpty() ) {
			String storeTotal = "";
			String originalTotal = "";
			for(MultipartFile mf : goodsCommand.getGoodsImages() ) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName=storeName + extension;// 저장할 때 사용할 파일명
				storeTotal += storeFileName +"`";
				originalTotal += originalFile + "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file); // 파일을 저장
				}catch(Exception e) {e.printStackTrace();}
			}
			dto.setGoodsOriginal(originalTotal);
			dto.setGoodsImages(storeTotal);
		}

		
		Integer i = goodsMapper.goodsInsert(dto);
		System.out.println(i +"개의 상품이 등록되었습니다.");
	}
}