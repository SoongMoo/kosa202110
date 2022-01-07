package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController extends HttpServlet implements Servlet{
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException{
		String requestURI =  request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/goodsList.gd")) {
			GoodsListController action = new GoodsListController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsEnter.gd")) {
			GoodsAutoNumController action = new GoodsAutoNumController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.gd")) {
			GoodsProController action = new GoodsProController();
			try {
				action.execute(request);
			}catch(Exception e) {e.printStackTrace();}
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/goodsInfo.gd")) {
			GoodsInfoController action =
					new GoodsInfoController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/goods/goodsInfo.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
