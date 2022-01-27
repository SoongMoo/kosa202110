package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.EmployeeDTO;

@Repository
public interface EmployeeMapper {
	public Integer employeeInsert(EmployeeDTO dto);
	public List<EmployeeDTO> selectAll();
	public EmployeeDTO selectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer employeeDelete(String empId);
}
