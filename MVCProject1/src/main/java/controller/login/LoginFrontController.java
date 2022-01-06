package controller.login;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFrontController extends HttpServlet implements Servlet {
	public void doProcess(HttpServletRequest request, 
				HttpServletResponse response) 
						throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/loginPro.login")) {
			LoginProController action = new LoginProController();
			action.execute(request,response);
		}else if(command.equals("/logout.login")) {
			Cookie cookie = new Cookie("autoLogin","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			/// 세션객체 생성
			HttpSession session = request.getSession();
			session.invalidate(); 
			response.sendRedirect(contextPath +"/");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
