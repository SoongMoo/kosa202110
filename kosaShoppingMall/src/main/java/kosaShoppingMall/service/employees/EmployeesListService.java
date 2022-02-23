package kosaShoppingMall.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.repository.EmployeeRepository;

@Component
@Service
public class EmployeesListService {
	@Autowired
	//EmployeeMapper employeeMapper;
	EmployeeRepository employeeRepository;
	public void execute(Integer page, Model model) {
		int limit =2; // 클릭할 페이지의 수
		int limitPage=2; // 보이는 페이지의 수?
		
		Long strartRow = ((long)page - 1)*limit+1; //페이지에 보일 게시글의 수
		Long endRow = strartRow+limit -1; // ????
		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(strartRow);
		dto.setEndRow(endRow);
		
		int count = employeeRepository.count();//ex 101
		List<EmployeeDTO> list = employeeRepository.selectAll(dto);
		
		int maxPage = (int)((double)count/limit +0.9); //101/10 +0.9//11
		int startPage = ((int)((double)page /limitPage+0.9) -1) *limitPage +1; //2 /10=.2+.9= 1.1-1= 0.1*10 =1 + 1 = 2 goods!어렵다..
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		model.addAttribute("maxPage" , maxPage);
		model.addAttribute("startPage" , startPage);
		model.addAttribute("endPage" , endPage);
		model.addAttribute("page" , page);
		model.addAttribute("list",list);
	}
}
