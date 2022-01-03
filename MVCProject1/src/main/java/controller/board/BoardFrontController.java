package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController 
		extends HttpServlet
		implements javax.servlet.Servlet{
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardList.kosa")) {
			BoradListController action = new BoradListController();
			action.execute(request);
			// request.setAttribute()
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWrite.kosa")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardRegist.kosa")) {
			BoardWriteContoller action = new BoardWriteContoller();
			action.execute(request);
			System.out.println(request.getParameter("boardWriter"));
			response.sendRedirect("boardList.kosa");
		}else if(command.equals("/boardDetail.kosa")) {
			BoardVisitCountController visit = new BoardVisitCountController();
			visit.execute(request);
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/board/boardInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDel.kosa")) {
			BoardDelController action = new BoardDelController();
			action.execute(request);
			response.sendRedirect("boardList.kosa");
		}else if(command.equals("/boardUpdate.kosa")) {
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/board/boardModifyForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.kosa")) {
			BoardModifyController action = new BoardModifyController();
			action.execute(request);
			response.sendRedirect("boardDetail.kosa?num="+
										request.getParameter("boardNum"));
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}