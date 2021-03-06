package controller.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet implements Servlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = URLDecoder.decode(request.getRequestURI(),"utf-8");
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/게시글목록.bd")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/게시글쓰기.bd")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boradWrite.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/게시글등록.bd")) {
			BoardWriteController action = new BoardWriteController();
			action.execute(request);
			response.sendRedirect(URLEncoder.encode("게시글목록.bd","utf-8"));
		}
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = URLDecoder.decode(request.getRequestURI(),"utf-8");
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/게시글등록.bd")) {
			BoardWriteController action = new BoardWriteController();
			action.execute(request);
			response.sendRedirect(URLEncoder.encode("게시글목록.bd","utf-8"));
		}
	}
}