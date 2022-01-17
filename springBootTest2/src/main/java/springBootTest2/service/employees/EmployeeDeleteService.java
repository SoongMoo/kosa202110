package springBootTest2.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.repository.EmployeeRepository;

@Component
@Service
public class EmployeeDeleteService {
	@Autowired 
	//EmployeeMapper employeeMapper;
	EmployeeRepository employeeRepository;
	public void execute(String empNum) {
		//employeeMapper.empDelete(empNum);
		employeeRepository.empDelete(empNum);
	}
}
