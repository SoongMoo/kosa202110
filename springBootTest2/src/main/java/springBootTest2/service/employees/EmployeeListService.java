package springBootTest2.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmployeeDTO;
import springBootTest2.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	//EmployeeRepository employeeRepository;
	public void execute(Model model) {
		List<EmployeeDTO> list = employeeMapper.selectAll();
		//List<EmployeeDTO> list = employeeRepository.selectAll();
		model.addAttribute("list", list);
	}
}
