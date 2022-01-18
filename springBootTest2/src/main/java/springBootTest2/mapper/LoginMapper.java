package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.AuthInfo;

@Component
@Repository(value = "springBootTest2.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo loginSelect(String id);
}
