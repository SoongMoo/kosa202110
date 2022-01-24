package springBootTest2.service.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmployeeDTO;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsRegistService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void execute(GoodsCommand goodsCommand,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String  empNum = employeeMapper.selectEmpNum(authInfo.getUserId());
		GoodsDTO dto = new GoodsDTO();
		dto.setEmpNum(empNum);
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsCompany(goodsCommand.getGoodsCompany());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsDate(goodsCommand.getGoodsDate());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		goodsMapper.goodsInsert(dto);
	}
}
