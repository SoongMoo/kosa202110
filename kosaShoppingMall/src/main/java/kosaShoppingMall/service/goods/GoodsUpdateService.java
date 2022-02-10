package kosaShoppingMall.service.goods;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kosaShoppingMall.command.FileInfo;
import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;
@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		
		List<FileInfo> list = 
				(List<FileInfo>)session.getAttribute("fileList");
		GoodsDTO lib = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());

		// file삭제 session이 있다면 데이터베이스에서 dto에서 삭제
		if(list != null) {
			for(FileInfo fi : list) {
				if(fi.getKind().equals("img")) {
					lib.setGoodsOriginal(lib.getGoodsOriginal().replace(fi.getOrgFile()+"`", ""));
					lib.setGoodsImages(lib.getGoodsImages().replace(fi.getStrFile()+"`", ""));
				}
			}
		}
				
		String fileDir = "/view/goods/upload";
		String filePath=session.getServletContext().getRealPath(fileDir);
		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()){
			System.out.println("zvzsvasv ");
			MultipartFile mf = goodsCommand.getGoodsMain();
			String originalFile = mf.getOriginalFilename();
			String extension = originalFile.substring(
					originalFile.lastIndexOf("."));
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
			String storeTotal = lib.getGoodsOriginal();
			String originalTotal = lib.getGoodsImages();
			for(MultipartFile mf : goodsCommand.getGoodsImages() ) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(
						originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName=storeName + extension;
				storeTotal += storeFileName +"`";
				originalTotal += originalFile + "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file); // 파일을 저장
				}catch(Exception e) {e.printStackTrace();}
			}
			dto.setGoodsOriginal(originalTotal);
			dto.setGoodsImages(storeTotal);
			System.out.println(dto.getGoodsImages());
			System.out.println(dto.getGoodsOriginal());
		}
		goodsMapper.goodsUpdate(dto);

		
		// update 된 후에는 session에 있는 파일 삭제
		if(list != null) {
			for(FileInfo fi : list ) {
				System.out.println(fi.getStrFile());
				File file = new File(filePath + "/" 
								+ fi.getStrFile().replace("`", ""));
				if(file.exists()) file.delete();
			}
			session.removeAttribute("fileList");
		}
		
	}

}
