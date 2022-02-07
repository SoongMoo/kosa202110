package kosaShoppingMall.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kosaShoppingMall.domain.AuthInfo;

public class CertificationInterceptor implements 
		HandlerInterceptor{
	//컨트롤러(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작.
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		AuthInfo authInfo =
				(AuthInfo)session.getAttribute("authInfo");
		if(ObjectUtils.isEmpty(authInfo)) {
			response.sendRedirect("/");
			return false;
		}else {
			return true;
		}
	}
	// 컨트롤러 진입 후 view가 랜더링 되기 전 수행이 됩니다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	//컨트롤러 진입 후 view가 정상적으로 랜더링 된 후 제일 마지막에 실행이 되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
