package kosaShoppingMall.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.MemberMapper;
@Service
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model, Integer page) {
		int limit = 3; 
		int limitPage = 10 ;
		// page = 2;  startRow = 11, endRow = 20
		// page = 3;  startRow = 21, endRow = 30
		// page = 4;  startRow = 31, endRow = 40
		Long startRow = ((long)page - 1 ) * limit + 1 ;
		Long endRow = startRow + limit -1;		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
	    //  레코드의 전체의 갯수 
		int count = memberMapper.memberCount();
		List<MemberDTO> lists = memberMapper.selectAll(dto);
		int maxPage = (int)((double)count / limit + 0.9); // 22 / 10 = 2.2 + 0.9
		// page = 4;  startPage = 1,   endPage 10
		// page = 14;  startPage = 11,   endPage 20
		// page = 24;  startPage = 21,   endPage 30
		// 토탈 page : 25
		int startPage = ((int)((double)page / limitPage + 0.9 ) -1 ) * limitPage + 1 ;
		//                        24 / 10 = 2.4 + 0.9 = 3.3 => 3 - 1 = 2 * 10 + 1 = 21
	    int endPage = startPage + limitPage -1;
	    if(endPage > maxPage) endPage = maxPage;
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		
		model.addAttribute("lists", lists);
	}
}
