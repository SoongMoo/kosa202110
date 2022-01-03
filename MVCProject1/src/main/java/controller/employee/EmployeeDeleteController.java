package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;

public class EmployeeDeleteController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		EmployeeDAO dao = new EmployeeDAO();
		dao.empDelete(num);
	}
}
