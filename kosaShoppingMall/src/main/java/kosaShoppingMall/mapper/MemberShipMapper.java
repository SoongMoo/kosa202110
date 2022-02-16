package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.GoodsCartDTO;
import kosaShoppingMall.domain.MemberDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public MemberDTO selectOne(String memid);
	public Integer memberInsert(MemberDTO dto);
	public Integer memberUpdate(MemberDTO dto);
	public Integer updatePassword(MemberDTO dto);
	public Integer memberDrop(String memId);
	public List<GoodsCartDTO> cartList(String memberNum);
	public Integer goodsCartQtyDown(CartDTO dto);
	public List<GoodsCartDTO> goodsOrder(GoodsBuy goodsBuy);
}
