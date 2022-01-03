package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeInfoController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.selectOne(num);
		request.setAttribute("dto", dto);	
	}
}
