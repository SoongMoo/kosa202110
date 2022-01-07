package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsInfoController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		GoodsDAO dao =  new GoodsDAO();
		GoodsDTO dto = dao.selectOne(num);
		request.setAttribute("dto", dto);
	}
}
