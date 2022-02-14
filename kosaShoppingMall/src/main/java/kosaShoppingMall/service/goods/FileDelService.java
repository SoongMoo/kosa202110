package kosaShoppingMall.service.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.FileInfo;


@Service
public class FileDelService {

	public void fileAdd(FileInfo fileInfo, HttpSession session, Model model) {
		// TODO Auto-generated method stub
		Integer num = 0;
		Boolean newFile = true;
		// session 이 있는 경우
		List<FileInfo> list  = (List<FileInfo>)session.getAttribute("fileList");
		// session 이 없는 경우
		if(list == null) {
			list = new ArrayList<FileInfo>();
		}
		
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getOrgFile().equals(fileInfo.getOrgFile())) { // list = 0 : 이숭무 , 1: 이상범 , 2: 이장범
				list.remove(i);                                          // list.remove(1)
				newFile = false;                                         // list = 0 : 이숭무  , 1: 이장범
				num =0;
			}
		}
		//  if문의 결과는 boolean타입이 이므로 boolean타입인 경우 비교연산을 하지 않아도 된다. 
		if(newFile) { // 논리 연산과 비교연산식 : boolean
			          // 3 > 2 : true
					  // true == true: true
					  // false == true: false
			list.add(fileInfo);
			num = 1;
		}
		session.setAttribute("fileList", list);
		model.addAttribute("val", num);
	}

}
