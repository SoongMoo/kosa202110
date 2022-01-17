package springBootTest2.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.EmployeeCommand;
import springBootTest2.domain.EmployeeDTO;
import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.repository.EmployeeRepository;

@Component
@Service
public class EmployeeWriteService {
	@Autowired
	//EmployeeMapper employeeMapper;
	EmployeeRepository employeeRepository;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPw(employeeCommand.getEmpPw());
		dto.setEmpSalary(employeeCommand.getEmpSalary());
		System.out.println(employeeCommand.getEmpSalary());
		Integer i = employeeRepository.employeeInsert(dto);
		//Integer i = employeeMapper.employeeInsert(dto);
		System.out.println(i + "개 행이(가) 삽입되었습니다.");
	}
}
