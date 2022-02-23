package kosaShoppingMall.mapper;

import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;

public interface LoginMapperImpl {
	public AuthInfo loginSelect(String id);
	public AuthInfo findId(String email);
	public String findPw(FindPasswordCommand findPasswordCommand);
}
