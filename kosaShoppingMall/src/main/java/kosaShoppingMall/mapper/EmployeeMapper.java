package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Repository
public interface EmployeeMapper {
	public Integer employeeInsert(EmployeeDTO dto);
	//페이징
	public Integer count();
	public List<EmployeeDTO> selectAll(StartEndPageDTO dto);
	//끝
	public EmployeeDTO selectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer employeeDelete(String empId);
	public Integer empDeletes(List<String> cs);
	/// employeesMyPage서비스
	public Integer employeePwChange(EmployeeDTO dto);
	public Integer changPw(AuthInfo authInfo);
	
}
