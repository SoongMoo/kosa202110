package kosaShoppingMall.service.goods;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class GoodsListPageSerivce {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	LoginMapper loginMapper;
	public void execute(HttpServletRequest request) {
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length >0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().startsWith("id")) {
					request.setAttribute("isId", cookie.getValue());
				}
				if(cookie.getName().equals("autoLogin")) {
					AuthInfo authInfo = loginMapper.loginSelect(cookie.getValue());
					HttpSession session = request.getSession();
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
		List<GoodsDTO> list = goodsMapper.goodsList(new StartEndPageDTO());
		request.setAttribute("lists", list);
	}
}
