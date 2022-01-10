package springTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringTestApplication {
	@RequestMapping("/123")
	public String ttt() {
		return "1213456789";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

}
