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
	private final String namespace="springBootTest2.mapper.EmployeeMapper";
	@Autowired 
	private SqlSession sqlSession;
	public List<EmployeeDTO> selectAll() {
		String statement = namespace + ".selectAll";
		return sqlSession.selectList(statement);
	}
	public Integer empDelete(String empNum) {
		String statement = namespace + ".empDelete";
		return sqlSession.update(statement,empNum);
	}public EmployeeDTO selectOne(String empNum) {
		String statement = namespace + ".selectOne";
		return sqlSession.selectOne(statement,empNum);
	}
	public Integer empUpdate(EmployeeDTO dto) {
		String statement = namespace + ".empUpdate";
		return sqlSession.update(statement,dto);
	}
	public Integer employeeInsert(EmployeeDTO dto) {
		String statement = namespace + ".employeeInsert";
		return sqlSession.update(statement,dto);
	}
}
