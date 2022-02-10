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
		List<FileInfo> list = 
				(List<FileInfo>)session.getAttribute("fileList");
		if(list == null) {
			list = new ArrayList<FileInfo>();
		}
		Integer num = 0;
		Boolean newFile = true;
		for(int i = 0; i < list.size() ; i++ ) {
			if(list.get(i).getStrFile()
					.equals(fileInfo.getStrFile())) {
				list.remove(i);
				newFile = false;
				num = 0;
			}
		}
		if(newFile) {
			list.add(fileInfo);
			num = 1;
		}
		model.addAttribute("val", num);
		session.setAttribute("fileList", list);
	}

}
