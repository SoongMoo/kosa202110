package springBootTest1.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest1.domain.EmployeeDTO;

@Component
@Repository(value = "springBootTest1.repository.EmployeeRepository")
public interface EmployeeRepository {
	public Integer employeeInsert(EmployeeDTO dto);
}
