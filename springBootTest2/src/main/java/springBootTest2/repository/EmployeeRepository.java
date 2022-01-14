package springBootTest2.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class EmployeeRepository {
	private final String namespace="mappers.employees.employeeMapper";
	@Autowired 
	private SqlSession sqlSession;
	public Integer selectAll() {
		String statement = namespace + ".selectAll";
		return sqlSession.update(statement);
	}
	public Integer empDelete(String empNum) {
		String statement = namespace + ".empDelete";
		return sqlSession.update(statement,empNum);
	}
}
