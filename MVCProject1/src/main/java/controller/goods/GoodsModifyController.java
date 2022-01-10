package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsModifyController {
	public void execute(HttpServletRequest  request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(goodsNum);
		request.setAttribute("dto", dto);
	}
}
