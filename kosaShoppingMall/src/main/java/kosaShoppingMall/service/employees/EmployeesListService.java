package kosaShoppingMall.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmployeesListService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Model model) {
		List<EmployeeDTO> list = employeeMapper.selectAll();
		model.addAttribute("list",list);
	}
}
