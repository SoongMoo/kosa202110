package kosaShoppingMall;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kosaShoppingMall.Interceptor.CertificationInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer{	

	//@Override
	//public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
	//	registry.addInterceptor(new CertificationInterceptor())
	//	        .addPathPatterns("/**/*") //모든 주소
	//	        .excludePathPatterns("/static/**/*")
	//	        .excludePathPatterns("/register/**/*")
	//	        .excludePathPatterns("/help/**/*")
	//			.excludePathPatterns("/login/**/*");
		// 로그인 세션이 없어도 되는 주소들을 적어 준다.
	//}
	
	// html이나 jsp문서에서 view밑에 있는 파일을 불러 올때 404오류가 나는 것을 방지
	@Override
	public void addResourceHandlers(
			ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
        .addResourceLocations("/view/")
        .setCachePeriod(14400);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source= new ResourceBundleMessageSource();
		source.setBasenames("message/error");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("utf-8");
		return source;
	}
	
	
}