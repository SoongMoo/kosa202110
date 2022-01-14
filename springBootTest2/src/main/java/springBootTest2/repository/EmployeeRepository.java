package springBootTest2.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepository {
	private final String namespace="mappers.EmployeeMapper";
	@Autowired 
	private SqlSession sqlSession;
	public Integer selectAll() {
		String statement = namespace + ".selectAll";
		return sqlSession.update(statement);
	}
}
