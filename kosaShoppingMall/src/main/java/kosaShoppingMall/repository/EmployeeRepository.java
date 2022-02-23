package kosaShoppingMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="kosaShoppingMall.mapper.EmployeeMapper";
	String statement;
	public Integer employeeInsert(EmployeeDTO dto) {
		statement = namespace + ".employeeInsert";
		return sqlSession.insert(statement, dto);
	}
	//페이징
	public Integer count() {
		statement = namespace + ".count";
		return sqlSession.selectOne(statement);
	}
	public List<EmployeeDTO> selectAll(StartEndPageDTO dto){
		statement = namespace + ".selectAll";
		return sqlSession.selectList(statement, dto);
	}
	//끝
	public EmployeeDTO selectOne(String empId){
		statement = namespace + ".selectOne";
		return sqlSession.selectOne(statement, empId);
	}
	public Integer employeeUpdate(EmployeeDTO dto){
		statement = namespace + ".employeeUpdate";
		return sqlSession.update(statement, dto);
	}
	public Integer employeeDelete(String empId){
		statement = namespace + ".employeeDelete";
		return sqlSession.update(statement, empId);
	}
	public Integer empDeletes(List<String> cs){
		statement = namespace + ".empDeletes";
		return sqlSession.delete(statement,  cs);
	}
	/// employeesMyPage서비스
	public Integer employeePwChange(EmployeeDTO dto){
		statement = namespace + ".employeePwChange";
		return sqlSession.delete(statement,  dto);
	}
	public Integer changPw(AuthInfo authInfo){
		statement = namespace + ".changPw";
		return sqlSession.delete(statement,  authInfo);
	}
}