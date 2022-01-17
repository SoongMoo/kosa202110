package springBootTest2.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmployeeDTO;
import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.repository.EmployeeRepository;

@Component
@Service
public class EmployeeInfoService {
	@Autowired
	//EmployeeMapper employeeMapper;
	EmployeeRepository employeeRepository;
	public void execute(String empNum, Model model) {
		//EmployeeDTO dto = employeeMapper.selectOne(empNum);
		EmployeeDTO dto = employeeRepository.selectOne(empNum);
		model.addAttribute("dto", dto);
	}
}
