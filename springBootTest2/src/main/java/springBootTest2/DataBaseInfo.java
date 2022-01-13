package springBootTest2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseInfo {
	@Bean
	public SqlSessionFactory sqlSessionFactory(
			DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory =
				new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}
