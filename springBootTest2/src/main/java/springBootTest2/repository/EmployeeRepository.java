package springBootTest2.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.EmployeeDTO;

@Component
@Repository
public class EmployeeRepository {
	private final String namespace="mappers.employees.employeeMapper";
	@Autowired 
	private SqlSession sqlSession;
	public List<EmployeeDTO> selectAll() {
		String statement = namespace + ".selectAll";
		return sqlSession.selectList(statement);
	}
	public Integer empDelete(String empNum) {
		String statement = namespace + ".empDelete";
		return sqlSession.update(statement,empNum);
	}
}
