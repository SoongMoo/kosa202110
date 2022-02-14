package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class EmpEmailUpdatecheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String empEmail, String empId) {
		AuthInfo authInfo = loginMapper.findId(empEmail);
		if(authInfo == null) {
			return 0;
		}else if(authInfo.getUserEmail().equals(empEmail)&&authInfo.getUserId().equals(empId)) {
			return 0;
		}else 
			return 1;
		
	}

}
