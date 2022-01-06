package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		
		if(authInfo==null) {// 아이디가 존재 하지 않음 i == -1
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			if(pw.equals(authInfo.getUserPw())) {//아이디와 비밀번호가 같음 i == 1
				//session속성이 id라는 속성이 있다면 로그인된 상태로 정함.
				session.setAttribute("authInfo", authInfo); 
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/");
			}else { // i == 0
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
				request.setAttribute("userId", id);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
