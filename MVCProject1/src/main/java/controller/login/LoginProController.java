package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;

public class LoginProController {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		int i = dao.loginCk(id, pw);
		System.out.println(i); // 1 =  아이디와 비밀번호가 일치 , 0 = 아이디는 존재하지만 비밀번호가 틀림
		                       // -1 = 아이디가 존재하지 않음
		HttpSession session = request.getSession(); // 세션 생성
		
		if(i == 1) {
			//session속성이 id라는 속성이 있다면 로그인된 상태로 정함.
			session.setAttribute("id", id); 
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/");
		}else if(i == 0){ // 비밀번호가 틀림
			request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			request.setAttribute("userId", id);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else if(i == -1) {  // 아이디가 존재하지 않음
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
