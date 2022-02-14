package kosaShoppingMall.service.employees;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.EmployeeMapper;

@Service
public class EmployeeDelsService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(String[] delete) {
		List<String> cs = new ArrayList<String>();
		for(String num : delete) {
			cs.add(num);
		}
		employeeMapper.empDeletes(cs);
		
	}
	
}
