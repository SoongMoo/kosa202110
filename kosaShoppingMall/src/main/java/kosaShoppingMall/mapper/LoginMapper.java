package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;

@Component
@Repository(value = "kosaShoppingMall.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo loginSelect(String id);
}
