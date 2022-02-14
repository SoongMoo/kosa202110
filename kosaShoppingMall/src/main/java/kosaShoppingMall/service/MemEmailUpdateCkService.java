package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class MemEmailUpdateCkService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String memberEmail, String memberId) {
		AuthInfo authInfo = loginMapper.findId(memberEmail);
		if(authInfo != null) {
			if(authInfo.getUserId().equals(memberId)){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 0;
		}
	}
}
