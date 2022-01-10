package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsDeleteController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		String goodsImages =  dao.getImages(goodsNum);
		// me11.gif`me1.png`title11.png
		String [] fileImages = goodsImages.split("`");
		// fileImages = {"me11.gif", "me1.png", "title11.png"}
		if(fileImages.length >= 1) {
			String path = "/goods/upload";
			// 파일의 절대 경로 디렉터리를 가져 옴
			String realPath = request.getServletContext().getRealPath(path);
			File file = null;
			for(String fileName : fileImages) {
				file = new File(realPath + "/" + fileName);
				if(file.exists()) file.delete();
			}
		}
		dao.goodsDelete(goodsNum);	
	}
}