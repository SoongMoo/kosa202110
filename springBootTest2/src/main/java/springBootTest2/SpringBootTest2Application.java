package springBootTest2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(value = "springBootTest2")
@MapperScan(value = {"springBootTest2"})
//@RestController
public class SpringBootTest2Application {
//	@RequestMapping("/")
//	public String test() {
//		return "스프링부트가 잘 실행되네요.";
//	}
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootTest2Application.class, args);
	}
}
