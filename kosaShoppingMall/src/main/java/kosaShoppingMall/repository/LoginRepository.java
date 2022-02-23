package kosaShoppingMall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapperImpl;
@Repository
public class LoginRepository implements LoginMapperImpl {
	@Autowired
	SqlSession sqlSession;
	String namespace="kosaShoppingMall.mapper.LoginMapper";
	String statement;
	@Override
	public AuthInfo loginSelect(String id) {
		statement = namespace + ".loginSelect";
		return sqlSession.selectOne(statement, id);

	}
	@Override
	public AuthInfo findId(String email) {
		statement = namespace + ".findId";
		return sqlSession.selectOne(statement, email);
	}
	@Override
	public String findPw(FindPasswordCommand findPasswordCommand) {
		statement = namespace + ".findPw";
		return sqlSession.selectOne(statement, findPasswordCommand);
	}
}