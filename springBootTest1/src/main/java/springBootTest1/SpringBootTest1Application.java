package springBootTest1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("springBootTest1")
@MapperScan("springBootTest1.repository")
public class SpringBootTest1Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest1Application.class, args);
	}

}
