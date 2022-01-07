package controller.goods;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.EmployeeDAO;
import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsProController {
	public void execute(HttpServletRequest request) throws Exception {
		String path = "/goods/upload";
		String realPath = request.getServletContext().getRealPath(path);
		// c:/
		int fileSize = 1024 * 1024 * 5;
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		// 직원 id로 직원 번호 가져오기
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = dao.selectEmpNum(empId);
		String ipAddr = request.getRemoteAddr();

		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

		String goodsNum = multi.getParameter("goodsNum");
		String goodsName = multi.getParameter("goodsName");
		String goodsPrice = multi.getParameter("goodsPrice");
		String goodsContent = multi.getParameter("goodsContent");
		String goodsQty = multi.getParameter("goodsQty");
		String goodsCompany = multi.getParameter("goodsCompany");
		String img1 = multi.getFilesystemName("img1");
		String img2 = multi.getFilesystemName("img2");
		String img3 = multi.getFilesystemName("img3");
		
		String goodsDate = multi.getParameter("goodsDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(goodsDate);
		Timestamp gDate = new Timestamp(date.getTime());

		GoodsDTO dto = new GoodsDTO();
		dto.setEmpNum(empNum);
		dto.setGoodsCompany(goodsCompany);
		dto.setGoodsContent(goodsContent);
		dto.setGoodsDate(gDate);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsQty(Integer.parseInt(goodsQty));
		dto.setIpAddr(ipAddr);
		dto.setGoodsImages(img1 + "`" + img2 + "`" + img3);
		System.out.println(dto.getGoodsImages());

		GoodsDAO dao1 = new GoodsDAO();
		dao1.goodsInsert(dto);
	}
}





