package controller.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeListController {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.selectAll();
		request.setAttribute("list", list);
	}
}
