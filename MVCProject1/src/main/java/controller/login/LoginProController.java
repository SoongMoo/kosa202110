package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginProController {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.loginCk(id, pw);
		
		HttpSession session = request.getSession(); // 세션 생성
		
		String storeId = request.getParameter("storeId");		
		String autoLogin = request.getParameter("autoLogin");
		
		if(authInfo==null) {// 아이디가 존재 하지 않음 i == -1
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			if(pw.equals(authInfo.getUserPw())) {//아이디와 비밀번호가 같음 i == 1
				//session속성이 id라는 속성이 있다면 로그인된 상태로 정함.
				session.setAttribute("authInfo", authInfo); 
				// 로인한 후 쿠키 생성
				if(storeId != null && storeId.equals("store")) {
			// 쿠키는 사용자 컴퓨터에 파일로 저장되므로 객체를 저장할 수 없고
			// 문자열만 저장 가능하다.		
					Cookie cookie = new Cookie("storeId",id);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
					System.out.println(cookie.getValue());
				}else {
					Cookie cookie = new Cookie("storeId",id);
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if(autoLogin != null && autoLogin.equals("autoLogin")) {
					Cookie cookie = new Cookie("autoLogin",id);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/");
			}else { // i == 0
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
				request.setAttribute("userId", id);
				
				Cookie [] cookies = request.getCookies();
				if(cookies != null && cookies.length > 0) {
					for(Cookie c : cookies) {
						if(c.getName().startsWith("stor")) {
							request.setAttribute("isId", c.getValue());
						}
					}
				}
				
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				
			}
		}
	}
}
