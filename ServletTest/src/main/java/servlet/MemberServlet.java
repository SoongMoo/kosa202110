package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet{
	@Override
	protected void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String str = request.getParameter("forward");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(str.equals("main")) {
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("<a href='search?forward=next'>다음 페이지</a>");
			out.print("</body></html>");
		}else if(str.equals("next")) {
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("다음페이지입니다.");
			out.print("</body></html>");
		}
	}
}