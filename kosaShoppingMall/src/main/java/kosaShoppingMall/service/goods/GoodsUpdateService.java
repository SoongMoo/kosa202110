package kosaShoppingMall.service.goods;

import java.io.File;
import java.util.ArrayList;
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
		
		
		
		/// session에 삭제하려는 파일 정보
		List<FileInfo> list = (List<FileInfo>)session.getAttribute("fileList");
		/// 이미지 정보를 가져오기 위해서 
		GoodsDTO lib = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());
		
		/// 데이터베이스에 있는 파일정보를 dto에 저장
		dto.setGoodsImages(lib.getGoodsOriginal());
		dto.setGoodsOriginal(lib.getGoodsOriginal());
		
		// dto에 저장된 팡리 정보를 스플릿 후 리스트에 저장
		List<String> orgFile = new ArrayList<String>();
		List<String> strFile = new ArrayList<String>();
		for(String s : dto.getGoodsOriginal().split("`")) {
			orgFile.add(s);
		}
		for(String s : dto.getGoodsImages().split("`")) {
			strFile.add(s);
		}
		
		// file삭제 session이 있다면 데이터베이스에서 dto에서 삭제
		System.out.println(lib.getGoodsOriginal());
		if(list != null) {
			for (FileInfo fi : list) { // session에 있는 내용과 비교하여 리스트에 있는 파일정보 삭제
				for (int i = 0; i < orgFile.size(); i++) {
					if (fi.getOrgFile().equals(orgFile.get(i)) && fi.getKind().equals("img")) {
						orgFile.remove(i); 
						strFile.remove(i);
					}
				}

			}
			String o = "";
			String s = "";
			// 리스트에 있는 내용을 문자열로 변경
			for(String str : orgFile) {
				o += str+"`";
			}
			for(String str : strFile) {
				s += str +"`";
			}
			// 문자열을 dto에 저장
			dto.setGoodsOriginal(o); // session에 있는 것은 지우고 session에 없는 것만 저장
			dto.setGoodsImages(s);
		}

		
		String fileDir = "/view/goods/upload";
		String filePath=session.getServletContext().getRealPath(fileDir);
		// 메인 이미지 저장
		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()){
			MultipartFile mf = goodsCommand.getGoodsMain();
			String originalFile = mf.getOriginalFilename();
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
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
			if(lib.getGoodsImages() != null) {
				storeTotal = dto.getGoodsImages();
				originalTotal =  dto.getGoodsOriginal();
			}
			for(MultipartFile mf : goodsCommand.getGoodsImages() ) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
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
		}
		
		
		
		goodsMapper.goodsUpdate(dto);
		

		// update 된 후에는 session에 있는 파일 삭제
		if(list != null) {
			for(FileInfo fi : list ) {
				if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
					if(fi.getKind().equals("main")) {
						File file = new File(filePath + "/" + fi.getStrFile().replace("`", ""));
						if(file.exists()) file.delete();
					}
				}
				if(fi.getKind().equals("img")) {
					File file = new File(filePath + "/" + fi.getStrFile().replace("`", ""));
					if(file.exists()) file.delete();
				}
			}
			session.removeAttribute("fileList");
		}	
	}
}
